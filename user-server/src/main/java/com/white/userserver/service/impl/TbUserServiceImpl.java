package com.white.userserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.white.userserver.common.Result;
import com.white.userserver.helper.JedisHelper;
import com.white.userserver.pojo.entity.TbResource;
import com.white.userserver.pojo.entity.TbRole;
import com.white.userserver.pojo.entity.TbUser;
import com.white.userserver.mapper.TbUserMapper;
import com.white.userserver.pojo.entity.TbUserRole;
import com.white.userserver.service.TbRoleService;
import com.white.userserver.service.TbUserRoleService;
import com.white.userserver.service.TbUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.white.userserver.util.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    private static final Logger logger = LoggerFactory.getLogger(TbUserServiceImpl.class);

    @Autowired
    private JedisHelper jedisHelper;

    @Autowired
    private TbUserRoleService tbUserRoleService;

    @Autowired
    private TbRoleService tbRoleService;

    @Override
    public Result login(TbUser tbUser) {
        if(tbUser.getUsername() == null){
            return Result.requestByError("username can not be null");
        }
        if(tbUser.getPassword() == null){
            return Result.requestByError("password can not be null");
        }
        tbUser = this.baseMapper.selectOne(tbUser);
        if(tbUser == null){
            return Result.requestByError("username or password can not be null");
        }
        String token = JwtUtil.sign(tbUser.getUsername(),tbUser.getPassword());

        //将获取到的token存放到redis中
        String userJson = JSON.toJSONString(tbUser);
        jedisHelper.STRINGS.set(token,userJson);
        jedisHelper.expire(token,30*60);

        //将获取到的觉得存放到redis中
        Integer userId = tbUser.getId();
        Wrapper<TbUserRole> wrapper = new EntityWrapper<>();
        wrapper.in("user_id",userId.toString());
        TbUserRole tbUserRole  = tbUserRoleService.selectOne(wrapper);
        Integer roleId = tbUserRole.getRoleId();
        Wrapper<TbRole> wrapper1 = new EntityWrapper<>();
        wrapper1.in("id",roleId.toString());
        TbRole tbRole = tbRoleService.selectOne(wrapper1);
        String key1 = "role_"+tbUser.getUsername();
        if(tbRole != null){
            jedisHelper.KEYS.del(key1);
            jedisHelper.SETS.sadd(key1,tbRole.getName());
        }

        //将获取到资源放到redis中
        List<TbResource> list = this.baseMapper.getResource(tbUser);

        String key = "permission_"+tbUser.getUsername();
        if(list != null &&list.size()>0){
            //保存之前 先将上次保留的数据进行清除
            jedisHelper.KEYS.del(key);
            for(TbResource tbResource:list){
                jedisHelper.SETS.sadd(key,tbResource.getPath());
            }
        }

        return Result.requestBySuccess(token);
    }

    @Override
    public Result getUserPage() {
//        Page<TbUser> tbUserPage = this.baseMapper.selectPage();
        Wrapper<TbUser> wrapper = new EntityWrapper<>();
        List<TbUser> list = this.baseMapper.selectList(wrapper);
        return Result.requestBySuccess(list);
    }
}

package com.white.user.controller.custom;

import com.white.user.common.Result;
import com.white.user.pojo.entity.TbUser;
import com.white.user.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Program: UserController
 * @Description:
 * @Author: White
 * @DateTime: 2019-11-13 16:52:21
 **/
@RestController
public class UserController implements Routes {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping(NEW_USER)
    @Transactional(rollbackFor = Exception.class)
    public Result newUser(HttpServletRequest request, @RequestBody TbUser model){
        Result result = new Result();
        // todo 按需添加限制条件
//        model.setId(null);
        boolean flag = tbUserService.save(model);
        result.setMsg(String.valueOf(flag));
        result.setData(model);
        return result;
    }


}

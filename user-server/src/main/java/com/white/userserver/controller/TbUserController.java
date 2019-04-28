package com.white.userserver.controller;


import com.white.userserver.common.Result;
import com.white.userserver.pojo.entity.TbUser;
import com.white.userserver.service.TbResourceService;
import com.white.userserver.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
@RestController
@RequestMapping("/v1/")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbResourceService tbResourceService;

    @PostMapping(Routes.TB_USER_LOGIN)
    @Transactional(rollbackFor = Exception.class)
    public Result login(HttpServletRequest request, @RequestBody TbUser tbUser){
        return tbUserService.login(tbUser);
    }

    @GetMapping(Routes.TB_USER_PAGE)
    public Result userPage(HttpServletRequest request){
        return tbUserService.getUserPage();
    }

    @GetMapping(Routes.TB_RESOURCE_PAGE)
    public Result resourcePage(){
        return tbResourceService.getResourcePage();
    }

}


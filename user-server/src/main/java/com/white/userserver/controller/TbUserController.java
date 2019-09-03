package com.white.userserver.controller;


import com.white.userserver.common.Result;
import com.white.userserver.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}


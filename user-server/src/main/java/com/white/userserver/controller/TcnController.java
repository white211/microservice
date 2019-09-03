package com.white.userserver.controller;

import com.white.userserver.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;

/**
 * @Program: TcnController
 * @Description:
 * @Author: White
 * @DateTime: 2019-08-23 00:22:21
 **/
@RestController
public class TcnController {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping("/txlcn")
    public String execute(@RequestParam("value") String value,
                          @RequestParam("ex") String exFlag){
       return tbUserService.execute(value,exFlag);
    }


}

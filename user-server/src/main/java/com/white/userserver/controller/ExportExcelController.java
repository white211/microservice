package com.white.userserver.controller;

import com.white.userserver.pojo.entity.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.excel.EasyExcel;

/**
 * @Program: ExportExcelController
 * @Description: 导出用户数据报表
 * @Author: White
 * @DateTime: 2019-09-02 16:35:03
 **/
@Controller
public class ExportExcelController {

    @GetMapping(Routes.TB_USER_LIST_DOWNLOAD)
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=demo.xlsx");
        EasyExcel.write(response.getOutputStream(), TbUser.class).sheet("模板").doWrite(data());
    }

    private List<TbUser> data() {
        List<TbUser> list = new ArrayList<TbUser>();
        for (int i = 0; i < 10; i++) {
            TbUser data = new TbUser();
            data.setId(i+1);
            data.setUsername("white");
            data.setAge(i+20);
            data.setEmail("94236428"+i+"@qq.com");
            list.add(data);
        }
        return list;
    }


}

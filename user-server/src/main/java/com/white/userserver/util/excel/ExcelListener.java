package com.white.userserver.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: ExcelListener
 * @Description:
 * @Author: White
 * @DateTime: 2019-06-28 00:11:25
 **/

public class ExcelListener extends AnalysisEventListener {


    private List<Object> data = new ArrayList<Object>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
//        System.out.println(context.getCurrentSheet());
        data.add(object);
//        if(data.size()>=100){
//            doSomething();
//            data = new ArrayList<Object>();
//        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // TODO: 2019/6/28 读取完之后再执行该方法
        doSomething();
    }
    public void doSomething(){
        for (Object o:data) {
            System.out.println(o);
        }
    }
}

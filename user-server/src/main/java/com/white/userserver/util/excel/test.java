package com.white.userserver.util.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Program: test
 * @Description:
 * @Author: White
 * @DateTime: 2019-06-27 12:15:42
 **/

public class test {

    public static void main(String[] args) {
            try{
                saxReadExcel("C:\\Users\\white\\Desktop\\test.xlsx");
//                readExcel("C:\\Users\\white\\Desktop\\test.xlsx");
//                readExcelByModel("C:\\Users\\white\\Desktop\\test.xlsx");
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public static void saxReadExcel(String fileName) throws IOException{
        InputStream inputStream = new FileInputStream(fileName);
        ExcelListener excelListener = new ExcelListener();
        EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1), excelListener);
        inputStream.close();
    }

    public static void readExcelByModel(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(2, 1, Goods.class));
        inputStream.close();
        System.out.println(data);
    }

    public static void readExcel(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        inputStream.close();
        System.out.println(data);
    }

}

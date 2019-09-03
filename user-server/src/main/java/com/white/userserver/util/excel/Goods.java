package com.white.userserver.util.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @Program: Goods
 * @Description:
 * @Author: White
 * @DateTime: 2019-06-27 18:27:17
 **/
@Data
public class Goods extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String goodsName;
    @ExcelProperty(index = 1)
    private String goodsCode;
    @ExcelProperty(index = 2)
    private String goodsBarCode;
    @ExcelProperty(index = 3)
    private String stock;
    @ExcelProperty(index = 4)
    private String importUser;
    @ExcelProperty(index = 5)
    private String createTime;
    @ExcelProperty(index = 6)
    private String supplierName;
    @ExcelProperty(index = 7)
    private String cateName;

}

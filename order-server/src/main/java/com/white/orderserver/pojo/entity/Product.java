package com.white.orderserver.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Program: Product
 * @Description:
 * @Author: White
 * @DateTime: 2019-05-13 16:21:49
 **/
@Data
public class Product implements Serializable {

    private Integer buyAmount;

    private Integer productId;

}

package com.white.orderserver.pojo.dto;

import com.white.orderserver.pojo.entity.OrdOrder;
import com.white.orderserver.pojo.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @Program: OrdOrderDto
 * @Description:
 * @Author: White
 * @DateTime: 2019-05-13 16:20:16
 **/
@Data
public class OrdOrderDto extends OrdOrder {

    List<Product> productList;


}

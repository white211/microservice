package com.white.orderserver.pojo.entity;

import lombok.Data;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
/**
 * Description: Create by mybatis-plus Generator
 * @author: white @ current time
 */
@Data
public class OrdOrder extends Model<OrdOrder>{


      // id
      @TableId(value = "id", type = IdType.AUTO)
       private Integer id;

      // 订单编号
       private String orderNo;

      // 商品数量
       private Integer productAmount;

      // 商品价格

      // 订单实收价格

      // 订单优惠价格

      // 付款时间
       private Date payTime;

      // 发货时间
       private Date deliverTime;

      // 收货时间
       private Date receiveTime;

      // 退款时间
       private Date refundTime;

      // 物流公司id
       private Integer logisticId;

      // 物流编号
       private String logisticNo;

      // 订单支付方式
       private Integer payChannelType;

      // 订单支付交易号
       private String outTradeNo;

      // 排序
       private Integer sort;

      // 可用状态
       private Integer enableFlag;

      // 可用开始
       private Date enableBegin;

      // 可用结束
       private Date enableEnd;

      // 创建时间
       private Date createTime;

      // 创建人
       private Integer createBy;

      // 最后更新时间
       private Date lastUpdateTime;

      // 最后更新人
       private Integer lastUpdateBy;

      // 备注
       private String comments;

      // 版本号
       private Integer version;

      // 状态
       private Integer status;


}

package com.white.orderserver.pojo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 订单总单表
 * </p>
 *
 * @author White
 * @since 2019-05-13
 */
@TableName("ord_order")
@Data
public class OrdOrder extends Model<OrdOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;
    /**
     * 商品数量
     */
    @TableField("product_amount")
    private Integer productAmount;
    /**
     * 商品价格
     */
    @TableField("product_price")
    private BigDecimal productPrice;
    /**
     * 订单实收价格
     */
    @TableField("order_price")
    private BigDecimal orderPrice;
    /**
     * 订单优惠价格
     */
    @TableField("discount_price")
    private BigDecimal discountPrice;
    /**
     * 付款时间
     */
    @TableField("pay_time")
    private Date payTime;
    /**
     * 发货时间
     */
    @TableField("deliver_time")
    private Date deliverTime;
    /**
     * 收货时间
     */
    private Date receive;
    /**
     * 退款时间
     */
    @TableField("refund_time")
    private Date refundTime;
    /**
     * 物流公司id
     */
    @TableField("logistic_id")
    private Integer logisticId;
    /**
     * 物流编号
     */
    @TableField("logistic_no")
    private String logisticNo;
    /**
     * 订单支付方式
     */
    @TableField("pay_channel_type")
    private Integer payChannelType;
    /**
     * 订单支付交易号
     */
    @TableField("out_trade_no")
    private String outTradeNo;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 可用状态
     */
    @TableField("enable_flag")
    private Integer enableFlag;
    /**
     * 可用开始
     */
    @TableField("enable_begin")
    private Date enableBegin;
    /**
     * 可用结束
     */
    @TableField("enable_end")
    private Date enableEnd;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField("create_by")
    private Integer createBy;
    /**
     * 最后更新时间
     */
    @TableField("last_update_time")
    private Date lastUpdateTime;
    /**
     * 最后更新人
     */
    @TableField("last_update_by")
    private Integer lastUpdateBy;
    /**
     * 备注
     */
    private String comments;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 状态
     */
    private Integer status;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

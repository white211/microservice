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
 * 订单详情表
 * </p>
 *
 * @author White
 * @since 2019-05-13
 */
@TableName("ord_order_item")
@Data
public class OrdOrderItem extends Model<OrdOrderItem> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单编号id
     */
    @TableField("order_id")
    private Integer orderId;
    /**
     * 商品编号id
     */
    @TableField("product_id")
    private Integer productId;
    /**
     * 购买数量
     */
    @TableField("buy_amount")
    private Integer buyAmount;
    /**
     * 商品名称
     */
    @TableField("product_name")
    private String productName;
    /**
     * 商品单价
     */
    @TableField("product_price")
    private BigDecimal productPrice;
    /**
     * 优惠价格
     */
    @TableField("discount_price")
    private BigDecimal discountPrice;
    /**
     * 实付价格
     */
    @TableField("item_price")
    private BigDecimal itemPrice;
    /**
     * 打折类型
     */
    @TableField("discount_type")
    private Integer discountType;
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

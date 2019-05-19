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
 * 订单流水表
 * </p>
 *
 * @author White
 * @since 2019-05-13
 */
@TableName("ord_order_flow")
@Data
public class OrdOrderFlow extends Model<OrdOrderFlow> {

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
     * 订单变化原因
     */
    @TableField("change_reason")
    private String changeReason;
    /**
     * 价格变化前
     */
    @TableField("order_price_before")
    private BigDecimal orderPriceBefore;
    /**
     * 价格变化后
     */
    @TableField("order_price_after")
    private BigDecimal orderPriceAfter;
    /**
     * 状态变化前
     */
    @TableField("order_status_before")
    private Integer orderStatusBefore;
    /**
     * 状态变化后
     */
    @TableField("order_status_after")
    private Integer orderStatusAfter;
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

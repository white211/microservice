package com.white.resourceserver.pojo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 物流公司表
 * </p>
 *
 * @author White
 * @since 2019-05-13
 */
@TableName("res_logistic")
public class ResLogistic extends Model<ResLogistic> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 物流公司编号（手动录入）
     */
    @TableField("logistic_no")
    private String logisticNo;
    /**
     * 物流公司名称
     */
    @TableField("logistic_name")
    private String logisticName;
    /**
     * 物流公司描述
     */
    @TableField("logistic_desciption")
    private String logisticDesciption;
    /**
     * 所在区域
     */
    private String area;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogisticNo() {
        return logisticNo;
    }

    public void setLogisticNo(String logisticNo) {
        this.logisticNo = logisticNo;
    }

    public String getLogisticName() {
        return logisticName;
    }

    public void setLogisticName(String logisticName) {
        this.logisticName = logisticName;
    }

    public String getLogisticDesciption() {
        return logisticDesciption;
    }

    public void setLogisticDesciption(String logisticDesciption) {
        this.logisticDesciption = logisticDesciption;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Date getEnableBegin() {
        return enableBegin;
    }

    public void setEnableBegin(Date enableBegin) {
        this.enableBegin = enableBegin;
    }

    public Date getEnableEnd() {
        return enableEnd;
    }

    public void setEnableEnd(Date enableEnd) {
        this.enableEnd = enableEnd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ResLogistic{" +
        ", id=" + id +
        ", logisticNo=" + logisticNo +
        ", logisticName=" + logisticName +
        ", logisticDesciption=" + logisticDesciption +
        ", area=" + area +
        ", sort=" + sort +
        ", enableFlag=" + enableFlag +
        ", enableBegin=" + enableBegin +
        ", enableEnd=" + enableEnd +
        ", createTime=" + createTime +
        ", createBy=" + createBy +
        ", lastUpdateTime=" + lastUpdateTime +
        ", lastUpdateBy=" + lastUpdateBy +
        ", comments=" + comments +
        ", version=" + version +
        ", status=" + status +
        "}";
    }
}

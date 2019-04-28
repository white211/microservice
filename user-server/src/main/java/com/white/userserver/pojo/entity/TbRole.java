package com.white.userserver.pojo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
@TableName("tb_role")
public class TbRole extends Model<TbRole> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 是否是叶子
     */
    private Integer leaf;
    /**
     * 名称
     */
    private String name;
    /**
     * 图标
     */
    private String icon;
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
     * status
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
        return "TbRole{" +
        ", id=" + id +
        ", pid=" + pid +
        ", leaf=" + leaf +
        ", name=" + name +
        ", icon=" + icon +
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

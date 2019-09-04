package com.white.userserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单分配表
 * </p>
 *
 * @author White
 * @since 2019-09-04
 */
public class TbRoleResource extends Model<TbRoleResource> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer resourceId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 可用状态
     */
    private Integer enableFlag;

    /**
     * 可用开始
     */
    private LocalDateTime enableBegin;

    /**
     * 可用结束
     */
    private LocalDateTime enableEnd;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 最后更新人
     */
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
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
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
    public LocalDateTime getEnableBegin() {
        return enableBegin;
    }

    public void setEnableBegin(LocalDateTime enableBegin) {
        this.enableBegin = enableBegin;
    }
    public LocalDateTime getEnableEnd() {
        return enableEnd;
    }

    public void setEnableEnd(LocalDateTime enableEnd) {
        this.enableEnd = enableEnd;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
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
        return "TbRoleResource{" +
            "id=" + id +
            ", roleId=" + roleId +
            ", resourceId=" + resourceId +
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

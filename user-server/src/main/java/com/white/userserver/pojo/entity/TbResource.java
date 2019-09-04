package com.white.userserver.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author White
 * @since 2019-09-04
 */
public class TbResource extends Model<TbResource> {

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
     * 类型ID
     */
    private Integer typeId;

    /**
     * 页面路径
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 名称
     */
    private String name;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 是否隐藏
     */
    private Integer hidden;

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
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
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
        return "TbResource{" +
            "id=" + id +
            ", pid=" + pid +
            ", leaf=" + leaf +
            ", typeId=" + typeId +
            ", path=" + path +
            ", component=" + component +
            ", name=" + name +
            ", redirect=" + redirect +
            ", hidden=" + hidden +
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

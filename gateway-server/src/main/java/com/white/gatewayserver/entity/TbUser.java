package com.white.gatewayserver.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */

@Data
public class TbUser implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别  0 女 1 男 2 未知
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;
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
    private Date enableBegin;
    /**
     * 可用结束
     */
    private Date enableEnd;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private Integer createBy;
    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;
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
     * 状态
     */
    private Integer status;


}

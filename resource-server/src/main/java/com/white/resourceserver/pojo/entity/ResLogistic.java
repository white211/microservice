package com.white.resourceserver.pojo.entity;

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
public class ResLogistic extends Model<ResLogistic>{


      // id
      @TableId(value = "id", type = IdType.AUTO)
       private Integer id;

      // 物流公司编号（手动录入）
       private String logisticNo;

      // 物流公司名称
       private String logisticName;

      // 物流公司描述
       private String logisticDesciption;

      // 所在区域
       private String area;

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

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
public class ResProduct extends Model<ResProduct>{


      // id
      @TableId(value = "id", type = IdType.AUTO)
       private Integer id;

      // 商品名称
       private String name;

      // 商品描述
       private String description;

      // 商品数量
       private Integer amount;

      // 商品价格

      // 打折类型
       private Integer discountType;

      // 打折折扣率

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

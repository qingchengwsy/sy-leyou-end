package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类目entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_category")
public class Category {

    /**类目id*/
    @TableId(type = IdType.AUTO)
    private Long id;

    /**类目名称*/
    private String name;

    /**父类目id , 顶级类目为0*/
    private Long parentId;

    /**是否为父节点*/
    private Boolean isParent;

    /**排序指数*/
    private Integer sort;
}

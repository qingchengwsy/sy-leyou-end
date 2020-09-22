package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_category")
public class category {

    /**类目id*/
    @TableField(value = "id")
    private Integer id;

    /**类目名称*/
    @TableField(value = "name")
    private String name;

    /**父类目id*/
    @TableField(value = "parentId")
    private Integer parentId;

    /**是否为父节点*/
    @TableField(value = "isParent")
    private Character isParent;

    /**排序指数*/
    @TableField(value = "sort")
    private Integer sort;
}

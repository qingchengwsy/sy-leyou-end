package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: sy-leyou-end
 * @description: 规格参数
 * @author: qing
 * @create: 2020-10-26 10:52
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_spec_param")
public class SpecParam {

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Long id;

    @TableField("cid")
    private Long cid;

    @TableField("group_id")
    private Long groupId;

    @TableField(value = "`name`")
    private String name;

    /**是否是数字类型参数，true或false*/
    @TableField("`numeric`")
    private Boolean numeric;

    /**数字类型参数的单位，非数字类型可以为空*/
    @TableField("unit")
    private String unit;

    /**是否是sku通用属性，true或false*/
    @TableField("generic")
    private Boolean generic;

    /**是否用于搜索过滤，true或false*/
    @TableField("searching")
    private Boolean searching;

    /**数值类型参数，如果需要搜索，则添加分段间隔值，如CPU频率间隔：0.5-1.0*/
    @TableField("segments")
    private String segments;
}

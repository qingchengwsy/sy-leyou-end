package com.sy.qing.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 品牌entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_brand")
public class Brand {

    /**品牌id*/
    @TableId(type = IdType.INPUT)
    private Long id;

    /**品牌名称*/
    @TableField(value = "name")
    private String name;

    /**品牌图片地址*/
    @TableField(value = "image")
    private String image;

    /**品牌首字符*/
    @TableField(value = "letter")
    private Character letter;
}

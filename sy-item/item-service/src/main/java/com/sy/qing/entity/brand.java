package com.sy.qing.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_brand")
public class brand {

    /**品牌id*/
    @TableField(value = "id")
    private Integer id;

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

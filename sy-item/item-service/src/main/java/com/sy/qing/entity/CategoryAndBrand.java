package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: sy-leyou-end
 * @description: 分类对应品牌
 * @author: qing
 * @create: 2020-10-16 14:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_category_brand")
public class CategoryAndBrand {

    /**类目ID*/
    private Long categoryId;

    /**品牌ID*/
    private Long brandId;
}

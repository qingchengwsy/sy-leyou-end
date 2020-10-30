package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * sku entity 商品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_sku")
public class Sku {

    /**sku id*/
    @TableId(type = IdType.AUTO)
    private Long id;

    /**spu id*/
    @TableField(value = "spu_id")
    private Long spuId;

    /**商品标题*/
    @TableField(value = "title")
    private String title;

    /**商品的图片，多个图片以‘,’分割*/
    @TableField(value = "images")
    private String images;

    /**销售价格，单位为分*/
    @TableField(value = "price")
    private BigDecimal price;

    /**特有规格属性在spu属性模板中的对应下标组合*/
    @TableField(value = "indexex")
    private String indexEx;

    /**sku的特有规格参数键值对，json格式，反序列化时请使用linkedHashMap，保证有序*/
    @TableField(value = "own_spec")
    private String ownSpec;

    /**是否有效，0无效，1有效*/
    @TableField(value = "enable")
    private Boolean enable;

    /**添加时间*/
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**最后修改时间*/
    @TableField(value = "late_update_time",fill = FieldFill.UPDATE)
    private Date lateUpdateTime;

    /**库存*/
    @TableField(exist = false)
    private Integer stock;
}

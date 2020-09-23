package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * spu_detail entity
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_spu_detail")
public class SpuDetail {

    /**spu id*/
    @TableField(value = "spu_id")
    private Integer spuId;

    /**商品描述信息*/
    @TableField(value = "description")
    private String description;

    /**通用规格参数数据*/
    @TableField(value = "generic_spec")
    private String genericSpec;

    /**特有规格参数及可选值信息，json格式*/
    @TableField(value = "special_spec")
    private String specialSpec;

    /**包装清单*/
    @TableField(value = "packing_list")
    private String packingList;

    /**售后服务*/
    @TableField(value = "after_service")
    private String afterService;

}

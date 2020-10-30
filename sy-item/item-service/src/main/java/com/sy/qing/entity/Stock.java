package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * stock entity 库存
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_stock")
public class Stock {

    /**库存对应的商品sku id*/
    @TableId(type=IdType.INPUT,value = "sku_id")
    private Long skuId;

    /**可秒杀库存*/
    @TableField(value = "seckill_stock")
    private Integer secKillStock;

    /**秒杀总数量*/
    @TableField(value = "seckill_total")
    private Integer secKillTotal;

    /**库存数量*/
    @TableField(value = "stock")
    private Integer stock;
}

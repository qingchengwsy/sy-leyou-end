package com.sy.qing.Dto;

import com.sy.qing.entity.Sku;
import com.sy.qing.entity.SpuDetail;
import lombok.Data;

import java.util.List;

/**
 * @program: sy-leyou-end
 * @description: spu DTO
 * @author: qing
 * @create: 2020-10-27 14:20
 **/
@Data
public class SpuDto {

    /**标题*/
    private String title;

    /**子标题*/
    private String subTitle;

    /**1级类目id*/
    private Long cid1;

    /**2级类目id*/
    private Long cid2;

    /**3级类目id*/
    private Long cid3;

    /**商品品牌所属id*/
    private Long brandId;

    /**sku 列表*/
    private List<Sku> skus;

    /**商品详情*/
    private SpuDetail spuDetail;
}

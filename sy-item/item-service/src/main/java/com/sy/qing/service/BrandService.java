package com.sy.qing.service;

import com.sy.qing.entity.Brand;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 品牌 service
 */
public interface BrandService {

    /**
    * @Description: 分页查询品牌
    * @Param: [key, page, rows, sortBy, desc] [搜索条件,当前页,每页大小,排序字段,是否降序]
    * @return: java.util.List<com.sy.qing.entity.Brand>
    * @Author: qing
    * @Date: 2020/10/15
    */
    List<Brand> selectPageList(String key, Integer page, Integer rows, String sortBy, Boolean desc);
}

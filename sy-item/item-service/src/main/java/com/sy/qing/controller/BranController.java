package com.sy.qing.controller;

import com.sy.qing.entity.Brand;
import com.sy.qing.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: sy-leyou-end
 * @description: 品牌 controller
 * @author: qing
 * @create: 2020-10-15 16:45
 **/
@Slf4j
@ResponseBody
@RequestMapping("/brand")
public class BranController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public List<Brand> page(@RequestParam("key") String key,// 搜索条件
                            @RequestParam("page") Integer page,// 当前页
                            @RequestParam("rows") Integer rows,// 每页大小
                            @RequestParam("sortBy") String sortBy,// 排序字段
                            @RequestParam("desc") Boolean desc){ // 是否降序
       return brandService.selectPageList(key,page,rows,sortBy,desc);
    }


}

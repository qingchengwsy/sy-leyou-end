package com.sy.qing.controller;

import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Brand;
import com.sy.qing.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: sy-leyou-end
 * @description: 品牌 controller
 * @author: qing
 * @create: 2020-10-15 16:45
 **/
@Slf4j
@RestController
@RequestMapping("brand")
public class BranController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseVo page(@RequestParam("key") String key,// 搜索条件
                           @RequestParam("page") Long page,// 当前页
                           @RequestParam("rows") Long rows,// 每页大小
                           @RequestParam(value = "sortBy", required = false) String sortBy,// 排序字段
                           @RequestParam(value = "desc", required = false) Boolean desc) { // 是否降序
        return brandService.selectPageList(key, page, rows, sortBy, desc);
    }

    @PostMapping
    public ResponseEntity<Brand> brand(@RequestParam("name") String name,// 品牌名称
                                       @RequestParam("image") String image,// 图片
                                       @RequestParam("cids") Long cids,// 类目id
                                       @RequestParam("letter") Character letter) {  //品牌首字母
        return brandService.brand(name,image, cids, letter);
    }
}

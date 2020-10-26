package com.sy.qing.controller;

import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Brand;
import com.sy.qing.entity.CategoryAndBrand;
import com.sy.qing.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("page/{id}")
    public ResponseEntity<Void> del(@PathVariable(value = "id") Long id){
        Integer del = brandService.del(id);
        if (del==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.valueOf("删除失败！"));
    }

    @GetMapping("cid/{id}")
    public ResponseEntity<List<Brand>> findBrandBycId(@PathVariable(value = "id") Long id){
        List<Brand> categoryAndBrandBycId = brandService.findCategoryAndBrandBycId(id);
        if (CollectionUtils.isNotEmpty(categoryAndBrandBycId)){
            return new ResponseEntity<>(categoryAndBrandBycId,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }
}

package com.sy.qing.controller;

import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Spu;
import com.sy.qing.service.SpuService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: sy-leyou-end
 * @description: spu controller
 * @author: qing
 * @create: 2020-10-21 11:21
 **/
@RestController
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("spu/page")
    public ResponseEntity<ResponseVo<Spu>> page(@RequestParam("key") String key,// 搜索字段
                                          @RequestParam(value = "saleable",required = false) Boolean saleable,// 是否上架
                                          @RequestParam("page") Long page,// 页码
                                          @RequestParam("rows") Long rows) {  //页面大小
        ResponseVo<Spu> vo = spuService.selectPageList(key, saleable, page, rows);
        if (CollectionUtils.isNotEmpty(vo.getRecord())){
            return new ResponseEntity<>(vo,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("goods")
    public ResponseEntity<Void> addGoods(){
        return null;
    }

    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(){
        return null;
    }
}

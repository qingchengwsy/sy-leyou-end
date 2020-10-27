package com.sy.qing.controller;

import com.sy.qing.entity.SpecGroup;
import com.sy.qing.entity.SpecParam;
import com.sy.qing.service.SpecService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: sy-leyou-end
 * @description: 规格参数 controller
 * @author: qing
 * @create: 2020-10-26 11:11
 **/
@RestController
@RequestMapping("spec")
public class SpecController {

    @Autowired
    private SpecService specService;

    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> findAllBycId(@PathVariable(value = "cid") Long cid){
        List<SpecGroup> groups = specService.findAllBycId(cid);
        if (CollectionUtils.isNotEmpty(groups)){
            return new ResponseEntity<>(groups,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }

    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> findAllBygId(@RequestParam(value = "gid",required = false) Long gid,
                                                        @RequestParam(value = "cid",required = false) Long cid){
        List<SpecParam> groups = specService.findAllBygId(gid,cid);
        if (CollectionUtils.isNotEmpty(groups)){
            return new ResponseEntity<>(groups,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }

    @PostMapping("group")
    public ResponseEntity<Void> addGroup(@RequestBody SpecGroup group){
        Boolean aBoolean = specService.addGroup(group);
        if (aBoolean==true){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.valueOf("创建失败或者名称已存在"));
    }

    @PutMapping("group")
    public ResponseEntity<Void> updateGroup(@RequestBody SpecGroup group){
        Boolean aBoolean = specService.addGroup(group);
        if (aBoolean==true){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.valueOf("修改失败或者名称已存在"));
    }

    @DeleteMapping("group/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable(value = "id") Long id){
        Integer del = specService.deleteGroup(id);
        if (del==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.valueOf("删除失败！"));
    }

    @PostMapping("param")
    public ResponseEntity<Void> addParam(@RequestBody SpecParam param){
        Boolean aBoolean = specService.addParam(param);
        if (aBoolean==true){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.valueOf("添加失败或者名称已存在"));
    }

    @PutMapping("param")
    public ResponseEntity<Void> updateParam(@RequestBody SpecParam param){
        Boolean aBoolean = specService.updateParam(param);
        if (aBoolean==true){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.valueOf("修改失败或者名称已存在"));
    }

    @DeleteMapping("param/{id}")
    public ResponseEntity<Void> deleteParam(@PathVariable(value = "id") Long id){
        Integer del = specService.deleteParam(id);
        if (del==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.valueOf("删除失败！"));
    }
}

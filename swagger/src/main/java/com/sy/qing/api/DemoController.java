package com.sy.qing.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @program: sy-leyou-end
 * @description: 示例swagger
 * @author: Su.Qing
 * @create: 2020-12-23 14:08
 **/
@Api(tags = "用户管理")
@RestController
public class DemoController {

    @ApiOperation(value = "用户详情")
    @GetMapping("/user/{id}")
    public String findById(@PathVariable Long id){
        return "姓名：苏青 年龄：21 性别：男";
    }

    @ApiOperation("用户列表")
    @GetMapping("/users")
    public List<String> list(@ApiParam(value = "第几页",example = "1") @RequestParam int pageIndex,
                             @ApiParam(value = "每页多少条",example = "10") @RequestParam int pageSize){
        return Arrays.asList("1","2","3","4","5","6","7");
    }

    @ApiOperation("删除用户")
    @DeleteMapping("del/{id}")
    public String deleteById(@PathVariable Long id){
        return "delete success "+id;
    }
}

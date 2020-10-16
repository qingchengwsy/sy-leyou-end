package com.sy.qing.controller;

import com.sy.qing.entity.Category;
import com.sy.qing.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("list")
    public List<Category> categoryList(@RequestParam("pid") Long pid){
        if (pid ==null){
            throw new RuntimeException("pid 类目id is not empty");
        }
        return categoryService.categoryList(pid);
    }

    @PostMapping("add")
    public Boolean categoryAdd(@RequestBody Category category){
        return categoryService.addOne(category);
    }

    @PostMapping("update")
    public Boolean categoryUpdate(@RequestParam("id") Long id,
                                  @RequestParam("name") String name){
       return categoryService.updateOne(id, name);
    }

    @GetMapping("delete/{id}")
    public Boolean categoryDelete(@PathVariable("id") Long id){
        return categoryService.deleteOne(id);
    }
}

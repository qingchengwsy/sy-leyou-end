package com.sy.qing.service.imple;

import com.sy.qing.entity.Category;
import com.sy.qing.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImpleTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void categoryList() {
        List<Category> categories = categoryService.categoryList(0);
        System.out.println(categories.toString());
    }
}

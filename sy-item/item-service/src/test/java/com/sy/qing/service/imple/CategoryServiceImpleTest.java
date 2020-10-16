package com.sy.qing.service.imple;

import com.sy.qing.entity.Category;
import com.sy.qing.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImpleTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void categoryList() {
        List<Category> categories = categoryService.categoryList(0L);
        System.out.println(categories.toString());
    }

    @Test
    public void cId(){
        Long oneCId = categoryService.getOneCId(1317011799115665410L);
        System.out.println(oneCId);
    }
}

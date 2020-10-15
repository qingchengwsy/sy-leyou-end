package com.sy.qing.service.imple;

import com.sy.qing.entity.Brand;
import com.sy.qing.service.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class BrandServiceImpleTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void selectPageList() {
        List<Brand> id = brandService.selectPageList("кудЧ", 1, 20, "id", true);
        System.out.println(id);
    }
}

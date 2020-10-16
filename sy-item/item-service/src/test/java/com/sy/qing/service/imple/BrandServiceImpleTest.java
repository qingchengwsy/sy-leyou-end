package com.sy.qing.service.imple;

import com.sy.qing.Vo.BrandVo;
import com.sy.qing.entity.Brand;
import com.sy.qing.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class BrandServiceImpleTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void selectPageList() {
        BrandVo id =brandService.selectPageList("海", Long.parseLong("0"), Long.parseLong("10"), "id", true);
    }
}

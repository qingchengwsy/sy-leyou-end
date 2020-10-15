package com.sy.qing.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sy.qing.entity.Brand;
import com.sy.qing.mapper.BrandMapper;
import com.sy.qing.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@Slf4j
public class BrandServiceImple implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> selectPageList(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        QueryWrapper<Brand> wrapper=new QueryWrapper<>();
        wrapper.like(StringUtils.isNoneBlank(key),"name",key)
                .orderByDesc(desc,sortBy);
        IPage pageHelper=new Page(page,rows);
        return (List<Brand>) brandMapper.selectPage(pageHelper,wrapper);
    }
}

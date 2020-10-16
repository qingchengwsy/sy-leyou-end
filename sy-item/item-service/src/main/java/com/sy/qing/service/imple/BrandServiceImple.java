package com.sy.qing.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sy.qing.Vo.BrandVo;
import com.sy.qing.entity.Brand;
import com.sy.qing.entity.CategoryAndBrand;
import com.sy.qing.mapper.BrandAndCategortMapper;
import com.sy.qing.mapper.BrandMapper;
import com.sy.qing.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BrandServiceImple implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandAndCategortMapper brandAndCategortMapper;

    @Override
    public BrandVo selectPageList(String key, Long page, Long rows, String sortBy, Boolean desc) {
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        IPage<Brand> pageHelper = new Page<>(page, rows);
        BrandVo brandVo = null;
        wrapper.like(StringUtils.isNotBlank(key), "name", key)
                .orderByDesc(desc == null ? false : desc, sortBy);
        pageHelper = brandMapper.selectPage(pageHelper, wrapper);
        if (CollectionUtils.isNotEmpty(pageHelper.getRecords())) {
            brandVo = new BrandVo();
            brandVo.setCurrent(pageHelper.getCurrent());
            brandVo.setSize(pageHelper.getSize());
            brandVo.setTotal(pageHelper.getTotal());
            brandVo.setBrands(pageHelper.getRecords());
        }
        log.warn("selectPageList 查询出的品牌数据{}", brandVo);
        return brandVo;
    }

    @Transactional
    @Override
    public Boolean brand(String name, String image, Long cids, Character letter) {
        QueryWrapper<Brand> wrapper=new QueryWrapper<>();
        wrapper.eq("name",name);
        Integer count = brandMapper.selectCount(wrapper);
        if (count==0){
            Brand brand=new Brand();
            brand.setName(name);
            brand.setImage(image);
            brand.setLetter(letter);
            int insert = brandMapper.insert(brand);
            if (insert==1){
                Brand brandId = brandMapper.selectOne(wrapper);
                CategoryAndBrand brandAndCategory=new CategoryAndBrand();
                brandAndCategory.setBrandId(brandId.getId());
                brandAndCategory.setCategoryId(cids);
                int i = brandAndCategortMapper.insert(brandAndCategory);
                if (i==1){
                    return true;
                }
            }
        }
        log.warn("brand 品牌名称已存在:{}",name);
        return false;
    }
}

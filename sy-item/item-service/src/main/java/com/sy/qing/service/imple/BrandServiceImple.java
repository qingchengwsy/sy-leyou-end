package com.sy.qing.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Brand;
import com.sy.qing.entity.Category;
import com.sy.qing.entity.CategoryAndBrand;
import com.sy.qing.mapper.BrandAndCategortMapper;
import com.sy.qing.mapper.BrandMapper;
import com.sy.qing.service.BrandService;
import com.sy.qing.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BrandServiceImple implements BrandService {

    private BrandMapper brandMapper;
    private BrandAndCategortMapper brandAndCategortMapper;
    private CategoryService categoryService;

    public BrandServiceImple(BrandMapper brandMapper, BrandAndCategortMapper brandAndCategortMapper, CategoryService categoryService) {
        this.brandMapper = brandMapper;
        this.brandAndCategortMapper = brandAndCategortMapper;
        this.categoryService = categoryService;
    }


    @Override
    public ResponseVo<Brand> selectPageList(String key, Long page, Long rows, String sortBy, Boolean desc) {
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        IPage<Brand> pageHelper = new Page<>(page, rows);
        ResponseVo<Brand> brandVo = null;
        wrapper.like(StringUtils.isNotBlank(key), "name", key)
                .orderByDesc(desc == null ? false : desc, sortBy);
        pageHelper = brandMapper.selectPage(pageHelper, wrapper);
        if (CollectionUtils.isNotEmpty(pageHelper.getRecords())) {
            brandVo = new ResponseVo<>();
            brandVo.setCurrent(pageHelper.getCurrent());
            brandVo.setSize(pageHelper.getSize());
            brandVo.setTotal(pageHelper.getTotal());
            brandVo.setRecord(pageHelper.getRecords());
        }
        log.warn("selectPageList 查询出的品牌数据{}", brandVo);
        return brandVo;
    }

    @Transactional
    @Override
    public ResponseEntity<Brand> brand(String name, String image, Long cids, Character letter) {
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
                List<Long> ids = categoryService.getIds(cids)
                        .stream().map(Category::getId).collect(Collectors.toList());
                ids.forEach(e->{
                    brandAndCategory.setCategoryId(e);
                    brandAndCategortMapper.insert(brandAndCategory);
                });
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Integer del(Long id) {
        return brandMapper.deleteById(id);
    }

    @Override
    public List<Brand> findCategoryAndBrandBycId(Long cId) {
        QueryWrapper<CategoryAndBrand> wrapper=new QueryWrapper<>();
        wrapper.eq("category_id",cId);
        List<CategoryAndBrand> categoryAndBrands = brandAndCategortMapper.selectList(wrapper);
        List<Long> brandIds= categoryAndBrands.stream()
                .map(CategoryAndBrand::getBrandId).collect(Collectors.toList());
        return brandMapper.selectBatchIds(brandIds);
    }
}

package com.sy.qing.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sy.qing.entity.Category;
import com.sy.qing.mapper.CategoryMapper;
import com.sy.qing.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImple implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> categoryList(Integer pid) {
        QueryWrapper<Category> wrapper=new QueryWrapper<>();
        wrapper.eq("parent_id",pid);
        List<Category> category = categoryMapper.selectList(wrapper);
        return category;
    }

    @Override
    public Boolean addOne(Category category) {
        QueryWrapper<Category> wrapper=new QueryWrapper<>();
        wrapper.eq("name",category.getName());
        Integer count = categoryMapper.selectCount(wrapper);
        if (count==0){
            int insert = categoryMapper.insert(category);
            if (insert>0){
                return true;
            }
        }
        log.warn("addOne 该类目名称已存在"+category.getName());
        return false;
    }

    @Override
    public Boolean updateOne(Integer id, String name) {
        Category category = categoryMapper.selectById(id);
        category.setName(name);
        UpdateWrapper<Category> wrapper=new UpdateWrapper<>();
        wrapper.notLike("name",name);
        int i = categoryMapper.update(category,wrapper);
        if (i==1){
            return true;
        }
        log.warn("updateOne 修改失败：{},{}",id,name);
        return false;
    }

    @Override
    public Boolean deleteOne(Integer id) {
        List<Category> categories = categoryList(id);
        if (CollectionUtils.isNotEmpty(categories)){
            List<Integer> categoryIds = categories.stream()
                    .map(Category::getId).collect(Collectors.toList());
            categoryMapper.deleteBatchIds(categoryIds);
        }
        int i = categoryMapper.deleteById(id);
        if (i==1){
            return true;
        }
        return false;
    }
}

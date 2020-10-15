package com.sy.qing.service;

import com.sy.qing.entity.Category;

import java.util.List;

/**
 * 类目service
 */
public interface CategoryService {

    /**
     * 查询所有类目
     * @param pid
     * @return
     */
    List<Category> categoryList(Integer pid);

    /**
    * @Description: 添加节点
    * @Param: [category]
    * @return: com.sy.qing.entity.Category
    * @Author: qing
    * @Date: 2020/10/15
    */
    Boolean addOne(Category category);

    /**
    * @Description: 修改节点名称
    * @Param: [id, name]
    * @return: java.lang.Boolean
    * @Author: qing
    * @Date: 2020/10/15
    */
    Boolean updateOne(Integer id,String name);

    /**
    * @Description: 删除节点
    * @Param: [id]
    * @return: java.lang.Boolean
    * @Author: qing
    * @Date: 2020/10/15
    */
    Boolean deleteOne(Integer id);
}

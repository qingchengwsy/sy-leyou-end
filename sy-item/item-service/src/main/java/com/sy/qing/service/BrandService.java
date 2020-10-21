package com.sy.qing.service;

import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Brand;
import org.springframework.http.ResponseEntity;

/**
 * 品牌 service
 */
public interface BrandService {

    /**
    * @Description: 分页并且模糊查询查询品牌
    * @Param: [key, page, rows, sortBy, desc] [搜索条件,当前页,每页大小,排序字段,是否降序]
    * @return: java.util.List<com.sy.qing.entity.Brand>
    * @Author: qing
    * @Date: 2020/10/15
    */
    ResponseVo<Brand> selectPageList(String key, Long page, Long rows, String sortBy, Boolean desc);

  /**
  * @Description: 新增品牌
  * @Param: [name, image, cids, cids1]
  * @return: java.lang.Boolean
  * @Author: qing
  * @Date: 2020/10/16
  */
    ResponseEntity<Brand> brand(String name, String image, Long cids, Character letter);

}

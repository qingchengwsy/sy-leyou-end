package com.sy.qing.service;

import com.sy.qing.Dto.SpuDto;
import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Spu;


/**
 * @Description: Spu service
 * @Author: qing
 * @Date: 2020/10/21
 */
public interface SpuService {

    /**
    * @Description: 分页查询spu
    * @Param: [key, saleable, page, rows]
    * @return: com.sy.qing.Vo.ResponseVo<com.sy.qing.entity.Spu>
    * @Author: qing
    * @Date: 2020/10/27
    */
    ResponseVo<Spu> selectPageList(String key, Boolean saleable, Long page, Long rows);

    /**
    * @Description: 新增商品
    * @Param: [spuDto]
    * @return: java.lang.Boolean
    * @Author: qing
    * @Date: 2020/10/27
    */
    Boolean addGoods(SpuDto spuDto);
}

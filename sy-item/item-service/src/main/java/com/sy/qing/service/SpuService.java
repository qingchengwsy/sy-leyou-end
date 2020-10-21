package com.sy.qing.service;

import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Spu;


/**
 * @Description: Spu service
 * @Author: qing
 * @Date: 2020/10/21
 */
public interface SpuService {

    ResponseVo<Spu> selectPageList(String key, Boolean saleable, Long page, Long rows);
}

package com.sy.qing.service;

import com.sy.qing.entity.SpecGroup;
import com.sy.qing.entity.SpecParam;

import java.util.List;

/**
 * @program: sy-leyou-end
 * @description: 规格参数 service
 * @author: qing
 * @create: 2020-10-26 11:00
 **/
public interface SpecService {

    /**
    * @Description: 根据cId查询规格参数组
    * @Param: [cId]
    * @return: java.util.List<com.sy.qing.entity.SpecGroup>
    * @Author: qing
    * @Date: 2020/10/26
    */
    List<SpecGroup> findAllBycId(Long cId);

    /**
    * @Description: 根据gId查询规格参数
    * @Param: [gId]
    * @return: java.util.List<com.sy.qing.entity.SpecParam>
    * @Author: qing
    * @Date: 2020/10/26
    */
    List<SpecParam> findAllBygId(Long gId,Long cid);

    /**
    * @Description: 添加分组
    * @Param: [group]
    * @return: java.lang.Boolean
    * @Author: qing
    * @Date: 2020/10/26
    */
    Boolean addGroup(SpecGroup group);

    /**
    * @Description: 修改分组
    * @Param: [group]
    * @return: java.lang.Boolean
    * @Author: qing
    * @Date: 2020/10/26
    */
    Boolean updateGroup(SpecGroup group);

    /**
    * @Description: 删除分组
    * @Param: [id]
    * @return: java.lang.Integer
    * @Author: qing
    * @Date: 2020/10/26
    */
    Integer deleteGroup(Long id);

    /**
    * @Description: 新增规格参数
    * @Param: [param]
    * @return: java.lang.Boolean
    * @Author: qing
    * @Date: 2020/10/26
    */
    Boolean addParam(SpecParam param);

    /**
    * @Description: 修改规格参数
    * @Param: [param]
    * @return: java.lang.Boolean
    * @Author: qing
    * @Date: 2020/10/26
    */
    Boolean updateParam(SpecParam param);

    /**
    * @Description: 删除规格参数
    * @Param: [id]
    * @return: java.lang.Integer
    * @Author: qing
    * @Date: 2020/10/26
    */
    Integer deleteParam(Long id);
}

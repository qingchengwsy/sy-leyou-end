package com.sy.qing.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sy.qing.entity.SpecGroup;
import com.sy.qing.entity.SpecParam;
import com.sy.qing.mapper.SpecGroupMapper;
import com.sy.qing.mapper.SpecParamMapper;
import com.sy.qing.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sy-leyou-end
 * @description:
 * @author: qing
 * @create: 2020-10-26 11:01
 **/
@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    private SpecGroupMapper groupMapper;

    @Autowired
    private SpecParamMapper paramMapper;

    @Override
    public List<SpecGroup> findAllBycId(Long cId) {
        QueryWrapper<SpecGroup> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", cId);
        return groupMapper.selectList(wrapper);
    }

    @Override
    public List<SpecParam> findAllBygId(Long gId, Long cid) {
        QueryWrapper<SpecParam> wrapper = new QueryWrapper<>();
        wrapper.eq(gId!=null,"group_id", gId)
        .eq(cid!=null,"cid",cid);
        return paramMapper.selectList(wrapper);
    }

    @Override
    public Boolean addGroup(SpecGroup group) {
        int count = groupOne(group.getName());
        if (count == 0) {
            int insert = groupMapper.insert(group);
            if (insert == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateGroup(SpecGroup group) {
        int count = groupOne(group.getName());
        if (count == 0) {
            int i = groupMapper.updateById(group);
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer deleteGroup(Long id) {
        return groupMapper.deleteById(id);
    }

    @Override
    public Boolean addParam(SpecParam param) {
        int count = paramOne(param.getName());
        if (count == 0) {
            int insert = paramMapper.insert(param);
            if (insert == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateParam(SpecParam param) {
        int i = paramMapper.updateById(param);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Integer deleteParam(Long id) {
        return paramMapper.deleteById(id);
    }

    /**
     * @Description: 判断 group 名称是否重复
     * @Param: [name]
     * @return: int
     * @Author: qing
     * @Date: 2020/10/26
     */
    private int groupOne(String name) {
        QueryWrapper<SpecGroup> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return groupMapper.selectCount(wrapper);
    }

    /**
     * @Description: 判断 param 名称是否重复
     * @Param: [name]
     * @return: int
     * @Author: qing
     * @Date: 2020/10/26
     */
    private int paramOne(String name) {
        QueryWrapper<SpecParam> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return paramMapper.selectCount(wrapper);
    }
}

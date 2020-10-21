package com.sy.qing.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Spu;
import com.sy.qing.mapper.SpuMapper;
import com.sy.qing.service.SpuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpuServiceImple implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public ResponseVo<Spu> selectPageList(String key, Boolean saleable, Long page, Long rows) {
        QueryWrapper<Spu> wrapper=new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(key),"title",key)
                .eq(saleable!=null,"saleable",saleable);
        System.out.println(saleable!=null);
        IPage<Spu> pageHelper=new Page<>(page,rows);
        pageHelper= spuMapper.selectPage(pageHelper, wrapper);
        ResponseVo<Spu> vo=null;
        if (CollectionUtils.isNotEmpty(pageHelper.getRecords())){
            vo=new ResponseVo();
            vo.setRecord(pageHelper.getRecords());
            vo.setCurrent(pageHelper.getCurrent());
            vo.setPages(pageHelper.getPages());
            vo.setSize(pageHelper.getSize());
            vo.setTotal(pageHelper.getTotal());
        }
        log.warn("查询spu: {}",vo);
        return vo;
    }
}

package com.sy.qing.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sy.qing.Dto.SpuDto;
import com.sy.qing.Vo.ResponseVo;
import com.sy.qing.entity.Spu;
import com.sy.qing.entity.Stock;
import com.sy.qing.mapper.SkuMapper;
import com.sy.qing.mapper.SpuDetailMapper;
import com.sy.qing.mapper.SpuMapper;
import com.sy.qing.mapper.StockMapper;
import com.sy.qing.service.SpuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Service
@Slf4j
public class SpuServiceImple implements SpuService {

    private SpuMapper spuMapper;
    private SkuMapper skuMapper;
    private SpuDetailMapper detailMapper;
    private StockMapper stockMapper;

    public SpuServiceImple(SpuMapper spuMapper, SkuMapper skuMapper, SpuDetailMapper detailMapper, StockMapper stockMapper) {
        this.spuMapper = spuMapper;
        this.skuMapper = skuMapper;
        this.detailMapper = detailMapper;
        this.stockMapper = stockMapper;
    }

    @Override
    public ResponseVo<Spu> selectPageList(String key, Boolean saleable, Long page, Long rows) {
        QueryWrapper<Spu> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(key), "title", key)
                .eq(saleable != null, "saleable", saleable);
        IPage<Spu> pageHelper = new Page<>(page, rows);
        pageHelper = spuMapper.selectPage(pageHelper, wrapper);
        ResponseVo<Spu> vo = null;
        if (CollectionUtils.isNotEmpty(pageHelper.getRecords())) {
            vo = new ResponseVo();
            vo.setRecord(pageHelper.getRecords());
            vo.setCurrent(pageHelper.getCurrent());
            vo.setPages(pageHelper.getPages());
            vo.setSize(pageHelper.getSize());
            vo.setTotal(pageHelper.getTotal());
        }
        log.warn("查询spu: {}", vo);
        return vo;
    }

    @Transactional
    @Override
    public Boolean addGoods(SpuDto spuDto) {
        //spu
        Spu spu = new Spu();
        BeanUtils.copyProperties(spuDto, spu);
        spu.setSaleable(false);
        spu.setValid(false);
        System.out.println(spu);
        spuMapper.insert(spu);
        //sku
        spuDto.getSkus().forEach(e -> {
            e.setSpuId(spu.getId());
            skuMapper.insert(e);
            //stock
            Stock stock=new Stock();
            stock.setSkuId(e.getId());
            stock.setStock(e.getStock());
            stockMapper.insert(stock);
        });
        //SpuDetail
        spuDto.getSpuDetail().setSpuId(spu.getId());
        int insert = detailMapper.insert(spuDto.getSpuDetail());
        if (insert==1){
            return true;
        }
        return false;
    }
}

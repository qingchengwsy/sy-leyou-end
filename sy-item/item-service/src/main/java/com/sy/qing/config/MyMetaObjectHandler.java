package com.sy.qing.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: sy-leyou-end
 * @description: Mybatis-Plus 自动填充处理器
 * @author: qing
 * @create: 2020-10-21 10:29
 **/

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
     log.info("Start insert fill...");
     this.setInsertFieldValByName("createTime", LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("Start Update fill...");
        this.setUpdateFieldValByName("lastUpdateTime",LocalDateTime.now(),metaObject);
    }
}

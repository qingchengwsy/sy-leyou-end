package com.sy.qing.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: sy-leyou-end
 * @description: 品牌View Object
 * @author: qing
 * @create: 2020-10-16 10:04
 **/
@Data
public class ResponseVo<T> implements Serializable {

    /**当前页*/
    private Long current;

    /**页面大小*/
    private Long size;

    /**总页数*/
    private Long pages;

    /**总记录数*/
    private Long total;

    /**List<T>*/
    private List<T> record;
}

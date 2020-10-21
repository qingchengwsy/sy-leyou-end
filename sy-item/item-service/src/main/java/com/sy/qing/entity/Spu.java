package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * spu entity 产品
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_spu")
public class Spu {

    /**spu id*/
    @TableField(value = "id")
    private Integer id;

    /**标题*/
    @TableField(value = "title")
    private String title;

    /**子标题*/
    @TableField(value = "sub_title")
    private String subTitle;

    /**1级类目id*/
    @TableField(value = "cid1")
    private Integer cid1;

    /**2级类目id*/
    @TableField(value = "cid2")
    private Integer cid2;

    /**3级类目id*/
    @TableField(value = "cid3")
    private Integer cid3;

    /**商品品牌所属id*/
    @TableField(value = "brand_id")
    private Integer brandId;

    /**是否上架，0下架，1上架*/
    @TableField(value = "saleable")
    private Character saleable;

    /**是否有效，0已删除，1有效*/
    @TableField(value = "valid")
    private Character valid;

    /**添加时间*/
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**最后修改时间*/
    @TableField(value = "last_update_time",fill = FieldFill.UPDATE)
    private Date lastUpdateTime;
}

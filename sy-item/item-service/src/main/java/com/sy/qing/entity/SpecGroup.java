package com.sy.qing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: sy-leyou-end
 * @description: 规格参数分组
 * @author: qing
 * @create: 2020-10-26 10:45
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_spec_group")
public class SpecGroup {

    /**spec_group id*/
    @TableId(type = IdType.AUTO)
    private Long id;

    /**类目id*/
    private Long cid;

    /**规格组名称*/
    private String name;

}

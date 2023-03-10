package com.geo.integrated.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: whtli
 * @date: 2023/01/28
 * @description: 发明专利信息实体类
 */
@Data
@TableName("ach_patent")
public class AchievementPatent implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String number;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String title;

    /**
     * 完成人(固定人员)
     */
    @ApiModelProperty(value = "完成人(固定人员)")
    private String finisher;

    private static final long serialVersionUID = 1L;
}
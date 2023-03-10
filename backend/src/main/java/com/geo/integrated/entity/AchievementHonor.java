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
 * @description: 所获荣誉信息实体类
 */
@Data
@TableName("ach_honor")
public class AchievementHonor implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所获荣誉名称
     */
    @ApiModelProperty(value = "所获荣誉名称")
    private String honorName;

    /**
     * 获奖成果名称
     */
    @ApiModelProperty(value = "获奖成果名称")
    private String achievementName;

    /**
     * 实验室人员排名
     */
    @ApiModelProperty(value = "实验室人员排名")
    private String participantsRank;

    private static final long serialVersionUID = 1L;
}
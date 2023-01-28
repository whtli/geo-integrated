package com.geo.integrated.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * achievement_patent
 *
 * @author
 */
@Data
@TableName("achievement_patent")
public class AchievementPatent implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 编号
     */
    private String number;

    /**
     * 名称
     */
    private String title;

    /**
     * 完成人(固定人员)
     */
    private String finisher;

    private static final long serialVersionUID = 1L;
}
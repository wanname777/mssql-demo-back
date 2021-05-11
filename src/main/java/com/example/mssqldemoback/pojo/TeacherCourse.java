package com.example.mssqldemoback.pojo;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "TeacherCourse对象", description = "")
public class TeacherCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "teacher_id", type = IdType.ASSIGN_ID)
    private String teacherId;
    private String courseId;
    private String teachingAim;
    private Integer isExam;
    private Date selectionPeriod;
}

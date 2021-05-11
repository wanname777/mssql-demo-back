package com.example.mssqldemoback.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author vannmaureen
 * @since 2021-05-06 10:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "StudentCourse对象", description = "")
public class StudentCourseVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "student_id", type = IdType.ASSIGN_ID)
    private String studentId;
    private String courseId;
    private String name;
    private Double teachingTime;
    private Double credit;
    private Integer isOpen;
    private Integer limitNumber;
    private Integer chooseNumber;
    private Date selectionPeriod;
    private Double grade;
}

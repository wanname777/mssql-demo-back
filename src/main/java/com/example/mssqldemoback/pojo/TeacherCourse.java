package com.example.mssqldemoback.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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

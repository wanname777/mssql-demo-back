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
@ApiModel(value = "StudentCourse对象", description = "")
public class StudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * todo:mybatisplus的主键有大问题
     */
    @TableId(value = "student_id", type = IdType.ASSIGN_ID)
    private String studentId;
    private String courseId;
    private Date selectionPeriod;
    private Double grade;
}

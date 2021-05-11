package com.example.mssqldemoback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mssqldemoback.pojo.StudentCourse;
import com.example.mssqldemoback.vo.StudentCourseVo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    List<StudentCourseVo> getStudentCourseVo(String studentId);
}

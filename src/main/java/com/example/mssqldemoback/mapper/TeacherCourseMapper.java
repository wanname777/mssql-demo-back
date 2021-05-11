package com.example.mssqldemoback.mapper;

import com.example.mssqldemoback.pojo.TeacherCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mssqldemoback.vo.StudentCourseVo;
import com.example.mssqldemoback.vo.TeacherCourseVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface TeacherCourseMapper extends BaseMapper<TeacherCourse> {
    List<TeacherCourseVo> getTeacherCourseVo(String teacherId);

}

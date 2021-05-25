package com.example.mssqldemoback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mssqldemoback.pojo.TeacherCourse;
import com.example.mssqldemoback.vo.TeacherCourseVo;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface TeacherCourseMapper extends BaseMapper<TeacherCourse> {
    Page<TeacherCourseVo> getTeacherCourseVo(String teacherId,
                                             Page<TeacherCourseVo> page);
}

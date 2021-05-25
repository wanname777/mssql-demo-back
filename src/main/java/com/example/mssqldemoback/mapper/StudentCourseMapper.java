package com.example.mssqldemoback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mssqldemoback.pojo.StudentCourse;
import com.example.mssqldemoback.vo.StudentCourseVo;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    Page<StudentCourseVo> getStudentCourseVo(String studentId,
                                             Page<StudentCourseVo> page);
}

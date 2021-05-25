package com.example.mssqldemoback.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mssqldemoback.pojo.TeacherCourse;
import com.example.mssqldemoback.vo.TeacherCourseVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface TeacherCourseService extends IService<TeacherCourse> {
    Page<TeacherCourseVo> getTeacherCourseVo(String teacherId,
                                             Page<TeacherCourseVo> page);
}

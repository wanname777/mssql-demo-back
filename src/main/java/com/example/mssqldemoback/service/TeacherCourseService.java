package com.example.mssqldemoback.service;

import com.example.mssqldemoback.pojo.TeacherCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mssqldemoback.vo.StudentCourseVo;
import com.example.mssqldemoback.vo.TeacherCourseVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface TeacherCourseService extends IService<TeacherCourse> {
    List<TeacherCourseVo> getTeacherCourseVo(String teacherId);
}

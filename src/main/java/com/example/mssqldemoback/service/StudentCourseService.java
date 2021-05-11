package com.example.mssqldemoback.service;

import com.example.mssqldemoback.pojo.StudentCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mssqldemoback.vo.StudentCourseVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface StudentCourseService extends IService<StudentCourse> {

    List<StudentCourseVo> getStudentCourseVo(String studentId);
}

package com.example.mssqldemoback.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mssqldemoback.pojo.StudentCourse;
import com.example.mssqldemoback.vo.StudentCourseVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
public interface StudentCourseService extends IService<StudentCourse> {
    Page<StudentCourseVo> getStudentCourseVo(String studentId,
                                             Page<StudentCourseVo> page);
}

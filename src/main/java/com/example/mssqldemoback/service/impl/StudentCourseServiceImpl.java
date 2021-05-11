package com.example.mssqldemoback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mssqldemoback.mapper.StudentCourseMapper;
import com.example.mssqldemoback.pojo.StudentCourse;
import com.example.mssqldemoback.service.StudentCourseService;
import com.example.mssqldemoback.vo.StudentCourseVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper, StudentCourse> implements StudentCourseService {
    @Override
    public List<StudentCourseVo> getStudentCourseVo(String studentId) {
        List<StudentCourseVo> studentCourseVo =
                this.baseMapper.getStudentCourseVo(studentId);
        return studentCourseVo;
    }
}

package com.example.mssqldemoback.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mssqldemoback.mapper.TeacherCourseMapper;
import com.example.mssqldemoback.pojo.TeacherCourse;
import com.example.mssqldemoback.service.TeacherCourseService;
import com.example.mssqldemoback.vo.TeacherCourseVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
@Service
public class TeacherCourseServiceImpl extends ServiceImpl<TeacherCourseMapper, TeacherCourse> implements TeacherCourseService {
    @Override
    public Page<TeacherCourseVo> getTeacherCourseVo(String teacherId,
                                                    Page<TeacherCourseVo> page) {
        return this.baseMapper.getTeacherCourseVo(teacherId, page);
    }
}

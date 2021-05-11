package com.example.mssqldemoback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mssqldemoback.mapper.CourseMapper;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.service.CourseService;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}

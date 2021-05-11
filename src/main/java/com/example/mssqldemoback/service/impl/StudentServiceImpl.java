package com.example.mssqldemoback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mssqldemoback.mapper.StudentMapper;
import com.example.mssqldemoback.pojo.Student;
import com.example.mssqldemoback.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}

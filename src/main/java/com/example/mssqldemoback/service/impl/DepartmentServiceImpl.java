package com.example.mssqldemoback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mssqldemoback.mapper.DepartmentMapper;
import com.example.mssqldemoback.pojo.Department;
import com.example.mssqldemoback.service.DepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,
        Department> implements DepartmentService {
}

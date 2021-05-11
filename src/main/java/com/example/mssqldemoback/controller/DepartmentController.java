package com.example.mssqldemoback.controller;


import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.pojo.Department;
import com.example.mssqldemoback.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/mssqldemoback/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Department> list = departmentService.list();
        return Result.ok()
                     .data("data", list);
    }

}


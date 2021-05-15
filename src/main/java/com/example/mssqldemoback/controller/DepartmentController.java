package com.example.mssqldemoback.controller;


import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.pojo.Department;
import com.example.mssqldemoback.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    /**
     * <p>
     * 添加或修改系信息
     * 如果找不到系id则添加，如果找到了则修改拥有的值，但不会修改已选学生人数
     * </p>
     *
     * @param department 要添加或修改的系信息
     * @return Result
     */
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(Department department) {
        department.setStudentNumber(null);
        System.out.println(department);
        boolean b = departmentService.saveOrUpdate(department);
        if (b) {
            return Result.ok()
                         .message("操作成功");
        } else {
            return Result.error()
                         .message("操作失败");
        }
    }

    /**
     * <p>
     * 删除指定id的系
     * </p>
     *
     * @param id 系id
     * @return Result
     */
    @GetMapping("/deleteOne")
    public Result deleteOne(String id) {
        boolean b = departmentService.removeById(id);
        if (b) {
            return Result.ok()
                         .message("删除成功");
        } else {
            return Result.error()
                         .message("删除失败");
        }
    }

}


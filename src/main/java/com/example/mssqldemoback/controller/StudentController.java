package com.example.mssqldemoback.controller;

import com.example.mssqldemoback.dto.BusinessException;
import com.example.mssqldemoback.dto.HttpStatus;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.pojo.Student;
import com.example.mssqldemoback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/mssqldemoback/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Student> list = studentService.list();
        return Result.ok()
                     .data("data", list);
    }
    @GetMapping("/selectById")
    public Result selectById(String id) {
        Student byId = studentService.getById(id);
        return Result.ok()
                     .data("data", byId);
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        Student byId = studentService.getById(username);
        if (byId == null) {
            throw new BusinessException(HttpStatus.NOT_ACCEPTABLE, "用户不存在");
        } else if (byId.getPwd()
                       .equals(password)) {
            return Result.ok()
                         .data("data", byId);
        } else {
            throw new BusinessException(HttpStatus.NOT_ACCEPTABLE, "密码错误");
        }
    }
}


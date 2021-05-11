package com.example.mssqldemoback.controller;

import com.example.mssqldemoback.dto.BusinessException;
import com.example.mssqldemoback.dto.HttpStatus;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.pojo.Student;
import com.example.mssqldemoback.pojo.Teacher;
import com.example.mssqldemoback.service.TeacherService;
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
@RequestMapping("/mssqldemoback/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Teacher> list = teacherService.list();
        return Result.ok()
                     .data("data", list);
    }
    @PostMapping("/login")
    public Result login(String username, String password) {
        Teacher byId = teacherService.getById(username);
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
    @GetMapping("/selectById")
    public Result selectById(String id) {
        Teacher byId = teacherService.getById(id);
        return Result.ok()
                     .data("data", byId);
    }
}


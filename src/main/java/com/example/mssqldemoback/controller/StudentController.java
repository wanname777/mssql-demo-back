package com.example.mssqldemoback.controller;

import com.example.mssqldemoback.dto.BusinessException;
import com.example.mssqldemoback.dto.HttpStatus;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.pojo.Department;
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
    /**
     * <p>
     * 添加或修改学生信息
     * 如果找不到学生id则添加，如果找到了则修改拥有的值
     * </p>
     *
     * @param student 要添加或修改的学生信息
     * @return Result
     */
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(Student student) {
        System.out.println(student);
        boolean b = studentService.saveOrUpdate(student);
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
     * 删除指定id的学生
     * </p>
     *
     * @param id 学生id
     * @return Result
     */
    @GetMapping("/deleteOne")
    public Result deleteOne(String id) {
        boolean b = studentService.removeById(id);
        if (b) {
            return Result.ok()
                         .message("删除成功");
        } else {
            return Result.error()
                         .message("删除失败");
        }
    }
}


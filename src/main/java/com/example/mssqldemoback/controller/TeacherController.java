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
    /**
     * <p>
     * 添加或修改教师信息
     * 如果找不到教师id则添加，如果找到了则修改拥有的值
     * </p>
     *
     * @param teacher 要添加或修改的教师信息
     * @return Result
     */
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(Teacher teacher) {
        System.out.println(teacherService);
        boolean b = teacherService.saveOrUpdate(teacher);
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
     * 删除指定id的教师
     * </p>
     *
     * @param id 教师id
     * @return Result
     */
    @GetMapping("/deleteOne")
    public Result deleteOne(String id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return Result.ok()
                         .message("删除成功");
        } else {
            return Result.error()
                         .message("删除失败");
        }
    }
}


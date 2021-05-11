package com.example.mssqldemoback.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/mssqldemoback/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Course> list = courseService.list();
        return Result.ok()
                     .data("data", list);
    }

    @GetMapping("/selectAllOpened")
    public Result selectAllOpened() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("is_open", 1);
        List<Course> list = courseService.list(wrapper);
        return Result.ok()
                     .data("data", list);
    }

    @GetMapping("/testCache")
    public Result testCache() {
        List<Course> courseList = null;
        for (int i = 0; i < 10; i++) {
            courseList = courseService.list();
        }
        return Result.ok()
                     .data("data", courseList);
    }
}


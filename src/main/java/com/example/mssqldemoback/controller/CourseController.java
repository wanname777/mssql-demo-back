package com.example.mssqldemoback.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.service.CourseService;
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
@RequestMapping("/mssqldemoback/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * <p>
     * 获取全部课程
     * </p>
     *
     * @return Result
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Course> list = courseService.list();
        return Result.ok()
                     .data("data", list);
    }

    /**
     * <p>
     * 获取所有正在开设的课程
     * </p>
     *
     * @return Result
     */
    @GetMapping("/selectAllOpened")
    public Result selectAllOpened() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("is_open", 1);
        List<Course> list = courseService.list(wrapper);
        return Result.ok()
                     .data("data", list);
    }

    /**
     * <p>
     * 添加或修改课程信息
     * 如果找不到课程id则添加，如果找到了则修改拥有的值，但不会修改已选学生人数
     * </p>
     *
     * @param course 要添加或修改的课程信息
     * @return Result
     */
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(Course course) {
        course.setChooseNumber(null);
        System.out.println(course);
        boolean b = courseService.saveOrUpdate(course);
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
     * 删除制定id的课程
     * </p>
     *
     * @param id 课程id
     * @return Result
     */
    @GetMapping("/deleteOne")
    public Result deleteOne(String id) {
        boolean b = courseService.removeById(id);
        if (b) {
            return Result.ok()
                         .message("删除成功");
        } else {
            return Result.error()
                         .message("删除失败");
        }
    }
}


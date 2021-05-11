package com.example.mssqldemoback.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.StudentCourse;
import com.example.mssqldemoback.service.StudentCourseService;
import com.example.mssqldemoback.vo.StudentCourseVo;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/mssqldemoback/student-course")
@Slf4j
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/selectByStudentId")
    public Result selectByStudentId(String id) {
        // QueryWrapper<StudentCourse> queryWrapper=new QueryWrapper<>();
        // queryWrapper.eq("student_id",id);
        log.info("select by student id...");
        List<StudentCourseVo> list =
                studentCourseService.getStudentCourseVo(id);
        return Result.ok()
                     .data("data", list);
    }

    @GetMapping("/deleteOneCourse")
    public Result deleteOneCourse(String studentId, String courseId) {
        QueryWrapper<StudentCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId)
                    .eq("course_id", courseId);
        boolean remove = studentCourseService.remove(queryWrapper);
        if (remove) {
            return Result.ok()
                         .message("删除成功");
        } else {
            return Result.error()
                         .message("删除失败");
        }
    }
    @GetMapping("/insertOneCourse")
    public Result insertOneCourse(String studentId,String courseId){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        boolean save = studentCourseService.save(studentCourse);
        if (save){
            return Result.ok().message("插入成功");
        }else {
            return Result.error().message("插入失败");
        }
    }
}


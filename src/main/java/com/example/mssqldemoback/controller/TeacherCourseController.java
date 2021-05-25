package com.example.mssqldemoback.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.TeacherCourse;
import com.example.mssqldemoback.service.TeacherCourseService;
import com.example.mssqldemoback.vo.TeacherCourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RequestMapping("/mssqldemoback/teacher-course")
@Slf4j
public class TeacherCourseController {
    @Autowired
    private TeacherCourseService teacherCourseService;

    @GetMapping("/selectByTeacherId")
    public Result selectByStudentId(String id, Integer current, Integer size) {
        // QueryWrapper<StudentCourse> queryWrapper=new QueryWrapper<>();
        // queryWrapper.eq("student_id",id);
        log.info("select by teacher id...");
        Page<TeacherCourseVo> teacherCourseVoPage = new Page<>(current, size);
        Page<TeacherCourseVo> page =
                teacherCourseService.getTeacherCourseVo(id,
                        teacherCourseVoPage);
        List<TeacherCourseVo> list = page.getRecords();
        long pages = page.getPages();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("pages", pages);
        hashMap.put("data", list);
        return Result.ok()
                     .data("data", hashMap);
    }

    @GetMapping("/deleteOneCourse")
    public Result deleteOneCourse(String teacherId, String courseId) {
        QueryWrapper<TeacherCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", teacherId)
                    .eq("course_id", courseId);
        boolean remove = teacherCourseService.remove(queryWrapper);
        if (remove) {
            return Result.ok()
                         .message("删除成功");
        } else {
            return Result.error()
                         .message("删除失败");
        }
    }
    @GetMapping("/insertOneCourse")
    public Result insertOneCourse(String teacherId,String courseId){
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setTeacherId(teacherId);
        teacherCourse.setCourseId(courseId);
        boolean save = teacherCourseService.save(teacherCourse);
        if (save){
            return Result.ok().message("插入成功");
        }else {
            return Result.error().message("插入失败");
        }
    }

}


package com.example.mssqldemoback;

import com.example.mssqldemoback.pojo.Course;
import com.example.mssqldemoback.service.CourseService;
import io.swagger.annotations.Authorization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MssqlDemoBackApplicationTests {
    @Autowired
    private CourseService courseService;
    @Test
    void contextLoads() {
    }
    @Test
    void testUpdate(){
        Course course = new Course();
        course.setId("10003");
        course.setName("nihao");
        boolean b = courseService.updateById(course);
        System.out.println(b);
    }
}

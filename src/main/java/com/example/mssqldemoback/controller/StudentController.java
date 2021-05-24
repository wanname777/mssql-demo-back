package com.example.mssqldemoback.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.mssqldemoback.dto.BusinessException;
import com.example.mssqldemoback.dto.HttpStatus;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Student;
import com.example.mssqldemoback.service.StudentService;
import com.example.mssqldemoback.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Slf4j
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

    @GetMapping("/jwt-login")
    public Result jwtLogin(String username, String password) {

        log.info("用户名：{}", username);
        log.info("密码:{}", password);
        Student byId = studentService.getById(username);
        if (byId == null) {
            throw new BusinessException(HttpStatus.NOT_ACCEPTABLE, "用户不存在");
        } else if (byId.getPwd()
                       .equals(password)) {
            Map<String, String> map = new HashMap<>();
            map.put("name", byId.getName());
            map.put("dept", byId.getDept());
            String token = JwtUtil.getToken(map);
            return Result.ok()
                         .message("登陆成功")
                         .data("info", token);
        } else {
            throw new BusinessException(HttpStatus.NOT_ACCEPTABLE, "密码错误");
        }
    }

    @PostMapping("/jwt-test-token")
    public Result jwtTestToken(String token, String detail) {
        log.info("当前token：{}", token);
        DecodedJWT verify = JwtUtil.verify(token);
        log.info("username:{}", verify.getClaim("username"));
        return Result.ok()
                     .message("验证成功")
                     .data("info", detail);
    }
}


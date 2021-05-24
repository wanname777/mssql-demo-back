package com.example.mssqldemoback.controller;

import com.example.mssqldemoback.dto.BusinessException;
import com.example.mssqldemoback.dto.HttpStatus;
import com.example.mssqldemoback.dto.Result;
import com.example.mssqldemoback.pojo.Manager;
import com.example.mssqldemoback.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
@RestController
@RequestMapping("/mssqldemoback/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/selectById")
    public Result selectById(String id) {
        Manager byId = managerService.getById(id);
        return Result.ok()
                     .data("data", byId);
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        Manager byId = managerService.getById(username);
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

    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(Manager manager) {
        System.out.println(manager);
        boolean b = managerService.saveOrUpdate(manager);
        if (b) {
            return Result.ok()
                         .message("操作成功");
        } else {
            return Result.error()
                         .message("操作失败");
        }
    }
}


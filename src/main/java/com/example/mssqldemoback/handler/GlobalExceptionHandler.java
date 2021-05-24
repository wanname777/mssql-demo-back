package com.example.mssqldemoback.handler;

import com.example.mssqldemoback.dto.BusinessException;
import com.example.mssqldemoback.dto.HttpStatus;
import com.example.mssqldemoback.dto.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhang
 * <p>
 * 无法处理自带的404
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.error()
                     .code(HttpStatus.ERROR)
                     .message(e.getMessage());
    }

    @ExceptionHandler(value = BusinessException.class)
    public Result businessExceptionHandler(BusinessException e) {
        return Result.error()
                     .code(e.getCode())
                     .message(e.getMessage());
    }
}

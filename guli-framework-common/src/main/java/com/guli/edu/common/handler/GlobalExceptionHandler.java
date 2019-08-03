package com.guli.edu.common.handler;

import com.guli.edu.common.entity.vo.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultEntity error(Exception e){
        log.error(e.getMessage());
        return ResultEntity.error().message(e.getMessage());
    }
}

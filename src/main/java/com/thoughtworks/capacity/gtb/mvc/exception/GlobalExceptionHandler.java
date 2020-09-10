package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        // 业务错误
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException)e;
            return ResponseEntity.badRequest().body(Result.errorBusiness(globalException.getException()));
        }

        // 系统错误
        return ResponseEntity.badRequest().body(Result.errorSystem());
    }
}

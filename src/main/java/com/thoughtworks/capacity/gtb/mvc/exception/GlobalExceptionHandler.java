package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<?> handleGlobalException(GlobalException e) {
        return ResponseEntity.badRequest().body(Result.errorBusiness(e.getException()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidExceptionException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder msg = new StringBuilder();
        if (bindingResult.hasFieldErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                msg.append(fieldError.getDefaultMessage()).append(";");
            }
        }
        return ResponseEntity.badRequest().body(Result.errorBusiness(msg.toString()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationExceptionExceptionException(ConstraintViolationException e) {
        String message = "";
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            message = constraintViolation.getMessage();
        }
        return ResponseEntity.badRequest().body(Result.errorBusiness(message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.badRequest().body(Result.errorSystem());
    }
}

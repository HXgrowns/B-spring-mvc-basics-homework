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
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
            return ResponseEntity.badRequest().body(Result.errorBusiness(exception.getException()));
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;

            BindingResult bindingResult = exception.getBindingResult();
            if (bindingResult.hasFieldErrors()) {
                for (FieldError fieldError : bindingResult.getFieldErrors()) {
                    String msg = fieldError.getDefaultMessage();
                    return ResponseEntity.badRequest().body(Result.errorBusiness(msg));
                }
            }
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException exception = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
            for (ConstraintViolation<?> constraintViolation : constraintViolations) {
                String message = constraintViolation.getMessage();
                return ResponseEntity.badRequest().body(Result.errorBusiness(message));
            }
        }

        return ResponseEntity.badRequest().body(Result.errorSystem());
    }
}

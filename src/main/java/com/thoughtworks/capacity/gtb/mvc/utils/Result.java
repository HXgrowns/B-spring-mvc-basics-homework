package com.thoughtworks.capacity.gtb.mvc.utils;

import com.thoughtworks.capacity.gtb.mvc.exception.ExceptionEnum;

public class Result<T> {
    private int code;
    private String message;
    private T data;
    private final int DEFAULT_BUSINESS_ERROR_CODE = 2;

    private Result(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    private Result(String msg) {
        this.message = msg;
        this.code = DEFAULT_BUSINESS_ERROR_CODE;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(ExceptionEnum.SUCCESS);
        result.setData(data);
        return result;
    }


    public static Result<?> errorBusiness(ExceptionEnum exceptionEnum) {
        return new Result<>(exceptionEnum);
    }


    public static Result<?> errorBusiness(String msg) {
        return new Result<>(msg);
    }

    public static Result<?> errorSystem() {
        return new Result<>(ExceptionEnum.UNKNOWN_ERROR);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

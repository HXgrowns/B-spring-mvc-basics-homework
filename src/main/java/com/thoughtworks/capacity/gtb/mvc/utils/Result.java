package com.thoughtworks.capacity.gtb.mvc.utils;

import com.thoughtworks.capacity.gtb.mvc.exception.ExceptionEnum;

public class Result<T> {
    private int code;
    private String message;
    private T data;

    private Result(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(ExceptionEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 业务错误
     *
     * @param exceptionEnum
     * @return
     */
    public static Result<?> errorBusiness(ExceptionEnum exceptionEnum) {
        return new Result<>(exceptionEnum);
    }

    /**
     * 系统错误
     *
     * @return
     */
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

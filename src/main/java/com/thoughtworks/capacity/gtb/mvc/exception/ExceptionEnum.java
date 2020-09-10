package com.thoughtworks.capacity.gtb.mvc.exception;

public enum ExceptionEnum {
    SUCCESS(0, "success"),
    UNKNOWN_ERROR(1, "unknown error"),
    USER_CAN_NOT_EMPTY(2, "用户不可为空"),
    NAME_CAN_NOT_EMPTY(3, "用户名不可为空"),
    NAME_INVALID(4, "用户名不合法"),
    PASSWORD_CAN_NOT_EMPTY(5, "密码不可为空"),
    PASSWORD_INVALID(6, "密码不合法"),
    EMAIL_INVALID(7, "邮箱地址不合法"),
    NAME_DUPLICATE(8, "用户名不可重复"),
    NAME_OR_PASSWORD_INCORRECT(9, "用户名或密码错误"),
    ;

    private int code;
    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
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
}

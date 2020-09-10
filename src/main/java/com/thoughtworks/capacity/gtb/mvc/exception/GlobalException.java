package com.thoughtworks.capacity.gtb.mvc.exception;

public class GlobalException extends RuntimeException {
    private ExceptionEnum exception;

    private GlobalException(ExceptionEnum exception) {
        this.exception = exception;
    }

    public static GlobalException newException(ExceptionEnum exception) {
        return new GlobalException(exception);
    }

    public ExceptionEnum getException() {
        return exception;
    }

    public void setException(ExceptionEnum exception) {
        this.exception = exception;
    }
}

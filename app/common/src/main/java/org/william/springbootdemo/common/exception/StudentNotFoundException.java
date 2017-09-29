package org.william.springbootdemo.common.exception;

import org.william.springbootdemo.common.rest.error.ErrorCode;

/**
 * Created by huawai on 2017/9/29. Description:
 */
public class StudentNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    private String name;

    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public StudentNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public StudentNotFoundException(ErrorCode errorCode,String name) {
        this.errorCode = errorCode;
        this.name = name;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package org.william.springbootdemo.common.exception;

import org.william.springbootdemo.common.rest.error.ErrorCode;

/**
 * Created by huawai on 2017/9/29. Description:
 */
public class StudentNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    private transient Object[] args;

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

    public StudentNotFoundException(ErrorCode errorCode,Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Object[] getArgs() {
        return this.args;
    }
}

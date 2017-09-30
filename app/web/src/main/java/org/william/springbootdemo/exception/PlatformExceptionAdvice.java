package org.william.springbootdemo.exception;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.william.springbootdemo.common.exception.StudentNotFoundException;
import org.william.springbootdemo.common.rest.error.RestError;

/**
 * Created by huawai on 2017/9/29.
 * Description:自定义exception 处理
 */
@ControllerAdvice(basePackages = "org.william.springbootdemo.web.controller")
public class PlatformExceptionAdvice extends DefaultExceptionAdvice {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<RestError> studentNotFoundExceptionHandler(StudentNotFoundException e, Locale locale) {
        return toHttpResponse(HttpStatus.BAD_REQUEST, e.getErrorCode(),locale, e.getArgs());
    }
}

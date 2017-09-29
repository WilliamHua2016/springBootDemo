package org.william.springbootdemo.common.rest.error;

/**
 * Super class for RESTful service layer error.
 *
 */
public abstract class RestError {

    private Integer code;

    protected RestError(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}

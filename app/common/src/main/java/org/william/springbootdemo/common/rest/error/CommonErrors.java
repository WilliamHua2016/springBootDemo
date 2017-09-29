package org.william.springbootdemo.common.rest.error;

/**
 * Common error code definition.
 *
 * Do not modify this file.
 *
 */
public enum CommonErrors implements ErrorCode {

    // 1000XX common errors
    COMMON_INTERNAL_ERROR(100001),

    COMMON_SERVICE_UNAVAILABLE(100002),

    COMMON_UNAUTHENTICATED(100003),

    COMMON_UNAUTHORIZED(100004),

    COMMON_OPERATION_NOT_ALLOWED(100005),

    COMMON_ILLEGAL_ARGUMENT(100010),

    COMMON_PARAMETER_MISSING(100011),

    STUDENT_NOT_FOUND(200001);

    private final int code;

    private CommonErrors(int code) {
        this.code = code;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String messageKey() {
        return super.name().replace('_', '.').toLowerCase();
    }

}

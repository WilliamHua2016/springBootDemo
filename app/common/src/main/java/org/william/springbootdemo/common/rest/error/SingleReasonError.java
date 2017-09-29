package org.william.springbootdemo.common.rest.error;

/**
 * Error with single reason.
 *
 */
public final class SingleReasonError extends RestError {

    private String message;

    public SingleReasonError(Integer code, String message) {
        super(code);

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error:\n code: " + super.getCode() + "\n message: " + message;
    }

}

package org.william.springbootdemo.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.william.springbootdemo.common.rest.error.*;

/**
 * Created by huawai on 2017/9/29.
 *
 * Description: Default System Error handler
 *
 */
public abstract class DefaultExceptionAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionAdvice.class);
    @Autowired
    @Qualifier("errorMessageSource")
    private MessageSource messageSource;

    protected static final ErrorCode INTERNAL_ERROR;

    protected static final ErrorCode ILLEGAL_ARGUMENT;

    protected static final HttpStatus HTTP_400;

    protected static final HttpStatus HTTP_500;

    @ExceptionHandler({OutOfMemoryError.class})
    @ResponseBody
    public ResponseEntity<RestError> oomHandler(OutOfMemoryError e, Locale locale) {
        LOGGER.error("OOM", e);
        return this.toHttpResponse(HTTP_500, INTERNAL_ERROR, locale, new Object[0]);
    }

    @ExceptionHandler({StackOverflowError.class})
    @ResponseBody
    public ResponseEntity<RestError> sofHandler(StackOverflowError e, Locale locale) {
        LOGGER.error("SOF", e);
        return this.toHttpResponse(HTTP_500, INTERNAL_ERROR, locale, new Object[0]);
    }

    @ExceptionHandler({IndexOutOfBoundsException.class})
    @ResponseBody
    public ResponseEntity<RestError> ioobHandler(IndexOutOfBoundsException e, Locale locale) {
        LOGGER.error("IOOB", e);
        return this.toHttpResponse(HTTP_500, INTERNAL_ERROR, locale, new Object[0]);
    }

    @ExceptionHandler({NullPointerException.class})
    @ResponseBody
    public ResponseEntity<RestError> nullPointerExceptionHandler(NullPointerException e, Locale locale) {
        LOGGER.error("NPE", e);
        return this.toHttpResponse(HTTP_500, INTERNAL_ERROR, locale, new Object[0]);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseEntity<RestError> constraintViolationExceptionHandler(MethodArgumentNotValidException e, Locale locale) {
        LOGGER.error("Constraint violation", e);
        List errors = e.getBindingResult().getAllErrors();
        ArrayList messages = new ArrayList();
        Iterator var5 = errors.iterator();

        while(var5.hasNext()) {
            ObjectError oe = (ObjectError)var5.next();
            messages.add(oe.getDefaultMessage());
        }

        return this.toHttpResponse(HTTP_400, ILLEGAL_ARGUMENT.code(), messages);
    }

    protected ResponseEntity<RestError> toHttpResponse(HttpStatus status, ErrorCode error,
            Locale locale, Object... args) {
        return ResponseEntity.status(status).body(this.toSingleReasonError(error, locale, args));
    }

    protected RestError toSingleReasonError(ErrorCode error, Locale locale, Object... args) {
        int errorCode = error.code();
        String messageKey = error.messageKey();
        String message = null;

        try {
            message = this.messageSource.getMessage(messageKey, args, locale);
        } catch (NoSuchMessageException var8) {
            LOGGER.warn(var8.getMessage());
        }

        if (!StringUtils.hasText(message)) {
            message = messageKey;
        }

        return new SingleReasonError(Integer.valueOf(errorCode), message);
    }

    protected ResponseEntity<RestError> toHttpResponse(HttpStatus status, int errorCode, List<String> messages) {
        return ResponseEntity.status(status).body(new MultiReasonsError(Integer.valueOf(errorCode), messages));
    }

    static {
        INTERNAL_ERROR = CommonErrors.COMMON_INTERNAL_ERROR;
        ILLEGAL_ARGUMENT = CommonErrors.COMMON_ILLEGAL_ARGUMENT;
        HTTP_400 = HttpStatus.BAD_REQUEST;
        HTTP_500 = HttpStatus.INTERNAL_SERVER_ERROR;
    }

}

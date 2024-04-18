package com.course.work.democoursework.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuantityRequestExceededException extends RuntimeException{
    public QuantityRequestExceededException() {
    }

    public QuantityRequestExceededException(String message) {
        super(message);
    }

    public QuantityRequestExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuantityRequestExceededException(Throwable cause) {
        super(cause);
    }

    public QuantityRequestExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

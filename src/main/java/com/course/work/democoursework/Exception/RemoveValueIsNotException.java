package com.course.work.democoursework.Exception;

public class RemoveValueIsNotException extends RuntimeException {
    public RemoveValueIsNotException() {
    }

    public RemoveValueIsNotException(String message) {
        super(message);
    }

    public RemoveValueIsNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoveValueIsNotException(Throwable cause) {
        super(cause);
    }

    public RemoveValueIsNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.course.work.democoursework.Exception;

public class QuestionIsAlreadyOnTheListException extends RuntimeException{
    public QuestionIsAlreadyOnTheListException() {
    }

    public QuestionIsAlreadyOnTheListException(String message) {
        super(message);
    }

    public QuestionIsAlreadyOnTheListException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionIsAlreadyOnTheListException(Throwable cause) {
        super(cause);
    }

    public QuestionIsAlreadyOnTheListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

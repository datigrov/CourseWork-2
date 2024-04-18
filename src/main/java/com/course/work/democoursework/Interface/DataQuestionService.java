package com.course.work.democoursework.Interface;

import com.course.work.democoursework.Question;

import java.util.Set;

public interface DataQuestionService{
    Question addQuestion(String question, String answer);

    Question remove(String question, String answer);

    Set<Question> all();
}

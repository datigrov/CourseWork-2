package com.course.work.democoursework.Service;

import com.course.work.democoursework.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuations(int amount);
}

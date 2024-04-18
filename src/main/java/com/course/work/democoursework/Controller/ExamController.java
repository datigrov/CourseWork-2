package com.course.work.democoursework.Controller;

import com.course.work.democoursework.Question;
import com.course.work.democoursework.Service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("{amount}")
    Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuations(amount);
    }

}

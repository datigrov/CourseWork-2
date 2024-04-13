package com.course.work.democoursework.serviceTest;
import com.course.work.democoursework.Exception.QuestionIsAlreadyOnTheListException;
import com.course.work.democoursework.Question;
import com.course.work.democoursework.Service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class DataServiceTest {

    private JavaQuestionService javaQuestionService;

    public DataServiceTest(JavaQuestionService javaQuestionService, JavaQuestionService out) {
        this.javaQuestionService = javaQuestionService;
        this.out = out;
    }

    private JavaQuestionService out;
    Question firstQuestion = new Question("What is your name?", "John");
    Question secondQuestion = new Question("How old are you?", "am 18");
    Question thirdQuestion = new Question("Who do you identify with?", "With a mixer");
    List<Question> allQuestions = new ArrayList<>(Set.of(firstQuestion, secondQuestion, thirdQuestion));

    @ParameterizedTest
    @MethodSource("addNewQuestion")
    void addNewQuestion() {
        allQuestions.add(firstQuestion);
        allQuestions.add(secondQuestion);
        allQuestions.add(thirdQuestion);
        if (allQuestions == null) {
            allQuestions.add(firstQuestion);
        }
        Assertions.assertNotNull(allQuestions);
    }

    @ParameterizedTest
    @MethodSource("addGoodTest")
    void addGoodTest() {
        Question question = new Question("What is your name?", "John");
        javaQuestionService.add(question);
        Collection<Question> quaTest = javaQuestionService.getAll();
        assertEquals(1, quaTest.size());
        Question quationActualTest = quaTest.iterator().next();
        assertEquals(question.getQuestion(),quationActualTest.getQuestion());
        assertEquals(question.getAnswer(),quationActualTest.getAnswer());
    }


    @ParameterizedTest
    @MethodSource("getAllTest")
    void getAllTest() {
        when(javaQuestionService.getAll())
                .thenReturn(allQuestions);
        out.add("What is your name?", "John");
        out.add("How old are you?", "am 18");
        out.add("Who do you identify with?", "With a mixer");
        assertEquals(allQuestions, out.getAll());
    }

}

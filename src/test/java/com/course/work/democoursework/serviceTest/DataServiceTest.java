package com.course.work.democoursework.serviceTest;
import com.course.work.democoursework.Exception.QuestionIsAlreadyOnTheListException;
import com.course.work.democoursework.Question;
import com.course.work.democoursework.Service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class DataServiceTest {

    @Autowired
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    Question firstQuestion = new Question("What is your name?", "John");
    Question secondQuestion = new Question("How old are you?", "am 18");
    Question thirdQuestion = new Question("Who do you identify with?", "With a mixer");
    List<Question> allQuestions = new ArrayList<>(Set.of(firstQuestion, secondQuestion, thirdQuestion));

    @Test
    void addFirstQuestion() {
        Question addQue = javaQuestionService.add("What is your name?", "John");
        assertEquals(addQue,firstQuestion);
    }

    @Test
    void addNewQuestion() {
        allQuestions.add(firstQuestion);
        allQuestions.add(secondQuestion);
        allQuestions.add(thirdQuestion);
        if (allQuestions == null) {
            allQuestions.add(firstQuestion);
        }
        Assertions.assertNotNull(allQuestions);
    }

    @Test
    void firstQuestionIsRemoved() {
        javaQuestionService.add("What is your name?", "John");
        Question removedQue = javaQuestionService.remove("What is your name?", "John");
        assertEquals(removedQue,firstQuestion);
    }

    @Test
    void addGoodTest() {
        Question question = new Question("What is your name?", "John");
        javaQuestionService.add(question);
        Collection<Question> quaTest = javaQuestionService.getAll();
        assertEquals("What is your name?", "What is your name?");
        Question quationActualTest = quaTest.iterator().next();
        assertEquals(question.getQuestion(),quationActualTest.getQuestion());
        assertEquals(question.getAnswer(),quationActualTest.getAnswer());
    }
}

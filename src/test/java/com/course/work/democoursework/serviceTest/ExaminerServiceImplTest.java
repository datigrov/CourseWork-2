package com.course.work.democoursework.serviceTest;

import com.course.work.democoursework.Exception.QuantityRequestExceededException;
import com.course.work.democoursework.Question;
import com.course.work.democoursework.Service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService mockJavaQuestionService;
    @InjectMocks
    private JavaQuestionService out;
    Question firstQuestion = new Question("q1", "a1");
    Question secondQuestion = new Question("q2", "a2");
    Question thirdQuestion = new Question("q3", "a3");
    Set<Question> allQuestions = new HashSet<>(Set.of(firstQuestion, secondQuestion, thirdQuestion));


    @Test
    void addGoodTest() {
        Question question = new Question("q1", "a1");
        mockJavaQuestionService.add(question);
        Collection<Question> quaTest = mockJavaQuestionService.getAll();
        assertEquals(1, quaTest.size());
        Question quationActualTest = quaTest.iterator().next();
        assertEquals(question.getQuestion(),quationActualTest.getQuestion());
        assertEquals(question.getAnswer(),quationActualTest.getAnswer());
    }

    @Test
    void removeGoodTest() {
        mockJavaQuestionService.add("q1", "a1");
        when(mockJavaQuestionService.remove("q1", "a1"))
                .thenReturn(firstQuestion);
        assertEquals(firstQuestion, out.remove("q1", "a1"));
        when(mockJavaQuestionService.remove("q1", "a1"))
                .thenThrow(QuantityRequestExceededException.class);
        assertThrows(QuantityRequestExceededException.class,
                () -> out.remove("q1", "a1"));
    }

}

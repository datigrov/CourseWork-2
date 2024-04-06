package com.course.work.democoursework.serviceTest;

import com.course.work.democoursework.Exception.QuestionIsAlreadyOnTheListException;
import com.course.work.democoursework.Exception.QuestionNotFoundException;
import com.course.work.democoursework.Question;
import com.course.work.democoursework.Service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataServiceTest {
    @Mock
    private JavaQuestionService mockJavaQuationService;
    @InjectMocks
    private JavaQuestionService out;
    Question firstQuestion = new Question("q1", "a1");
    Question secondQuestion = new Question("q2", "a2");
    Question thirdQuestion = new Question("q3", "a3");
    Set<Question> allQuestions = new HashSet<>(Set.of(firstQuestion, secondQuestion, thirdQuestion));


    @Test
    void addNewQuestion() {
        when(mockJavaQuationService.add("q1", "a1"))
                .thenReturn(firstQuestion);
        assertEquals(firstQuestion, out.add("q2", "a2"));
    }


    @Test
    void addQuestionCreated() {
        when(mockJavaQuationService.add("q1", "a1"))
                .thenThrow(QuestionIsAlreadyOnTheListException.class);
        assertThrows(QuestionIsAlreadyOnTheListException.class,
                () -> out.add("q1", "a1"));
    }

    @Test
    void removeQuestion() {
        mockJavaQuationService.add("q1", "a1");
        when(mockJavaQuationService.remove("q1", "a1"))
                .thenReturn(firstQuestion);
        assertEquals(firstQuestion, out.remove("q1", "a1"));
        when(mockJavaQuationService.remove("q1", "a1"))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove("q1", "a1"));
    }

    @Test
    void getAllTest() {
        when(mockJavaQuationService.getAll())
                .thenReturn(allQuestions);
        out.add("q1", "a1");
        out.add("q2", "a2");
        out.add("q3", "a3");
        out.add("q4", "a4");
        assertEquals(allQuestions, out.getAll());
    }
}

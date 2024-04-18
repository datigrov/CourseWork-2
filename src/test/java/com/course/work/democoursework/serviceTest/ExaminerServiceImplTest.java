package com.course.work.democoursework.serviceTest;
import com.course.work.democoursework.Exception.QuantityRequestExceededException;
import com.course.work.democoursework.Question;
import com.course.work.democoursework.Service.ExaminerServiceImpl;
import com.course.work.democoursework.Service.JavaQuestionService;
import com.course.work.democoursework.Service.QuestionService;
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
    private ExaminerServiceImpl out;

    @InjectMocks
    Question firstQuestion = new Question("What is your name?", "John");
    Question secondQuestion = new Question("How old are you?", "am 18");
    Question thirdQuestion = new Question("Who do you identify with?", "With a mixer");
    Set<Question> allQuestions = new HashSet<>(Set.of(firstQuestion, secondQuestion, thirdQuestion));

    @Test
    void getQuestionsTest() {
        when(out.getQuations(3))
                .thenReturn(allQuestions);
        assertEquals(allQuestions, out.getQuations(3));

    }


}

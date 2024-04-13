package com.course.work.democoursework.Service;
import com.course.work.democoursework.Exception.QuantityRequestExceededException;
import com.course.work.democoursework.Question;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuations(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new QuantityRequestExceededException();
        }
        return Stream.generate(() -> questionService.getRandomQuestion())
                .distinct().
                limit(amount).
                collect(Collectors.toList());
    }
}

package com.course.work.democoursework.Service;

import com.course.work.democoursework.Exception.RemoveValueIsNotException;
import com.course.work.democoursework.Question;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();
    Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question addQuastion = new Question(question, answer);
        questions.add(addQuastion);
        return addQuastion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            throw new RemoveValueIsNotException("Данные не найдены");
        }
    }

    public Question remove(String question, String answer) {
        Question removeQuation = new Question(question, answer);
        if (questions.remove(removeQuation)) {
            return removeQuation;
        } else {
            throw new RemoveValueIsNotException("Данные не найдены");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomQue = random.nextInt(questions.size());
        return questions.get(randomQue);
    }
}

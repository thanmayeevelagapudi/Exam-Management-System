package com.project.quiz_service.Service;





import org.springframework.http.ResponseEntity;

import com.project.quiz_service.Dto.categoryDto;
import com.project.quiz_service.model.Quiz;

import java.util.List;
 
public interface QuizService {
 
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Long id,Quiz quiz) throws Exception;
    public List<Quiz> getAllQuizzes();
    public void deleteQuiz(Long qid) throws Exception;
    public Quiz getQuizById(Long quizId);
    public List<Quiz> getQuizzesOfCategory(categoryDto category);
    public List<Quiz> getActiveQuizzes();
    public List<Quiz> getActiveQuizzesOfCategory(categoryDto category);
}
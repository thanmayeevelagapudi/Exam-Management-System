package com.project.quiz_service.Service;


import java.util.List;
import java.util.Optional;

import com.project.quiz_service.model.Quiz;
import com.project.quiz_service.model.quizResult;

public interface quizResultService {
    List<quizResult> getAllQuizResults();
    List<quizResult> getQuizResultsOfQuiz(Quiz quiz);
    quizResult saveQuizResult(quizResult quizResult);
    void deleteQuizResult(int id);
    Optional<quizResult> getQuizResultByUsernameAndQuiz(String username, Quiz quiz);
}

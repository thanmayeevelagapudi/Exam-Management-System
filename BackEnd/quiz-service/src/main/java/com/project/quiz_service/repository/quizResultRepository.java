package com.project.quiz_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quiz_service.model.Quiz;
import com.project.quiz_service.model.quizResult;

import java.util.List;
import java.util.Optional;

@Repository
public interface quizResultRepository extends JpaRepository<quizResult,Integer> {
    List<quizResult> findByQuiz(Quiz quiz);
    Optional<quizResult> findByQuizAndUsername(Quiz quiz, String username);
}

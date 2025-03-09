package com.project.quiz_service.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.quiz_service.model.Quiz;
import com.project.quiz_service.model.quizResult;
import  com.project.quiz_service.repository.quizResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class quizResultServiceImpl implements quizResultService {

    @Autowired
    private quizResultRepository quizResultRepository;


    @Override
    public List<quizResult> getAllQuizResults() {
        return quizResultRepository.findAll();
    }

    @Override
    public List<quizResult> getQuizResultsOfQuiz(Quiz quiz) {
        return quizResultRepository.findByQuiz(quiz);
    }

    @Override
    public quizResult saveQuizResult(quizResult quizResult) {
        return quizResultRepository.save(quizResult);
    }

    @Override
    public void deleteQuizResult(int id) {
        quizResult quizResult=new quizResult();
        quizResult.setId(id);
        this.quizResultRepository.delete(quizResult);
    }

    @Override
    public Optional<quizResult> getQuizResultByUsernameAndQuiz(String username, Quiz quiz) {
        return quizResultRepository.findByQuizAndUsername(quiz, username);
    }


}

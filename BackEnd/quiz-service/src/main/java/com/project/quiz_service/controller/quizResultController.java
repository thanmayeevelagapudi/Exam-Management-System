package com.project.quiz_service.controller;
import  com.project.quiz_service.Service.quizResultService;
import com.project.quiz_service.model.Quiz;
import com.project.quiz_service.model.quizResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class quizResultController {

    @Autowired
    private quizResultService quizResultService;

    @GetMapping("/quizResult/all")
    public List<quizResult> getAllQuizResults() {
        return quizResultService.getAllQuizResults();
    }

    @GetMapping("/quizResult/quiz/{qid}")
    public List<quizResult> getQuizResultsOfQuiz(@PathVariable long qid) {
        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        return quizResultService.getQuizResultsOfQuiz(quiz);
    }

    @PostMapping("/quizResult/")
    public quizResult addQuizResult(@RequestBody quizResult quizResult) {
        return quizResultService.saveQuizResult(quizResult);
    }

    @DeleteMapping("/quizResult/{id}")
    public void deleteQuizResult(@PathVariable int id) {
        quizResultService.deleteQuizResult(id);
    }

    @GetMapping("/quizResult/quiz/{username}/{qid}")
    public Optional<quizResult> getQuizResultByUsernameAndQuiz(@PathVariable String username, @PathVariable long qid) {
        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        return quizResultService.getQuizResultByUsernameAndQuiz(username, quiz);
    }
}

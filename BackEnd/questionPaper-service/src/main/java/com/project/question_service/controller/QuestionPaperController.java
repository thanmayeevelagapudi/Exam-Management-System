package com.project.question_service.controller;

import com.project.question_service.model.QuestionPaper;
import com.project.question_service.service.QuestionPaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionPaperController {

    @Autowired
    private QuestionPaperService questionPaperService;

    @PostMapping("/questionPaper/add")
    public QuestionPaper addQuestionPaper(@RequestBody QuestionPaper questionPaper) {
        return questionPaperService.addQuestionPaper(questionPaper);
    }

    @PutMapping("/questionPaper/update/{id}")
    public QuestionPaper updateQuestionPaper(@PathVariable("id") Long id, @RequestBody QuestionPaper questionPaper) throws Exception {
        return questionPaperService.updateQuestionPaper(id, questionPaper);
    }

    @GetMapping("/questionPaper/getAll")
    public List<QuestionPaper> getAllQuestionPapers() {
        return questionPaperService.getAllQuestionPapers();
    }

    @DeleteMapping("/questionPaper/delete/{qid}")
    public void deleteQuestionPaper(@PathVariable("qid") Long qid) throws Exception {
        questionPaperService.deleteQuestionPaper(qid);
    }

    @GetMapping("/questionPaper/{quizId}")
    public QuestionPaper getQuestionPaperById(@PathVariable("quizId") Long quizId) {
        return questionPaperService.getQuestionPaperById(quizId);
    }
}

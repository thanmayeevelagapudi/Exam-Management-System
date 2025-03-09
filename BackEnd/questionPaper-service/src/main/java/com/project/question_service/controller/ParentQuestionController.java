package com.project.question_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.QuestionPaper;
import com.project.question_service.service.ParentQuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = "http://localhost:4200")
public class ParentQuestionController {

    @Autowired
    private ParentQuestionService ParentQuestionService;

    @PostMapping("/parentQuestion/add")
    public ParentQuestion addQuestion(@RequestBody ParentQuestion ParentQuestion) {
        return ParentQuestionService.addQuestion(ParentQuestion);
    }

    @PutMapping("/parentQuestion/update/{id}")
    public ParentQuestion updateQuestion(@PathVariable("id") Long id, @RequestBody ParentQuestion ParentQuestion) throws Exception {
        return ParentQuestionService.updateQuestion(id, ParentQuestion);
    }

    @GetMapping("/parentQuestion/getAll")
    public List<ParentQuestion> getAllQuestions() {
        return ParentQuestionService.getAllQuestions();
    }

    @GetMapping("/parentQuestion/{qId}")
    public ParentQuestion getQuestionById(@PathVariable("qId") Long qId) {
        return ParentQuestionService.getQuestionById(qId);
    }

    @DeleteMapping("/parentQuestion/delete/{qId}")
    public void deleteQuestion(@PathVariable("qId") Long qId) {
        ParentQuestionService.deleteQuestion(qId);
    }

    @GetMapping("/parentQuestion/getByQuestionPaper/{qid}")
    public List<ParentQuestion> getQuestionsOfQuestionPaper(@PathVariable Long qid) {
        QuestionPaper questionPaper = new QuestionPaper();
        questionPaper.setQid(qid);
        return ParentQuestionService.getQuestionsOfQuestionPaper(questionPaper);
    }
}

package com.project.question_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.SubQuestion;
import com.project.question_service.repository.ParentQuestionRepo;
import com.project.question_service.service.SubQuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = "http://localhost:4200")
public class SubQuestionsController {

    @Autowired
    private  SubQuestionService SubQuestionService;
    
    @Autowired
    private ParentQuestionRepo parentquestionrepo;


    @PostMapping("/subQuestion/add")
    public ResponseEntity<SubQuestion> addSubQuestion(@RequestBody SubQuestion SubQuestion) throws Exception {
        SubQuestion newSubQuestion = SubQuestionService.addSubQuestion(SubQuestion);
        return new ResponseEntity<>(newSubQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/subQuestion/update/{id}")
    public ResponseEntity<SubQuestion> updateSubQuestion(@PathVariable("id") Long id, @RequestBody SubQuestion SubQuestion) {
        try {
            SubQuestion updatedSubQuestion = SubQuestionService.updateSubQuestion(id, SubQuestion);
            return new ResponseEntity<>(updatedSubQuestion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/subQuestion/all")
    public ResponseEntity<List<SubQuestion>> getAllSubQuestions() {
        List<SubQuestion> SubQuestions = SubQuestionService.getAllSubQuestions();
        return new ResponseEntity<>(SubQuestions, HttpStatus.OK);
    }

    @GetMapping("/subQuestion/{id}")
    public ResponseEntity<SubQuestion> getSubQuestionById(@PathVariable("id") Long subQId) {
        SubQuestion subQ = SubQuestionService.getSubQuestionById(subQId);
        return subQ != null ? new ResponseEntity<>(subQ, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/subQuestion/delete/{id}")
    public ResponseEntity<Void> deleteSubQuestion(@PathVariable("id") Long subQId) {
        SubQuestionService.deleteSubQuestion(subQId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/subQuestion/ParentQuestion/{id}")
    public ResponseEntity<List<SubQuestion>> getSubQuestionsOfParentQuestion(@PathVariable("id") Long parentId) {
        ParentQuestion parentQ = new ParentQuestion();
        parentQ.setQid(parentId);
        List<SubQuestion> SubQuestions = SubQuestionService.getSubQuestionsOfParentQuestion(parentQ);
        return new ResponseEntity<>(SubQuestions, HttpStatus.OK);
    }
}

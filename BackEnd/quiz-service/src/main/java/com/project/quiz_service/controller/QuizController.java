package com.project.quiz_service.controller;

import com.project.quiz_service.Dto.categoryDto;
import com.project.quiz_service.Service.QuizService;
import com.project.quiz_service.client.CategoryClient;
import com.project.quiz_service.model.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
 
@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {
 
    @Autowired
    private QuizService quizService;
    
    @Autowired
    private CategoryClient category;
 
    @PostMapping("/")
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return this.quizService.addQuiz(quiz);
    }
 
    @GetMapping("/")
    public ResponseEntity<?> getAllQuizzes() {
        return ResponseEntity.ok(this.quizService.getAllQuizzes());
    }
 
    @GetMapping("/{qid}")
    public Quiz getQuizById(@PathVariable Long qid) {
        return this.quizService.getQuizById(qid);
    }
 
    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) throws Exception {
        return this.quizService.updateQuiz(id, quiz);
    }
 
    @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable Long qid) throws Exception {
        this.quizService.deleteQuiz(qid);
    }
 
    @GetMapping("/category/{cid}")
    public ResponseEntity<?> getQuizzesOfCategory(@PathVariable Long cid) {
        // Use the CategoryClient to fetch category data from the category-service
        categoryDto categoryDTO = category.getCategoryById(cid);  // categoryClient is the Feign client

        // Check if category exists (optional, for error handling)
        if (categoryDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }

        // Now pass the categoryDTO to the QuizService to get the quizzes related to the category
        return ResponseEntity.ok(this.quizService.getQuizzesOfCategory(categoryDTO));  // Pass CategoryDTO to the service
    }

 
    @GetMapping("/active")
    public ResponseEntity<?> getActiveQuizzes(){
        return ResponseEntity.ok(this.quizService.getActiveQuizzes());
    }
 
    @GetMapping("/category/active/{cid}")
    public ResponseEntity<?> getActiveQuizzes(@PathVariable Long cid) {
        categoryDto categoryDTO=category.getCategoryById(cid);
        if(categoryDTO==null)
        {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }
        
        return ResponseEntity.ok(this.quizService.getActiveQuizzesOfCategory(categoryDTO));
 
 
    }
}


package com.project.questions.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.questions.Dto.QuizDto;
import com.project.questions.Service.QuestionService;
import com.project.questions.client.QuizClient;
import com.project.questions.model.Question;
@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
	@Autowired
    private QuestionService questionService;
	@Autowired
	private QuizClient quiz;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllQuestions(){
        return ResponseEntity.ok(this.questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id){
        return this.questionService.getQuestionById(id);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id,@RequestBody Question question) throws Exception {
        return this.questionService.updateQuestion(id,question);
    }

    @DeleteMapping("/{qid}")
    public void deleteQuestion(@PathVariable Long qid){
        this.questionService.deleteQuestion(qid);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getAllQuestionsOfQuiz(@PathVariable Long quizId) {
        try {
            // Fetch all questions for the given quiz ID
            List<Question> questions = this.questionService.getQuestionsByQuizId(quizId);

            // Limit the questions based on quiz configuration if needed
            // Assuming the number of questions limit is part of the quizId logic
            if (questions != null && !questions.isEmpty()) {
                // Shuffle the questions for randomness
                Collections.shuffle(questions);
            }

            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/quiz/all/{qId}")
    public ResponseEntity<List<Question>> getAllQuestionsOfQuizAdmin(@PathVariable Long qId) {
       List<Question> questions=this.questionService.getQuestionsByQuizId(qId);
       return  ResponseEntity.ok(questions);
    }

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> submittedQuestions) {
        int marksGot = 0;
        int correctAnswers = 0;
        int attempts = 0;

        for (Question submittedQuestion : submittedQuestions) {
            // Fetch the actual question from the database using its ID
            Question question = this.questionService.get(submittedQuestion.getQid());
            if (question.getAnswer().trim().equalsIgnoreCase(submittedQuestion.getGivenAnswer())) {
                // If the submitted answer matches the actual answer
                correctAnswers++;
                long id=question.getQuizId();
                double marksPerQuestion = Double.parseDouble(quiz.getQuizById(id).getMaxMarks()) / submittedQuestions.size();
                marksGot += (int) marksPerQuestion;
            }

            if (submittedQuestion.getGivenAnswer() != null && !submittedQuestion.getGivenAnswer().isEmpty()) {
                // If the submitted question has a non-empty given answer
                attempts++;
            }
        }

        // Prepare the response map with results
        Map<String, Object> evaluationResult = Map.of(
            "marksGot", marksGot,
            "correctAnswers", correctAnswers,
            "attempts", attempts
        );

        return ResponseEntity.ok(evaluationResult);
    }






}




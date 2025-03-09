package com.project.questions.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.questions.Dto.QuizDto;
import com.project.questions.model.Question;


@FeignClient(name = "quiz-service", url = "http://localhost:9004")  // URL of the quiz service
public interface QuizClient {

	 @GetMapping("/quiz/{qid}")
	    public QuizDto getQuizById(@PathVariable Long qid);  //quizId

}

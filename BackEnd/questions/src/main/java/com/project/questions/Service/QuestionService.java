package com.project.questions.Service;

import java.util.List;

import com.project.questions.Dto.QuizDto;
import com.project.questions.model.Question;


public interface QuestionService {
	
	public Question addQuestion(Question question);
	public List<Question> getAllQuestions();
	public Question getQuestionById(Long qId);
    public Question updateQuestion(Long id,Question question) throws Exception;
    public void deleteQuestion(Long qId);
    
    public Question get(Long qid);
	public List<Question> getQuestionsByQuizId(Long quizId);

}

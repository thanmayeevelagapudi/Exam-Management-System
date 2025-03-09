package com.project.question_service.service;



import java.util.List;

import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.QuestionPaper;

public interface ParentQuestionService {

    public ParentQuestion addQuestion(ParentQuestion parentQuestion);
    public ParentQuestion updateQuestion(Long id, ParentQuestion parentQuestion) throws Exception;
    public List<ParentQuestion> getAllQuestions();
    public ParentQuestion getQuestionById(Long qId);
    public void deleteQuestion(Long qId);
    public List<ParentQuestion> getQuestionsOfQuestionPaper(QuestionPaper questionPaper);

}
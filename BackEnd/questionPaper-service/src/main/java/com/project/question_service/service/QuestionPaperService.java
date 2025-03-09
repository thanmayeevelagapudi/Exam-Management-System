package com.project.question_service.service;



import java.util.List;

import com.project.question_service.model.QuestionPaper;

public interface QuestionPaperService {
    public QuestionPaper addQuestionPaper(QuestionPaper questionPaper);
    public QuestionPaper updateQuestionPaper(Long id,QuestionPaper questionPaper) throws Exception;
    public List<QuestionPaper> getAllQuestionPapers();
    public void deleteQuestionPaper(Long qid) throws Exception;
    public QuestionPaper getQuestionPaperById(Long quizId);

}

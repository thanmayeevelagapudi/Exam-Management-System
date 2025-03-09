package com.project.question_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.QuestionPaper;

import java.util.List;

@Repository
public interface ParentQuestionRepo extends JpaRepository<ParentQuestion,Long> {

    public List<ParentQuestion> findByQuestionPaper(QuestionPaper questionPaper);

}
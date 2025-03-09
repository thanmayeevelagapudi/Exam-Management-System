package com.project.question_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.question_service.model.QuestionPaper;

@Repository
public interface QuestionPaperRepo extends JpaRepository<QuestionPaper,Long> {
}

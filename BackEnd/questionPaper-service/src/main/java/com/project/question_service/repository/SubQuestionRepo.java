package com.project.question_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.SubQuestion;

import java.util.List;

@Repository
public interface SubQuestionRepo extends JpaRepository<SubQuestion, Long> {

    public List<SubQuestion> findByParentQuestion(ParentQuestion parentQuestion);
}

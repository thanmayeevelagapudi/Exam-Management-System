package com.project.question_service.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.SubQuestion;

import java.util.List;

public interface SubQuestionService {

   public SubQuestion addSubQuestion(SubQuestion SubQuestion) throws Exception;
   public SubQuestion updateSubQuestion(Long id, SubQuestion SubQuestion) throws Exception;
   public List<SubQuestion> getAllSubQuestions();
   public SubQuestion getSubQuestionById(Long subQId);
   public void deleteSubQuestion(Long subQId);
   public List<SubQuestion> getSubQuestionsOfParentQuestion(ParentQuestion parentQuestion);

}
 
package com.project.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.questions.model.Question;


@Repository
public interface QuestionRepo extends JpaRepository<Question,Long>{

	List<Question> findByQuizId(Long quizId);
	

}

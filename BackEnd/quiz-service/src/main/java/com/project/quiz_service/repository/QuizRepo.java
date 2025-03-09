package com.project.quiz_service.repository;



import com.project.quiz_service.Dto.categoryDto;
import com.project.quiz_service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.util.List;
 
 
public interface QuizRepo extends JpaRepository<Quiz,Long> {
 
    public List<Quiz> findByActive(Boolean active);
	public List<Quiz> findBycategoryId(long cid);
	public List<Quiz> findByCategoryIdAndActive(long cid1, boolean b);
}
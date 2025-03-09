package com.project.questions.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class QuizDto {
	
	
    private long qid;
    
    private String title;
    
    private String description;
    
    private String maxMarks;
    
    private String numberOfQuestions;
    
    private boolean active = false;
    
    private long categoryId;
    

}

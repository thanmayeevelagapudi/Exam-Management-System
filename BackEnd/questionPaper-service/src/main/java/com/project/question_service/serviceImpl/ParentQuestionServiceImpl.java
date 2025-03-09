package com.project.question_service.serviceImpl;

import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.QuestionPaper;
import com.project.question_service.repository.ParentQuestionRepo;
import com.project.question_service.repository.QuestionPaperRepo;
import com.project.question_service.service.ParentQuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentQuestionServiceImpl implements ParentQuestionService {

    @Autowired
    private ParentQuestionRepo parentQuestionRepo;
    
    @Autowired 
    private QuestionPaperRepo questionPaperRepo;

    @Override
    public ParentQuestion addQuestion(ParentQuestion parentQuestion) {
        
        if (parentQuestion.getQuestionPaper() == null || parentQuestion.getQuestionPaper().getQid() <= 0) {
            throw new IllegalArgumentException("QuestionPaper ID is required.");
        }

        
        QuestionPaper questionPaper = questionPaperRepo.findById(parentQuestion.getQuestionPaper().getQid())
                .orElseThrow(() -> new RuntimeException("QuestionPaper not found for ID: " 
                                                         + parentQuestion.getQuestionPaper().getQid()));

        
        parentQuestion.setQuestionPaper(questionPaper);

        
        return parentQuestionRepo.save(parentQuestion);
    }

    
    
    
    @Override
    public ParentQuestion updateQuestion(Long id, ParentQuestion parentQuestion) throws Exception {
      
        Optional<ParentQuestion> question1 = this.parentQuestionRepo.findById(id);

        if (question1.isPresent()) {
            ParentQuestion parentQuestion2 = question1.get();

            
            parentQuestion2.setMarks(parentQuestion.getMarks());
            parentQuestion2.setBtl(parentQuestion.getBtl());
            parentQuestion2.setCo(parentQuestion.getCo());
            parentQuestion2.setQuestionContent(parentQuestion.getQuestionContent());

            
            if (parentQuestion.getQuestionPaper() != null && parentQuestion.getQuestionPaper().getQid() > 0) {
                QuestionPaper existingQuestionPaper = questionPaperRepo.findById(parentQuestion.getQuestionPaper().getQid())
                        .orElseThrow(() -> new RuntimeException("QuestionPaper not found with ID: " + parentQuestion.getQuestionPaper().getQid()));

                
                parentQuestion2.setQuestionPaper(existingQuestionPaper);
            }

           
            return this.parentQuestionRepo.save(parentQuestion2);
        }

        throw new Exception("Question not found with ID: " + id);
    }


    @Override
    public List<ParentQuestion> getAllQuestions() {
        return this.parentQuestionRepo.findAll();
    }

    @Override
    public ParentQuestion getQuestionById(Long qId) {
        return this.parentQuestionRepo.findById(qId).get();
    }
    
    @Override
    public void deleteQuestion(Long qId) {
 
        ParentQuestion parentQuestion = parentQuestionRepo.findById(qId)
                .orElseThrow(() -> new RuntimeException("ParentQuestion not found for ID: " + qId));

        parentQuestionRepo.delete(parentQuestion);
    }

    @Override
    public List<ParentQuestion> getQuestionsOfQuestionPaper(QuestionPaper questionPaper) {
        return this.parentQuestionRepo.findByQuestionPaper(questionPaper);
    }


}

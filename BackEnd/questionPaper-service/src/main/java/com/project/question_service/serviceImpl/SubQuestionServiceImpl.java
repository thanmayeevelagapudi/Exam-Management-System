package com.project.question_service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.question_service.model.ParentQuestion;
import com.project.question_service.model.SubQuestion;
import com.project.question_service.repository.ParentQuestionRepo;
import com.project.question_service.repository.SubQuestionRepo;
import com.project.question_service.service.SubQuestionService;

import java.util.List;

@Service
public class SubQuestionServiceImpl implements SubQuestionService {

    @Autowired
    private  SubQuestionRepo SubQuestionRepository;

    @Autowired ParentQuestionRepo parentquestionrepo;
    @Override
    public SubQuestion addSubQuestion(SubQuestion SubQuestion) throws Exception {
    	ParentQuestion parentQuestion=parentquestionrepo.findById(SubQuestion.getParentQuestion().getQid()).orElse(null);
    	if(parentQuestion!=null)
    	{
    	SubQuestion.setParentQuestion(parentQuestion);	
        return SubQuestionRepository.save(SubQuestion);
        }
    	else
    		throw new Exception("parent question doesnot exists");
    }

    @Override
    public SubQuestion updateSubQuestion(Long id, SubQuestion SubQuestion) throws Exception {
        SubQuestion existingSubQuestion = SubQuestionRepository.findById(id)
                .orElseThrow(() -> new Exception("Sub question not found for id: " + id));

        existingSubQuestion.setMarks(SubQuestion.getMarks());
        existingSubQuestion.setCo(SubQuestion.getCo());
        existingSubQuestion.setBtl(SubQuestion.getBtl());
        existingSubQuestion.setQuestionContent(SubQuestion.getQuestionContent());
        return SubQuestionRepository.save(existingSubQuestion);
    }

    @Override
    public List<SubQuestion> getAllSubQuestions() {
        return SubQuestionRepository.findAll();
    }

    @Override
    public SubQuestion getSubQuestionById(Long subQId) {
        return SubQuestionRepository.findById(subQId).orElse(null);
    }

    @Override
    public void deleteSubQuestion(Long subQId) {
        SubQuestion SubQuestion=SubQuestionRepository.findById(subQId)
                .orElseThrow(() -> new RuntimeException("SubQuestion not found for ID: " + subQId));

        SubQuestionRepository.delete(SubQuestion);
    }

    @Override
    public List<SubQuestion> getSubQuestionsOfParentQuestion(ParentQuestion parentQuestion) {
        return SubQuestionRepository.findByParentQuestion(parentQuestion);
    }
}

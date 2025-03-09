package com.project.questions.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.questions.Dto.QuizDto;
import com.project.questions.model.Question;
import com.project.questions.repository.QuestionRepo;



@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
    private QuestionRepo questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id,Question question) throws Exception {
        Optional<Question> question1=this.questionRepository.findById(id);
        if(question1.isPresent()){
            Question question2=question1.get();
            question2.setImage(question.getImage());
            question2.setContent(question.getContent());
            question2.setAnswer(question.getAnswer());
            question2.setOption1(question.getOption1());
            question2.setOption2(question.getOption2());
            question2.setOption3(question.getOption3());
            question2.setOption4(question.getOption4());
            return this.questionRepository.save(question2);
        }
        throw new Exception("Question Not Found!!");
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long qId) {
        return this.questionRepository.findById(qId).get();
    }

    @Override
    public void deleteQuestion(Long qId) {
        Question question=new Question();
        question.setQid(qId);
        this.questionRepository.delete(question);

    }

    @Override
    public Question get(Long qid) {
        return this.questionRepository.getOne(qid);
    }

	@Override
	public List<Question> getQuestionsByQuizId(Long quizId) {
		
		return this.questionRepository.findByQuizId(quizId);
	}


}

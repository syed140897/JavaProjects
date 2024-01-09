package com.creativemind.Question_Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.creativemind.Question_Service.Entity.Question;
import com.creativemind.Question_Service.Model.QuestionWrapper;
import com.creativemind.Question_Service.Model.Response;
import com.creativemind.Question_Service.Repository.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo repo;

	public ResponseEntity<String> createQuestion(Question question) {	
		repo.save(question);
		return new ResponseEntity<String>("Question Created SuccessFull", HttpStatus.CREATED);
	}

	public ResponseEntity<Question> getQuestion(Integer questionId) {
		Optional<Question> quesution= repo.findById(questionId);
		return new ResponseEntity<Question>(quesution.get(),HttpStatus.OK);
	}

	public ResponseEntity<List<Question>> getAllQuestions() {
		Optional<List<Question>> listQuestion=Optional.ofNullable(repo.findAll());
		return new ResponseEntity<List<Question>>(listQuestion.get(),HttpStatus.OK);
	}

	public ResponseEntity<Integer> getResult(List<Response> response) {
		int count=0;
		for(Response result:response) {
			Question question=repo.findById(result.getQuestionId()).get();
			if(question.getCorrectAnswer().equals(result.getResponse())) {
				count++;
			}
		}
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}

	public ResponseEntity<List<Integer>> createQuiz(Integer count) {
		List<Integer> listQuestion=repo.randamQuestion(count);
		return new ResponseEntity<List<Integer>>(listQuestion,HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> questionIds) {
		List<QuestionWrapper> questionList = new ArrayList<QuestionWrapper>();
		 for(Integer id:questionIds) {
			    Optional<Question> question=repo.findById(id);
			    Question question2=question.get();
			    QuestionWrapper questionWrapper=new QuestionWrapper();
			    questionWrapper.setQuestionTitle(question2.getQuestionTitle());
			    questionWrapper.setOption1(question2.getOption1());
			    questionWrapper.setOption2(question2.getOption2());
			    questionWrapper.setOption3(question2.getOption3());
			    questionList.add(questionWrapper);	    
		}
		return new ResponseEntity<List<QuestionWrapper>>(questionList,HttpStatus.OK) ;
	}

}

package com.creativemind.Quiz_Service.Service;

import com.creativemind.Quiz_Service.Entity.Quiz;
import com.creativemind.Quiz_Service.Model.QuestionWrapper;
import com.creativemind.Quiz_Service.Model.Response;
import com.creativemind.Quiz_Service.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.creativemind.Quiz_Service.Model.QuizCreate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

	@Autowired
	private QuizRepo quizRepo;
	@Autowired
	ServerConnect serverConnect;

	public ResponseEntity<String> createQuiz(QuizCreate quizCreate) {
		List<Integer> quizList= serverConnect.createQuiz(quizCreate.getQuestionCount()).getBody();
		for(Integer x:quizList){
			System.out.println(x);
		}
		Quiz quiz=new Quiz();
		quiz.setQuizTitle(quizCreate.getQuizTitle());
		quiz.setQuestionList(quizList);
		quizRepo.save(quiz);
		return new ResponseEntity<String>("SuccessFully Created", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer quizId) {
		Quiz question=quizRepo.findById(quizId).get();
		List<Integer> questionIds=question.getQuestionList();
		List<QuestionWrapper> questionWrappers= serverConnect.getQuestionForQuiz(questionIds).getBody();
		return new ResponseEntity<List<QuestionWrapper>>(questionWrappers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> response) {
		Integer result=serverConnect.getResult(response).getBody();
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
}

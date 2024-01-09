package com.creativemind.Quiz_Service.Controller;

import com.creativemind.Quiz_Service.Model.QuestionWrapper;
import com.creativemind.Quiz_Service.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.creativemind.Quiz_Service.Model.QuizCreate;
import com.creativemind.Quiz_Service.Service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
	private QuizService service;

	@PostMapping("/createQuiz")
	public ResponseEntity<String> createQuiz(@RequestBody QuizCreate quizCreate ){
		return service.createQuiz(quizCreate);
		
	}
    @GetMapping("/getQuestion/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable("id") Integer quizId){
		return service.getQuestions(quizId);
	}
    @PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
		return service.getScore(response);
	}
}

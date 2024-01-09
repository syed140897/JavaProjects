package com.creativemind.Question_Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.creativemind.Question_Service.Entity.Question;
import com.creativemind.Question_Service.Model.QuestionWrapper;
import com.creativemind.Question_Service.Model.Response;
import com.creativemind.Question_Service.Service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService service;

	@PostMapping("/create")
	public ResponseEntity<String> createQuestion(@RequestBody Question question){
		return service.createQuestion(question);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable("id") Integer questionId){
		return service.getQuestion(questionId);
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Question>> getAllQuestions(){

		return service.getAllQuestions();
	}

	@GetMapping("/createQuiz/{count}")
	public ResponseEntity<List<Integer>> createQuiz(@PathVariable("count") Integer count){
		return service.createQuiz(count);
	}

	@GetMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionForQuiz(@RequestParam List<Integer> questionIds){
		return service.getQuestions(questionIds);
	}
	
	@PostMapping("/getResult")
	public ResponseEntity<Integer> getResult(@RequestBody List<Response> response){
		return service.getResult(response);
	}
	
	
}

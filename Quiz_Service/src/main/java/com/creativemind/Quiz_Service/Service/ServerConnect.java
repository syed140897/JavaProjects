package com.creativemind.Quiz_Service.Service;

import com.creativemind.Quiz_Service.Model.QuestionWrapper;
import com.creativemind.Quiz_Service.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVER")
public interface ServerConnect {

    @GetMapping("question/createQuiz/{count}")
    public ResponseEntity<List<Integer>> createQuiz(@PathVariable("count") Integer count);
    @GetMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionForQuiz(@RequestParam List<Integer> questionIds);

    @PostMapping("question/getResult")
    public ResponseEntity<Integer> getResult(@RequestBody List<Response> response);

}

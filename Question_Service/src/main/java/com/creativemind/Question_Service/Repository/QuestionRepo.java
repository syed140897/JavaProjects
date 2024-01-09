package com.creativemind.Question_Service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.creativemind.Question_Service.Entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

	@Query(value = "select questionId from Question ORDER BY RAND() LIMIT :count")
	List<Integer> randamQuestion(Integer count);

}

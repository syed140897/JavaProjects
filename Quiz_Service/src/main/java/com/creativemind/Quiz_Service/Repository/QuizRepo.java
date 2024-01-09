package com.creativemind.Quiz_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creativemind.Quiz_Service.Entity.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}

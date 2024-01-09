package com.creativemind.Quiz_Service.Entity;

import java.util.List;

import com.creativemind.Quiz_Service.Model.QuestionWrapper;

import jakarta.persistence.*;

@Entity
@Table
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer quizId;
	private String quizTitle;
	private List<Integer> questionList;
	
	public Quiz() {
		super();
	}

	public Quiz(Integer quizId, String quizTitle, List<Integer> questionList) {
		super();
		this.quizId = quizId;
		this.quizTitle = quizTitle;
		this.questionList = questionList;
	}
	
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public List<Integer> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Integer> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizTitle=" + quizTitle + ", questionList=" + questionList + "]";
	}
	
	
}

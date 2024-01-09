package com.creativemind.Question_Service.Model;

public class Response {

	private Integer questionId;
	private String response;
	
	
	public Response() {
		super();
	}
	
	public Response(Integer questionId, String response) {
		super();
		this.questionId = questionId;
		this.response = response;
	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Response [questionId=" + questionId + ", response=" + response + "]";
	}
	
	
}

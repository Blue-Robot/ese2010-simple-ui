package controllers;

import models.*;
import play.*;
import play.mvc.*;

import play.mvc.Controller;

import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {

	public static void addQuestion(String userId) {
		render(userId);
	}
	
	public static void saveQuestion(String questionTitle, String content, String userId) {
		User currentUser = UserList.getUserById(userId);
		currentUser.askQuestion(questionTitle, content);
		Application.index();
	}
	
	public static void addAnswer(String id, String userId) {
		render(id,userId);
	}
	
	public static void saveAnswer(String answerTitle, String content, String questionId,String userId) {
		Question answeredQuestion = QuestionList.getQuestion(questionId);
		User currentUser = UserList.getUserById(userId);
		currentUser.answerQuestion(answeredQuestion, answerTitle, content);
		Application.show(questionId,userId);
	}
	
	public static void login() {
	}
	
	public static void voteAnswerUp(String userId, String questionId, String answerId) {
		User currentUser = UserList.getUserById(userId);
		Answer currentAnswer = AnswerList.getAnswer(answerId);
		if(!currentUser.voted(currentAnswer) && !currentUser.isOwn(currentAnswer)) {
			currentUser.doVote(currentAnswer, Voting.up);
		}
		Application.show(questionId,userId);
	}
	
	public static void voteAnswerDown(String userId, String questionId, String answerId) {
		User currentUser = UserList.getUserById(userId);
		Answer currentAnswer = AnswerList.getAnswer(answerId);
		if(!currentUser.voted(currentAnswer) && !currentUser.isOwn(currentAnswer)) {
			currentUser.doVote(currentAnswer, Voting.down);
		}
		Application.show(questionId,userId);
	}
	
	public static void voteQuestionUp(String userId, String questionId) {
		User currentUser = UserList.getUserById(userId);
		Question currentQuestion = QuestionList.getQuestion(questionId);
		if(!currentUser.voted(currentQuestion) && !currentUser.isOwn(currentQuestion)) {
			currentUser.doVote(currentQuestion, Voting.up);
		}
		Application.show(questionId,userId);
	}
	
	public static void voteQuestionDown(String userId, String questionId) {
		User currentUser = UserList.getUserById(userId);
		Question currentQuestion = QuestionList.getQuestion(questionId);
		if(!currentUser.voted(currentQuestion) && !currentUser.isOwn(currentQuestion)) {
			currentUser.doVote(currentQuestion, Voting.down);
		}
		Application.show(questionId,userId);
	}
}
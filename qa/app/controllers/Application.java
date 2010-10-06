package controllers;

import java.util.ArrayList;
import java.util.List;

import models.*;
import play.*;
import play.mvc.*;

import play.mvc.Controller;

import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;


public class Application extends Controller {
	
	
    public static void index() {
    	ArrayList<Question> questions = QuestionList.getAllQuestions();
    	User user = UserList.getUserByName(Security.connected());
    	String userId = "-1";
    	if( user != null) {
    		userId = user.getId();
    	}
    	String userName = Security.connected();
        render(questions, userId, userName);
    }
    
   
    public static void show(String id, String userId) {
    	Question question = QuestionList.getQuestion(id);
    	String userName = Security.connected();
        render(question, userName, userId);
    }
    
    public static void logout() throws Throwable{
		Secure.logout();
		index();
	}
}
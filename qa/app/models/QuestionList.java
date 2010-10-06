package models;

import java.util.ArrayList;

public class QuestionList {
	
	private static ArrayList<Question> allQuestions = new ArrayList<Question>();
	
	public QuestionList() {
		
	}
	
	public static int count() {
		return allQuestions.size();
	}
	public static void add(Question newQuestion) {
		allQuestions.add(newQuestion);
	}
	
	public static void remove(Question oldQuestion) {
		allQuestions.remove(oldQuestion);
	}
	
	public static Question getQuestion(String id) {
		Question result = null;
		for (Question question : allQuestions) {
			if (question.getId().equals(id)) {
				result = question;
			}
		}
		if (result == null)
			throw new Error();
		return result;
	}
	
	public static ArrayList<Question> getAllQuestions() {
		return allQuestions;
	}

	

	
}

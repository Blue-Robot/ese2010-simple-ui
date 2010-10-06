package models;

import java.util.ArrayList;

public class AnswerList {
	
	private static ArrayList<Answer> allAnswers = new ArrayList<Answer>();
	
	public AnswerList() {
		
	}
	
	public static int count() {
		return allAnswers.size();
	}
	public static void add(Answer newAnswer) {
		allAnswers.add(newAnswer);
	}
	
	public static void remove(Answer oldAnswer) {
		allAnswers.remove(oldAnswer);
	}
	
	public static Answer getAnswer(String id) {
		Answer result = null;
		for (Answer answer : allAnswers) {
			if (answer.getId().equals(id)) {
				result = answer;
			}
		}
		if (result == null)
			throw new Error();
		return result;
	}
	
	public static ArrayList<Answer> getAllAnswers() {
		return allAnswers;
	}

	

	
}

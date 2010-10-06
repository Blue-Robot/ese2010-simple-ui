package models;
import java.util.ArrayList;
import java.util.List;

public class Question extends Poste {
	
	private ArrayList<Answer> answers;
	private String id;
	
	public Question(User owner, String title, String content){
		super(owner, title, content);
		this.answers = new ArrayList<Answer>();
		this.setId(Integer.toString(QuestionList.count()));
		QuestionList.add(this);
	}

	public void delete() {
		while (!votes.isEmpty()) {
			Vote deletedVote = votes.get(0);
			deletedVote.delete();
		}
		while (!answers.isEmpty()) {
			Answer deletedAnswer = answers.get(0);
			deletedAnswer.delete();
		}
		getAuthor().removeQuestion(this);
		setAuthor(null);
		QuestionList.remove(this);
	}
	
	public void addAnswer(Answer newAnswer) {
		this.answers.add(newAnswer);
	}
	
	public boolean removeAnswer(Answer oldAnswer) {
		return answers.remove(oldAnswer);
	}
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}

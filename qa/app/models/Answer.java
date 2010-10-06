package models;

public class Answer extends Poste{
	
	private String id;
	private Question question;
	
	public Answer(User owner, String title, String content, Question question) {
		super(owner, title, content);
		this.question = question;
		this.setId(Integer.toString(AnswerList.count()));
		AnswerList.add(this);
	}
	
	public void delete() {
		while(!votes.isEmpty()) {
			Vote deletedVote = votes.get(0);
			deletedVote.delete();
		}
		question.removeAnswer(this);
		setQuestion(null);
		getAuthor().removeAnswer(this);
		setAuthor(null);
		AnswerList.remove(this);
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void setQuestion(Question newQuestion) {
		this.question = newQuestion;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}

package models;
import java.util.ArrayList;


public class User {
	
	private String name;
	
	//corr: Why not make the id an integer? you could get rid of the whole casting,
	//		and still have a clear identifier! same in  Question and Answer
	private String id;
	private ArrayList<Question> questions;
	private ArrayList<Answer> answers;
	private ArrayList<Vote> votes;
	
	public User(String name) {
		this.name = name;
		this.setId(Integer.toString(UserList.count()));
		this.questions = new ArrayList<Question>();
		this.answers = new ArrayList<Answer>();
		this.votes = new ArrayList<Vote>();
		UserList.add(this);
		
		/* corr: You shouldn't use assertions for those kinds of checks.
		 		it's possible that assertions aren't enabled which makes 
				this check rather useless and would allow the user to not use
				a username. And even if assertions are enabled you can't give 
				any feedback about what happened because it's an error that's
				thrown and not an exception. So rather throw an exception that
				you then handle somewhere or just check whether the username
				is empty and give the user feedback that the username can't be
				empty.
		*/
		assert !this.name.equals("");
	}
	
	public Vote doVote(Poste votedPoste, Voting voting) {
		Vote newVote = votedPoste.newVote(this, voting);
		votes.add(newVote);
		return newVote;
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
		while (!questions.isEmpty()) {
			Question deletedQuestion = questions.remove(0);
			deletedQuestion.delete();
		}
		UserList.remove(this);
	}
	
	public Question askQuestion(String title, String content) {
		Question newQuestion = new Question(this, title, content);
		this.addQuestion(newQuestion);
		return newQuestion;
	}
	
	public Answer answerQuestion(Question answeredQuestion,String title, String content) {
		Answer newAnswer = new Answer(this, title, content, answeredQuestion);
		answeredQuestion.addAnswer(newAnswer);
		this.addAnswer(newAnswer);
		return newAnswer;
	}
	
	public boolean voted(Poste currentPoste) {
		boolean alreadyVoted = false;
		for (Vote vote : votes) {
			if (vote.getPoste().equals(currentPoste))
				alreadyVoted = true;
		}
		return alreadyVoted;
	}
	
	public boolean isOwn(Poste currentPoste) {
		boolean isOwnPoste = false;
		for (Question question : questions) {
			if (question.equals(currentPoste))
				isOwnPoste = true;
		}
		for (Answer answer : answers) {
			if (answer.equals(currentPoste))
				isOwnPoste = true;
		}
		return isOwnPoste;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addQuestion(Question newQuestion) {
		questions.add(newQuestion);
	}
	
	public boolean removeQuestion(Question oldQuestion) {
		return questions.remove(oldQuestion);
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public void addAnswer(Answer newAnswer) {
		answers.add(newAnswer);
	}
	
	public boolean removeAnswer(Answer oldAnswer) {
		return answers.remove(oldAnswer);
	}
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	
	public ArrayList<Vote> getVotes() {
		return votes;
	}
	
	public boolean removeVote(Vote oldVote) {
		return votes.remove(oldVote);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}

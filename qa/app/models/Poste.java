package models;
import java.util.ArrayList;
import java.util.Date;

public class Poste {

	protected User author;
	protected String title;
	protected String content;
	protected Date timestamp;
	protected ArrayList<Vote> votes;

	public Poste(User author, String title, String content) {
		this.setAuthor(author);
		this.setTitle(title);
		this.setContent(content);
		this.setTimestamp(new Date());
		this.votes = new ArrayList<Vote>();
	}

	public Vote newVote(User voter, Voting voting) {
		Vote vote = new Vote(voter, this, voting);
		this.addVote(vote);
		return vote;
	}
	
	public void addVote(Vote newVote) {
		votes.add(newVote);
	}

	public boolean removeVote(Vote oldVote) {
		return votes.remove(oldVote);
	}
	
	public ArrayList<Vote> getVotes() {
		return votes;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public int getVoteUp(){
		int count = 0;
		for(Vote vote : votes) {
			if (vote.getVoting().equals(Voting.up))
					count++;
		}
		return count;
	}
	
	public int getVoteDown(){
		int count = 0;
		for(Vote vote : votes) {
			if (vote.getVoting().equals(Voting.down))
					count++;
		}
		return count;
	}
}
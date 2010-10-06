package models;

public class Vote {
	
	private User owner;
	private Poste poste;
	private Voting voting;
	
	public Vote(User owner, Poste poste, Voting voting) {
		this.owner = owner;
		this.poste = poste;
		this.voting = voting;
	}
	public void delete() {
		owner.removeVote(this);
		setOwner(null);
		poste.removeVote(this);
		setPoste(null);
	}
	
	public User getOwner() {
		return this.owner;
	}
	
	public void setOwner(User newOwner) {
		this.owner = newOwner;
	}
	
	public Poste getPoste() {
		return this.poste;
	}
	
	public void setPoste(Poste newPoste) {
		this.poste = newPoste;
	}
	
	public void setVoting(Voting voting) {
		this.voting = voting;
	}

	public Voting getVoting() {
		return this.voting;
	}

}

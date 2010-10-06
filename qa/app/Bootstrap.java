import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
	
    public void doJob() {
    	User bob = new User("Bob");
    	User jeff = new User("Jeff");
    	User troy = new User("Troy");
    	User trish = new User("Trish");
    	Question bobFirstQuestion = bob.askQuestion("Bob's first question", "I got a problem");
    	Question jeffQuestion = jeff.askQuestion("Jeff's question", "I got a problem too");
    	Question bobSecondQuestion = bob.askQuestion("Bob's second question", "I got another problem");
    	Answer jeffAnswer = jeff.answerQuestion(bobFirstQuestion, "Jeff's Answer", "I got an answer");
    	Answer troyAnswer = troy.answerQuestion(jeffQuestion, "Troy's Answer", "I got an answer too");
    	Answer bobThanks = bob.answerQuestion(bobFirstQuestion, "Thanks", "Thanks a lot Jeff");
    	Answer jeffSecondAnswer = jeff.answerQuestion(bobFirstQuestion, "NP", "No problem");
    	jeff.doVote(bobFirstQuestion, Voting.up);
    	bob.doVote(jeffAnswer, Voting.up);
    	troy.doVote(jeffAnswer, Voting.up);
    	trish.doVote(jeffAnswer, Voting.up);
    	jeff.doVote(bobThanks, Voting.up);
    	bob.doVote(jeffQuestion, Voting.up);
    	trish.doVote(jeffQuestion, Voting.down);
    	jeff.doVote(bobSecondQuestion, Voting.down);
    	troy.doVote(bobSecondQuestion, Voting.down);
    	trish.doVote(bobSecondQuestion, Voting.down);
    	
    }
 
}

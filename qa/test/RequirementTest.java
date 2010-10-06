import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import models.*
;public class RequirementTest {
	private User joe;
	private User antiJoe;
	private Question question;
	private Answer answer;
	private Vote vote;
	
	@Before
	public void setUp() {
		joe = new User("joe");
		antiJoe = new User("antijoe");
		question = joe.askQuestion("First Question", "Got a question");
		answer = antiJoe.answerQuestion(question, "First Answer", "Got a answer");
		vote = joe.doVote(answer, Voting.up);
		
	}
	
	@Test
	public void shouldHaveName() {
		assertEquals(joe.getName(),"joe");
	}
	
	@Test(expected=AssertionError.class)
	public void shouldNotBeAllowed() {
		new User("");
	}
	
	@Test
	public void shouldBelongToUser() {
		assertEquals(question.getAuthor(),joe);
	}
	
	@Test
	public void shouldBelongToUserAndQuestion() {
		assertEquals(answer.getAuthor(),antiJoe);
		assertEquals(answer.getQuestion(), question);
	}
	
	@Test
	public void shouldHaveTimestamp() {
		assertFalse(question.getTimestamp().equals(null));
		assertFalse(answer.getTimestamp().equals(null));
	}
	
	@Test
	public void shouldHaveContent() {
		assertFalse(question.getContent().equals(""));
		assertFalse(answer.getContent().equals(""));
	}
	
	@Test
	public void shouldVote() {
		assertEquals(vote.getOwner(),joe);
	}
	
	public void shouldBeDeleted() {
		antiJoe.delete();
		assertEquals(null, answer.getAuthor());
		assertTrue(antiJoe.getAnswers().isEmpty());
		assertEquals(null, vote.getOwner());
		assertTrue(joe.getVotes().isEmpty());
		
	}
}

package gpes.test.steps;

import gpes.model.*;

import org.jbehave.Ensure;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

import static org.easymock.EasyMock.*;

public class GameLogicSteps extends Steps {
	String playerName1;
	String playerName2;
	ThrowableHand throw1;
	ThrowableHand throw2;
	ThrowableHand winner;
	GameLogic gameLogic = new GameLogic();
	
	private ThrowableHand getThrowableHand(String throwHand) {
		if (throwHand.equals("rock")) {
			return new Rock();
		}
		else if (throwHand.equals("paper")) {
			return new Paper();
		} 
		else if (throwHand.equals("scissors")) {
			return new Scissors();
		}
		else if (throwHand.equals("lizard")) {
			return new Lizard();
		}
		else if (throwHand.equals("spock")) {
			return new Spock();
		}
		return null;
	}
	
	@Given("$playerName1 and $playerName2 start playing")
	public void setUpPlayers(String playerName1, String playerName2) {
		/* Não consegui passar o nome na criação do mock do Player, 
		 * por isso utilizei strings para diferenciar os jogadores
		 */
		this.playerName1 = playerName1;
		this.playerName2 = playerName2;
	}
	
	@When("$playerName throws $throwHand")
	public void playerThrowHand(String playerName, String throwHand) {		
		Thrower player = createMock(Thrower.class);
		expect(player.throwHand())
			.andReturn(getThrowableHand(throwHand));
		replay(player);
		if (playerName.equals(playerName1)) {
			throw1 = player.throwHand();
		}
		else {
			throw2 = player.throwHand();
		}
	}
	
	@Then("$throwHand1 beats $throwHand2")
	public void getWinnerMessage(String throwHand1, String throwHand2) {
		winner = gameLogic.getWinner(throw1, throw2);
		Ensure.ensureThat(throw1.getClass() == winner.getClass());
	}
}

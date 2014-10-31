package gpes.test;

import static org.junit.Assert.*;
import gpes.model.*;

import org.junit.Before;
import org.junit.Test;

public class GameLogicTest {
	private GameLogic gameLogic;
	private ThrowableHand throw1;
	private ThrowableHand throw2;

	@Before
	public void setUp() throws Exception {
		gameLogic = new GameLogic();
	}
	
	@Test
	public void rockCrushesLizard() {
		throw1 = new Rock();
		throw2 = new Lizard();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void lizardPoisonsSpock() {
		throw1 = new Lizard();
		throw2 = new Spock();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void spockSmashesScissors() {
		throw1 = new Spock();
		throw2 = new Scissors();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void scissorsCutsPaper() {
		throw1 = new Scissors();
		throw2 = new Paper();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void paperCoversRock() {
		throw1 = new Paper();
		throw2 = new Rock();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void rockCrushesScissors() {
		throw1 = new Rock();
		throw2 = new Scissors();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void lizardEatsPaper() {
		throw1 = new Lizard();
		throw2 = new Paper();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void spockVaporizesRock() {
		throw1 = new Spock();
		throw2 = new Rock();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void scissorsDecapicatesLizard() {
		throw1 = new Scissors();
		throw2 = new Lizard();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void paperDisprovesSpock() {
		throw1 = new Paper();
		throw2 = new Spock();		
		assertEquals(throw1, gameLogic.getWinner(throw1, throw2));
		assertEquals(throw1, gameLogic.getWinner(throw2, throw1));
	}
	
	@Test
	public void gameIsTied() {
		throw1 = new Rock();
		throw2 = new Rock();
		assertEquals(Tie.class, gameLogic.getWinner(throw1, throw2).getClass());
		assertEquals(Tie.class, gameLogic.getWinner(throw2, throw1).getClass());
	}

}

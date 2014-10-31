package gpes.model;

import java.util.Random;

public class Player implements Thrower {
	
	String name;
	
	public Player(String playerName) {
		name = playerName;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public ThrowableHand throwHand() {
		Random gen = new Random();
    	int choice = gen.nextInt(5);
    	switch (choice) {
    		case 0: return new Rock();
    		case 1: return new Paper();
    		case 2: return new Scissors();
    		case 3: return new Lizard();
    		case 4: return new Spock();
    	}
		return null;
	}

}

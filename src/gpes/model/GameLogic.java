package gpes.model;

public class GameLogic {

	public ThrowableHand getWinner(ThrowableHand throw1, ThrowableHand throw2) {
		if (throw1.getClass() == throw2.getClass()) {
			return new Tie();
		}
		else {
			if (throw1.getClass() == Rock.class) {
				if (throw2.getClass() == Scissors.class || throw2.getClass() == Lizard.class) {
					return throw1;
				}
			}
			else if (throw1.getClass() == Lizard.class) {
				if (throw2.getClass() == Paper.class || throw2.getClass() == Spock.class) {
					return throw1;
				}
			}
			else if (throw1.getClass() == Spock.class) {
				if (throw2.getClass() == Scissors.class || throw2.getClass() == Rock.class) {
					return throw1;
				}
			}
			else if (throw1.getClass() == Scissors.class) {
				if (throw2.getClass() == Lizard.class || throw2.getClass() == Paper.class) {
					return throw1;
				}
			}
			else if (throw1.getClass() == Paper.class) {
				if (throw2.getClass() == Spock.class || throw2.getClass() == Rock.class) {
					return throw1;
				}
			}
		}
		return throw2;
	}
	
	public String getGameResult(Player player1, Player player2) {
		String result = "";
		ThrowableHand throw1 = player1.throwHand();
		result += player1.getName() + " throws " + throw1.toString() + "\n";
		ThrowableHand throw2 = player2.throwHand();
		result += player2.getName() + " throws " + throw2.toString() + "\n";
		ThrowableHand winner = getWinner(throw1, throw2);
		if (winner.getClass() == Tie.class) {
			result += "Game ends tied";
		}
		else {
			if (winner.getClass() == throw1.getClass()) {
				result += throw1.toString() + " beats " + throw2.toString(); 
			}
			else {
				result += throw2.toString() + " beats " + throw1.toString();
			}
		}
		return result + "\n";
	}

}

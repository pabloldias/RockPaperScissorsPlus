package gpes.model;

public class Game {
	
	public static void main(String[] args) {
		GameLogic gameLogic = new GameLogic();
		Player player1 = new Player("Leonard");
		Player player2 = new Player("Sheldon");
		for (int i = 1; i <= 10; i++) {
			System.out.println("Game " + i);
			System.out.println(gameLogic.getGameResult(player1, player2));
		}
	}

}

package Game;

import java.util.Scanner;

import Interfaces.IGame;

public class Main {

	public static void main(String[] args) throws Exception {
		IGame game = new Game();
		Scanner sc = new Scanner(System.in);
		boolean start = true;
		char c;
		while(true) {
			String team1;
			String team2;
			System.out.println("Enter team one name :");
			team1 = sc.next().toString();
			System.out.println("Enter team two name :");
			team2 = sc.next().toString();
			game.startGame(team1, team2);
			start = false;
			while(start == false) {				
				System.out.println("press B to print current score");
				System.out.println("press C to prediction stats");
				System.out.println("press D print a table of scores of all finished games");
				System.out.println("press P to pause game");
				System.out.println("press S to start game\n\n\n\n");
				c = sc.next().charAt(0);
				System.out.println(c);
				if (c == 'b') {
					System.out.println(game.printCurrentScore());
				} else if (c == 'c') {
					game.printPrediction();
				} else if (c == 'd') {
					game.printTableOfScores();
				} else if (c == 'p') {
					game.pauseGame();
				}else if( c == 's')
				{
					start = true;
				}
			}
		}
	}
}
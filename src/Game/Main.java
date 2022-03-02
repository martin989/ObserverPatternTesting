package Game;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

import Interfaces.IGame;

public class Main {

	public static void main(String[] args) throws Exception {

		  Scanner scanner = new Scanner(new InputStreamReader(System.in));

		IGame game = new Game();
		boolean start = true;
		while (true) {
			System.out.println("Enter team one name :");
			String team1 = scanner.nextLine();
			System.out.println("Enter team two name :");
			String team2 = scanner.nextLine();
			System.out.println("Enter location :");
			String location = scanner.nextLine();

			System.out.println("\n\n");

			game.startGame(team1, team2, location);
			start = false;
			while (start == false) {
				printOptions();
				int c = scanner.nextInt();
				if (c == 1) {
					System.out.println(game.printCurrentScore());
				} else if (c == 2) {
					System.out.println(game.printPrediction());
				} else if (c == 3) {
					game.printTableOfScores();
				} else if (c == 4) {
					game.pauseGame();
				} else if (c == 5) {
					start = true;
				}
			}
		}
	}

	public static void printOptions() {
		System.out.println("\n\n\n");
		System.out.println("press 1 to print current score");
		System.out.println("press 2 to prediction stats");
		System.out.println("press 3 print a table of scores of all finished games");
		System.out.println("press 4 to pause game");
		System.out.println("press 5 to start game\n\n\n\n");
	}
}
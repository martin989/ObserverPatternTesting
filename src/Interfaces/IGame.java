package Interfaces;

import Events.Exception;

public interface IGame {
	public void startGame(String teamOne, String teamTwo, String location);
	public void startGame() throws Exception;
	public void pauseGame();
	public String printCurrentScore();
	public void printTableOfScores();
	public String printPrediction();
}

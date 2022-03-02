package Interfaces;

public interface IGame {
	public void startGame(String teamOne, String teamTwo);
	public void pauseGame();
	public String printCurrentScore();
	public String printTableOfScores();
	public String printPrediction();
	public boolean gameStatus();
}

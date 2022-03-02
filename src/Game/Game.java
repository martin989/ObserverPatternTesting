package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import Interfaces.IGame;
import Observers.ObserverA;
import Observers.ObserverB;
import Observers.ObserverC;

public class Game implements IGame {
	private static final int QuarterLength = 100;
	private int timerCounter;
	private Timer timer4thQuarterUpdate;
	private Timer scoringTimer;
	private List<Integer> pointsList = Arrays.asList(2, 3);
	private List<Integer> teamsList = Arrays.asList(1, 2);
	Scoring scoring;
	ObserverA observerA;
	ObserverB observerB;
	ObserverC observerC;
	private String teamOneName;
	private String teamTwoName;
	private boolean gamePlaying;
	
	public Game() throws Exception {
		gamePlaying = false;
		observerA = new ObserverA();
		observerB = new ObserverB();
		observerC = new ObserverC();

		scoring = new Scoring();
		scoring.registerObserver(observerA);
		scoring.registerObserver(observerB);
		scoring.registerObserver(observerC);
		
		try {
			this.timer4thQuarterUpdate = new Timer(QuarterLength, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					timerCounter = timerCounter + 1;
					System.out.println("Quarter Ended");
					scoring.dataChanged();
					if (timerCounter % 4 == 0) {
						System.out.println("Game Ended");
						pauseGame();
						gamePlaying = false;
					}
				}
			});

			this.scoringTimer = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					Random rand = new Random();
					int points = pointsList.get(rand.nextInt(pointsList.size()));
					int team = teamsList.get(rand.nextInt(teamsList.size()));
					try {
						if (team == 1) {
							scoring.teamScored(teamOneName, timer4thQuarterUpdate.getDelay(), points);
						} else {
							scoring.teamScored(teamTwoName, timer4thQuarterUpdate.getDelay(), points);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			throw new Exception("Timer exception error");
		}
	}

	@Override
	public void startGame(String teamOne, String teamTwo) {
		this.teamOneName = teamOne;
		this.teamTwoName = teamTwo;
		scoring.setTeamNames(teamOne, teamTwo);
		timer4thQuarterUpdate.start();
		scoringTimer.start();
	}

	@Override
	public void pauseGame() {
		timer4thQuarterUpdate.stop();
		scoringTimer.stop();
	}

	@Override
	public String printCurrentScore() {
		return scoring.currentScoreToString();
	}

	@Override
	public String printTableOfScores() {
		return null;
	}

	@Override
	public String printPrediction() {
		return observerA.getPredication();
	}

	@Override
	public boolean gameStatus() {
		return gamePlaying;
	}
	
}

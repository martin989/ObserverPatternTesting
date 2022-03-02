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
	private static final int QuarterLength = 10;
	Scoring scoring;
	ObserverA observerA;
	ObserverB observerB;
	ObserverC observerC;
	private String teamOneName;
	private String teamTwoName;
	private String location;
	private Timer timer4thQuarterUpdate;
	private Timer scoringTimer;
	private int timerCounter;
	
	public Game() throws Exception {
		observerA = new ObserverA();
		observerB = new ObserverB();
		observerC = new ObserverC();
		scoring = new Scoring();
		scoring.registerObserver(observerA);
		scoring.registerObserver(observerB);
		scoring.registerObserver(observerC);
		
		simulateGame();
	}


	@Override
	public void startGame() throws Events.Exception {
		if((this.teamOneName != null) && (this.teamTwoName != null) && (this.location != null)) {
			timer4thQuarterUpdate.start();
			scoringTimer.start();
		}else {
			throw new Events.Exception("Teams and/or locaiton is not selected");
		}
	}
	
	@Override
	public void startGame(String teamOne, String teamTwo, String location) {
		this.teamOneName = teamOne;
		this.teamTwoName = teamTwo;
		this.location = location;
		scoring.setScoringData(teamOneName, teamTwoName, location);
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
	public void printTableOfScores() {
		observerB.displayEventHistory();
	}

	@Override
	public String printPrediction() {
		return observerA.getPredication();
	}

	public void simulateGame() throws Exception {
		try {
			this.timer4thQuarterUpdate = new Timer(QuarterLength, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					timerCounter = timerCounter + 1;
					System.out.println("Quarter Ended");
					scoring.dataChanged();
					if (timerCounter % 4 == 0) {
						System.out.println("Game Ended");
						pauseGame();
						scoring.gameEnd();
					}
				}
			});

			this.scoringTimer = new Timer(1, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					List<Integer> pointsList = Arrays.asList(2, 3);
					List<Integer> teamsList = Arrays.asList(1, 2);
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
	
}

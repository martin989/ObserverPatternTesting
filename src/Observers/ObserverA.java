package Observers;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IObserver;
import Objects.Point;

public class ObserverA implements IObserver{
    private String predication;
    private int teamOneScoreCount;
    private int teamTwoScoreCount;
    
   
	public String getPredication() {
		return predication;
	}

	@Override
	public void gameEnded(ArrayList<Point> points, String teamOneName, String teamTwoName, int teamOneScore,
			int teamTwoScore,String location) {

	}

	@Override
	public void update(List<Point> points, String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore) {
    	System.out.println("\nObserver A");
		for (Point p : points) {
    		if(teamOneName == p.getTeam()) {
    			teamOneScoreCount = teamOneScoreCount + 1;
    		}else {
    			teamTwoScoreCount = teamTwoScoreCount + 1;
    		}
    	}
    	
    	if((teamOneScoreCount > teamTwoScoreCount) && (teamOneScore > teamTwoScore)) {
    		predication = "Team " + teamOneName + " will win over " + teamTwoName;
    	}else {
    		predication = "Team " + teamTwoName + " will win over " + teamOneName;
    	}
    	System.out.println(predication);
    	System.out.println("Observer A\n");
	}
}

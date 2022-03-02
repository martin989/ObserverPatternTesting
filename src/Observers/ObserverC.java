package Observers;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IObserver;
import Objects.Point;

public class ObserverC implements IObserver {   
    public void update(List<Point> points, String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore)
    {
    	System.out.println("\nObserver C");
    	if(teamOneScore > teamTwoScore) {
    		System.out.println("Team " + teamOneName + " is winning over " + teamTwoName + " by " + (teamOneScore - teamTwoScore));
    	}else {
    		System.out.println("Team " + teamTwoName + " is winning over " + teamOneName + " by " + (teamTwoScore - teamOneScore));
    	}
    	System.out.println("Observer C\n");
    }

	@Override
	public void gameEnded(ArrayList<Point> points, String teamOneName, String teamTwoName, int teamOneScore,
			int teamTwoScore) {
    	System.out.println("\\nObserver C");
    	if(teamOneScore > teamTwoScore) {
    		System.out.println("Team " + teamOneName + " won over " + teamTwoName + " by " + (teamOneScore - teamTwoScore));
    	}else {
    		System.out.println("Team " + teamTwoName + " won over " + teamOneName + " by " + (teamTwoScore - teamOneScore));
    	}
    	System.out.println("Observer C\n");
	}
}

package Observers;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IObserver;
import Objects.Event;
import Objects.Point;

public class ObserverB implements IObserver{
	
	ArrayList<Event> events;;
   
    public void update(List<Point> points, String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore)
    {
        
    }

	@Override
	public void gameEnded(ArrayList<Point> points, String teamOneName, String teamTwoName, int teamOneScore,
			int teamTwoScore) {
		Event event;
		if(teamOneScore == teamTwoScore) {
			event = new Event("AddLocation", teamOneName, points);
		}else {
			event = new Event("AddLocation", teamTwoName, points);
		}
		events.add(event);
	}

}

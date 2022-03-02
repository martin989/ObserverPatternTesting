package Observers;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IObserver;
import Objects.Event;
import Objects.Point;

public class ObserverB implements IObserver{
	
	ArrayList<Event> events = new ArrayList<Event>();
   
    public void update(List<Point> points, String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore)
    {     }

	@Override
	public void gameEnded(ArrayList<Point> points, String teamOneName, String teamTwoName, int teamOneScore,
			int teamTwoScore,String location) {		
		Event event;
		if(teamOneScore >= teamTwoScore) {
			event = new Event(location, teamOneName, points);
		}else {
			event = new Event(location, teamTwoName, points);
		}
		events.add(event);

		displayEventHistory();
		
	}
	
	public void displayEventHistory() {
	    System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%10s %30s", "Game Location", "Winning Team");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
	    for(Event evt: events){
	        System.out.format("%10s %30s", evt.getLocation(), evt.getTeamWon());
	        System.out.println();
	    }
	    System.out.println("");
	}

}

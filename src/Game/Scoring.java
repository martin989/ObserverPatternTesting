package Game;

import java.util.ArrayList;
import java.util.Iterator;

import Interfaces.IObserver;
import Interfaces.Subject;
import Objects.Point;

public class Scoring implements Subject
{
	ArrayList<IObserver> observerList;
	ArrayList<Point> points;
	private int teamOneScore = 0;
	private int teamTwoScore = 0;
	private String teamOneName;
	private String teamTwoName;	
	private String location;
	
    public Scoring() {
        observerList = new ArrayList<IObserver>();
        points = new ArrayList<Point>();
    }
    
    public void dataChanged()
    {
        notifyObservers();
    }
    
    public void gameEnd() {
        for (Iterator<IObserver> it = observerList.iterator(); it.hasNext();)
          {
        	IObserver o = it.next();
        	o.gameEnded(points,teamOneName,teamTwoName,teamOneScore,teamTwoScore,location);
          }         
    }
    
    public void teamScored(String team, int time, int points) throws Exception {
    	Point point = new Point(team, time, points);
    	this.points.add(point);
    	if(team == teamOneName) {
    		teamOneScore = teamOneScore + points;
    	}
    	else {
    		teamTwoScore = teamTwoScore + points;
    	}
    }

	public String currentScoreToString() {
		return "\n\n" + teamOneName + " has " + teamOneScore + " and " + teamTwoName + " has " + teamTwoScore + "\n\n";
	}
	
	public void setScoringData(String teamOneName, String teamTwoName, String location) {
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.location = location;
	}
	
	//Implemented Methods
    @Override
    public void registerObserver(IObserver o) {
        observerList.add(o);
    }
  
    @Override
    public void unregisterObserver(IObserver o) {
        observerList.remove(observerList.indexOf(o));
    }
  
    @Override
    public void notifyObservers()
    {
        for (Iterator<IObserver> it =
              observerList.iterator(); it.hasNext();)
        {
            IObserver o = it.next();        
            o.update(points,teamOneName,teamTwoName,teamOneScore,teamTwoScore);
        }
    }
}

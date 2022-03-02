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
	private int teamOneScore;
	private int teamTwoScore;
	private String teamOneName;
	private String teamTwoName;	
	
    public Scoring() {
        observerList = new ArrayList<IObserver>();
        points = new ArrayList<Point>();
        teamOneScore = 0;
        teamTwoScore = 0;
    }
    
    
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
    
    public void dataChanged()
    {
        notifyObservers();
    }
    
    public void gameEnd() {
        for (Iterator<IObserver> it = observerList.iterator(); it.hasNext();)
          {
        	IObserver o = it.next();
        	o.gameEnded(points,teamOneName,teamTwoName,teamOneScore,teamTwoScore);
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

    
	public void setTeamNames(String teamOneName, String teamTwoName) {
		this.teamOneName = teamOneName;
		this.teamTwoName = teamTwoName; 
	}
	
	public String currentScoreToString() {
		return "\n\n" + teamOneName + " has " + teamOneScore + " and " + teamTwoName + " has " + teamTwoScore + "\n\n";
	}
}

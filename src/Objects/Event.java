package Objects;

import java.util.List;

public class Event {

	private String location;
	private String teamWon;
	private List<Point> points;
	
	public Event(String location, String teamWon, List<Point> points)
	{
		this.location = location;
		this.teamWon = teamWon;
		this.points = points;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeamWon() {
		return teamWon;
	}
	public void setTeamWon(String teamWon) {
		this.teamWon = teamWon;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
}

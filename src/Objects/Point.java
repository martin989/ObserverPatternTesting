package Objects;

public class Point {
	private int time;
	private int points;
	private String team;

	public Point(String team, int time, int points) {
		this.time = time;
		this.points = points;
		this.team = team;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	
}

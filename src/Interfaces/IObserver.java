package Interfaces;

import java.util.ArrayList;
import java.util.List;

import Objects.Point;

public interface IObserver {
	public void update(List<Point> points, String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore);

	public void gameEnded(ArrayList<Point> points, String teamOneName, String teamTwoName, int teamOneScore,
			int teamTwoScore);
}

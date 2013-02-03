package search.impl.tour;

import search.GoalTest;
import search.State;


public class TourGoalTest implements GoalTest {

	private Cities _citiesInRomania;
	private City _startingCity;

	public TourGoalTest(Cities citiesInRomania, City startingCity) {
		this._citiesInRomania = citiesInRomania;
		this._startingCity = startingCity;
	}
	
	@Override
	public boolean isGoalState(State state) {
		if(! (state instanceof TourState))
			throw new IllegalArgumentException();
				
		return 
				((TourState) state).citiesVisited().containsAll(_citiesInRomania.getAllCities())
				&& ((TourState) state ).getCurrentCity().equals(_startingCity);
	}
	
}

package search.impl.tour;

import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements State {

	private Set<City> _otherCitiesVisited;
	private City _currentCity;
	
	public TourState(City startingCity) {
		_otherCitiesVisited = new LinkedHashSet<City>();
		_currentCity = startingCity;
	}
	
	protected TourState(Set<City> citiesVisited, City currentCity) {
		this._otherCitiesVisited = citiesVisited;
		this._currentCity = currentCity;
	}

	public Set<City> citiesVisited () {
		return _otherCitiesVisited;
	}
	
	@Override
	public Set<Action> getPossibleActions() {
		Set<Action> possibleActions = new LinkedHashSet<Action>();
		
		for(Road road : _currentCity.outgoingRoads) {
				possibleActions.add(road);
		}
		
		return possibleActions;
	}

	@Override
	public State getActionResult(Action action) {
		//assuming these actions come from getPossibleActions(),
		//I have already checked the necessary conditions on the
		//source and target cities, and it is safe to cast to a road.
		Road road = (Road) action;
		//I will have to clone the set, since there is no concept of
		//an immutable set in java.
		Set<City> clone = new LinkedHashSet<City>();
		for(City city : _otherCitiesVisited) {
			clone.add(city);
		}
		clone.add(_currentCity);
		return new TourState(clone, road.targetCity);
	}

	public City getCurrentCity() {
		return _currentCity;
	}

	public boolean equals(Object other) {
		if(!(other instanceof TourState)) {
			return false;
		}
		Set<City> otherStateCities = ((TourState) other).citiesVisited();
		return otherStateCities.containsAll(_otherCitiesVisited)
				&& _otherCitiesVisited.containsAll(otherStateCities)
				&& _currentCity.equals(((TourState)other).getCurrentCity());
	}
	
	public int hashCode() {
		int sum = 0;
		for(City city : _otherCitiesVisited) {
			sum += city.hashCode();
		}
		return sum;
	}
}

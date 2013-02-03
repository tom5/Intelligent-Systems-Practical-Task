package search.impl.tour.searchimpls;

import java.util.LinkedHashMap;
import java.util.Map;

import search.GoalTest;
import search.Node;
import search.NodeFunction;
import search.Search;
import search.State;
import search.frontier.impls.BreadthFirstFrontier;
import search.impl.tour.Cities;
import search.impl.tour.City;
import search.impl.tour.SetUpRomania;
import search.impl.tour.TourGoalTest;
import search.impl.tour.TourState;
import search.search.impls.GraphSearchImpl;

public class TravelToCityFurthestAwayThenGoalHeuristic implements NodeFunction {

	private Cities _cities;
	private City _goal;
	private Map<City, Map<City, Integer>> shortestDistanceCache;
	
	
	public TravelToCityFurthestAwayThenGoalHeuristic(Cities cities, City goal) {
		this._cities = cities;
		this._goal = goal;
	}
	
	private void cache(City start, City goal, int heuristic) {
		if(shortestDistanceCache == null) {
			shortestDistanceCache = new LinkedHashMap<City, Map<City, Integer>>();
		}
		if(!shortestDistanceCache.containsKey(start)) {
			shortestDistanceCache.put(start, new LinkedHashMap<City, Integer>());
		}
		shortestDistanceCache.get(start).put(goal, heuristic);
		
	}
	
	@Override
	public int nodeFunction(Node node) {

		TourState tourState = (TourState) node.state;
		
	
		City furthestCity = tourState.getCurrentCity(); //otherwise the heuristic does not equal 0 on the goal state.
		int maxDistanceToCity = 0;
		
		for(City city : _cities.getAllCities()) {
			//slightly modified: make it so that it just does it for the not yet visited cities.
			if(!tourState.citiesVisited().contains(city)) { 
				int distanceToCity = computeShortestDistanceToCity(tourState.getCurrentCity(), city);
				if(distanceToCity > maxDistanceToCity) {
					furthestCity = city;
					maxDistanceToCity = distanceToCity;
				}
			}
		}
		
		int distanceFromFurthestCityToGoal = computeShortestDistanceToCity(furthestCity, _goal);
		
		return maxDistanceToCity + distanceFromFurthestCityToGoal;
	}

	
	private int computeShortestDistanceToCity(City currentCity, City city) {
		if(shortestDistanceCache != null
				&& shortestDistanceCache.containsKey(currentCity)
				&& shortestDistanceCache.get(currentCity).containsKey(city)) {

			return shortestDistanceCache.get(currentCity).get(city);
			
		}
			
		
		
		BreadthFirstFrontier frontier = new BreadthFirstFrontier();
		Search searchImpl = new GraphSearchImpl(frontier);
		
		TourState startingState = new TourState(currentCity);
		
		GoalTest goalTest = new HasTravelledTo(city);
		
		Node root = new Node(null, null, startingState, 0);
		
		Node solution = searchImpl.search(root, goalTest);
		
		cache(currentCity, city, solution.nodeValueG);
		
		return solution.nodeValueG;
	}



	private class HasTravelledTo implements GoalTest {

		private City _goalCity;

		protected HasTravelledTo(City goalCity) {
			this._goalCity = goalCity;
		}
		
		@Override
		public boolean isGoalState(State state) {
			TourState tourState = (TourState) state;
			return tourState.getCurrentCity().equals(_goalCity);
		}
		
	}
}

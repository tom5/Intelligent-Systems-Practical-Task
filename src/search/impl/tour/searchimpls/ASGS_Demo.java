package search.impl.tour.searchimpls;

import search.Frontier;
import search.Node;
import search.Search;
import search.frontier.impls.BestFirstFrontier;
import search.frontier.impls.BreadthFirstFrontier;
import search.impl.tour.Cities;
import search.impl.tour.City;
import search.impl.tour.SetUpRomania;
import search.impl.tour.TourGoalTest;
import search.impl.tour.TourPrinting;
import search.impl.tour.TourState;
import search.search.impls.GraphSearchImpl;
import search.search.impls.TreeSearchImpl;


public class ASGS_Demo {
	
	public static void main(String[] args) {
		
		Cities citiesInRomania = SetUpRomania.getRomaniaMapSmall();
		
		City startingCity = citiesInRomania.getState("Bucharest");
		
		Frontier frontier = new BestFirstFrontier(new TravelToCityFurthestAwayThenGoalHeuristic(citiesInRomania, startingCity));

		Search searchImpl = new GraphSearchImpl(frontier);

		TourState startingState = new TourState(startingCity);
		
		TourGoalTest goalTest = new TourGoalTest(citiesInRomania, startingCity);
		
		Node root = new Node(null, null, startingState, 0);
		
		Node solution = searchImpl.search(root, goalTest);
		
		new TourPrinting().printSolution(solution);

		System.out.println("Nodes used: " + searchImpl.getNodesUsedInLastSearch());
		System.out.println("Max nodes in frontier: " + frontier.maxNodesStored());
	}
}

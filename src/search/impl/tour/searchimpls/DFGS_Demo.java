package search.impl.tour.searchimpls;

import search.Node;
import search.Search;
import search.frontier.impls.DepthFirstFrontier;
import search.impl.tour.Cities;
import search.impl.tour.City;
import search.impl.tour.SetUpRomania;
import search.impl.tour.TourGoalTest;
import search.impl.tour.TourPrinting;
import search.impl.tour.TourState;
import search.search.impls.GraphSearchImpl;


public class DFGS_Demo {
	
	public static void main(String[] args) {
		DepthFirstFrontier frontier = new DepthFirstFrontier();
		Search searchImpl = new GraphSearchImpl(frontier);
		
		Cities citiesInRomania = SetUpRomania.getRomaniaMapSmall();
		
		City startingCity = citiesInRomania.getState("Bucharest");
		
		TourState startingState = new TourState(startingCity);
		
		TourGoalTest goalTest = new TourGoalTest(citiesInRomania, startingCity);
		
		Node root = new Node(null, null, startingState, 0);
		
		Node solution = searchImpl.search(root, goalTest);
		
		new TourPrinting().printSolution(solution);
		
		System.out.println("Nodes used: " + searchImpl.getNodesUsedInLastSearch());
		System.out.println("Max nodes in frontier: " + frontier.maxNodesStored());
	}
}

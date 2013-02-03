package search.impl.npuzzle.searchimpls;

import search.Node;
import search.Search;
import search.frontier.impls.BreadthFirstFrontier;
import search.impl.npuzzle.Tiles;
import search.impl.npuzzle.TilesPrinting;
import search.impl.npuzzle.TilesSolutionChecker;
import search.search.impls.TreeSearchImpl;

public class BFTS_Demo {
	
	public static void main(String[] args) {
		BreadthFirstFrontier frontier = new BreadthFirstFrontier();
		Search searchImpl = new TreeSearchImpl(frontier);
		
		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
			});
		
		Node root = new Node(null, null, initialConfiguration, 0);
		
		Node solution = searchImpl.search(root, new TilesSolutionChecker());
		
		new TilesPrinting().printSolution(solution);
		
		System.out.println("Nodes used: " + searchImpl.getNodesUsedInLastSearch());
		System.out.println("Max nodes in frontier: " + frontier.maxNodesStored());

	}
}

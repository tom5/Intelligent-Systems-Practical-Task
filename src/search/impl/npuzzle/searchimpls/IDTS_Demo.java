package search.impl.npuzzle.searchimpls;

import search.Node;
import search.Search;
import search.impl.npuzzle.Tiles;
import search.impl.npuzzle.TilesPrinting;
import search.impl.npuzzle.TilesSolutionChecker;
import search.search.impls.IterativeDeepeningSearch;

public class IDTS_Demo {
	
	public static void main(String[] args) {
		Search searchImpl = new IterativeDeepeningSearch();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
			});
		
		Node root = new Node(null, null, initialConfiguration, 0);
		
		Node solution = searchImpl.search(root, new TilesSolutionChecker());
		
		new TilesPrinting().printSolution(solution);

		System.out.println("Nodes used: " + searchImpl.getNodesUsedInLastSearch());
		System.out.println("since a frontier was not used it is not clear how many nodes were stored.");

	}
}

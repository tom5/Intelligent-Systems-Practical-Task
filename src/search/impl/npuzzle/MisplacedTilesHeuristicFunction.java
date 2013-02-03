package search.impl.npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {

	@Override
	public int nodeFunction(Node node) {
		
		Tiles tiles = (Tiles) node.state;
		int width = tiles.getWidth();
		
		int misplacedNodeCount = 0;
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < width; j++) {
				if(tiles.getTile(i, j) != i * width + j + 1       //if the tile is in the right place
						&& !(i == width - 1 && j == width - 1)) { //or it was the special case of the zero tile in the bottom right
					misplacedNodeCount++; //it was a misplaced node
				}
			}
		}
		return misplacedNodeCount;
	}

}

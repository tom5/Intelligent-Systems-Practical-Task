package search.impl.npuzzle;

import search.GoalTest;
import search.State;

public class TilesSolutionChecker implements GoalTest {

	
	@Override
	public boolean isGoalState(State state) {
		if(!(state instanceof Tiles)) {
			throw new IllegalArgumentException();
		}
		Tiles grid = (Tiles) state;
		
		final int width = grid.getWidth();
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < width; j++) {
				if(grid.getTile(i, j) != i * width + j + 1) {
					//if it got here checking the last tile, then that tile
					//must be 0 by the process of elimination, so the goal state has been reached.
					return i == width - 1 && j == width - 1;
				}
			}
		}
		//never reached, satisfy the compiler
		throw new IllegalStateException("checked every tile, but have not already worked out whether in goal state or not.");
	}

}

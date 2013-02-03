package search.search.impls;

import search.GoalTest;
import search.Node;
import search.Search;
import search.frontier.impls.DepthFirstFrontier;

public class IterativeDeepeningSearch implements Search {

	private int _nodeCount;
	
	public IterativeDeepeningSearch() {
		_nodeCount = 0;
	}
	
	@Override
	public Node search(Node root, GoalTest goalTester) {
		int maxDepth = 0;
		_nodeCount = 0;
		while(true) {
			SearchWithMaxDepth searcher = new SearchWithMaxDepth(maxDepth);
			Node result = searcher.search(root, goalTester);
			_nodeCount+= searcher.getNodesUsedInLastSearch();
			if (result != null) {
				return result;
			}
			maxDepth++;
		}
	}
	
	@Override
	public int getNodesUsedInLastSearch() {
		return _nodeCount;
	}

	final private class SearchWithMaxDepth extends SearchImpl {

		private int _maxDepth;

		public SearchWithMaxDepth(int maxDepth) {
			super(new DepthFirstFrontier());
			this._maxDepth = maxDepth;
		}
		
		@Override
		protected boolean shouldExpandNode(Node node) {
			return node.depth <= _maxDepth;
		}
		
	}



}


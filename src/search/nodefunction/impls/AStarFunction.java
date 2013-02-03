package search.nodefunction.impls;

import search.Node;
import search.NodeFunction;

public class AStarFunction implements NodeFunction {
	private NodeFunction _heuristicFunction;

	public AStarFunction(NodeFunction heuristicFunction) {
		this._heuristicFunction = heuristicFunction;
	}

	@Override
	public int nodeFunction(Node node) {
		return node.nodeValueG + _heuristicFunction.nodeFunction(node);
	}
}

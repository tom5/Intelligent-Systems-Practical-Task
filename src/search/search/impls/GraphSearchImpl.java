package search.search.impls;

import java.util.LinkedHashSet;

import search.Frontier;
import search.Node;
import search.State;

public class GraphSearchImpl extends SearchImpl {

	private LinkedHashSet<State> _statesVisited;
	
	public GraphSearchImpl(Frontier frontier) {
		super(frontier);
		_statesVisited = new LinkedHashSet<State>();
	}

	@Override
	protected boolean shouldExpandNode(Node node) {
		if(!_statesVisited.contains(node.state)) {
			_statesVisited.add(node.state);
			return true;
		}
		else {
			return false;
		}
	}

}

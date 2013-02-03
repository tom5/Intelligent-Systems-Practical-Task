package search.search.impls;

import search.Frontier;
import search.Node;

public class TreeSearchImpl extends SearchImpl {

	public TreeSearchImpl(Frontier frontier) {
		super(frontier);
	}

	@Override
	protected boolean shouldExpandNode(Node node) {
		return true; //don't do any checking except in graph search
	}

}

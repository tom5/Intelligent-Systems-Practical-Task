package search.frontier.impls;

import java.util.Stack;

import search.Frontier;
import search.Node;

public class DepthFirstFrontier implements Frontier {

	private Stack<Node> stack;
	private int _maxNodesStored;
	
	public DepthFirstFrontier() {
		stack = new Stack<Node>();
		_maxNodesStored = 0;
	}
	
	@Override
	public void clear() {
		stack.clear();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Node getNextNode() {
		return stack.pop();
	}

	@Override
	public boolean add(Node node) {
		stack.push(node);
		if(stack.size() > _maxNodesStored) {
			_maxNodesStored = stack.size();
		}
		return true;
	}

	@Override
	public int maxNodesStored() {
		return _maxNodesStored;
	}

	

}

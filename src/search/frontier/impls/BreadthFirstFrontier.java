package search.frontier.impls;

import java.util.LinkedList;
import java.util.Queue;

import search.Frontier;
import search.Node;

public class BreadthFirstFrontier implements Frontier {

	private Queue<Node> queue;
	private int _maxNodesStored;
	
	public BreadthFirstFrontier() {
		queue = new LinkedList<Node>();
		_maxNodesStored = 0;
	}
	
	@Override
	public void clear() {
		queue.clear();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Node getNextNode() {
		return queue.remove();
	}

	@Override
	public boolean add(Node node) {
		queue.add(node);
		if(queue.size() > _maxNodesStored) {
			_maxNodesStored = queue.size();
		}
		return true;
	}

	@Override
	public int maxNodesStored() {
		return _maxNodesStored;
	}

}

package search.frontier.impls;

import java.util.Comparator;
import java.util.PriorityQueue;

import search.Frontier;
import search.Node;
import search.NodeFunction;

public class BestFirstFrontier implements Frontier {

	/**
	 * this node function takes a node n to f(n) as defined in lectures.
	 */
	protected NodeFunction _nodeHeuristic;
	protected PriorityQueue<Node> _priorityQueue;
	private int _maxNodesStored;
	
	
	public BestFirstFrontier(NodeFunction heuristic) {
		this._nodeHeuristic = heuristic;
		
		_priorityQueue = new PriorityQueue<Node>(1, new Comparator<Node>() {

			@Override
			public int compare(Node one, Node two) {
				return one.nodeValueH + one.nodeValueG - two.nodeValueH - two.nodeValueG;
			}
		});
		
		_maxNodesStored = 0;
	}
	
	@Override
	public void clear() {
		_priorityQueue.clear();
	}

	@Override
	public boolean isEmpty() {
		return _priorityQueue.isEmpty();
	}

	@Override
	public Node getNextNode() {
		return _priorityQueue.poll();
	}

	@Override
	public boolean add(Node node) {
		node.nodeValueH = _nodeHeuristic.nodeFunction(node);
		_priorityQueue.add(node);
		if(_priorityQueue.size() > _maxNodesStored) {
			_maxNodesStored = _priorityQueue.size();
		}
		return true;
	}

	@Override
	public int maxNodesStored() {
		return _maxNodesStored;
	}

}

package search.search.impls;

import java.util.Set;

import search.Action;
import search.Frontier;
import search.GoalTest;
import search.Node;
import search.Search;

public abstract class SearchImpl implements Search {

	protected Frontier frontier;
	protected int nodeCount;

	public SearchImpl(Frontier frontier) {
		this.frontier = frontier;
		nodeCount = 0;
	}
	
	@Override
	public Node search(Node root, GoalTest goalTester) {
		frontier.clear();
		nodeCount = 0;
		if(shouldExpandNode(root)) {
			frontier.add(root);
			nodeCount++;
		}
		while(!frontier.isEmpty()) {
			Node node = frontier.getNextNode();
			if(goalTester.isGoalState(node.state)) {
				return node;
			} else {
				Set<Action> possibleActions = node.state.getPossibleActions();
				for (Action action : possibleActions) {
					//TODO this might be bad, have set nodeValueF to be -1
					Node actionResult = new Node(node, action, node.state.getActionResult(action), node.depth + 1, -1, node.nodeValueG + action.cost());
					if(shouldExpandNode(actionResult)) {
						frontier.add(actionResult);
						nodeCount++;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public int getNodesUsedInLastSearch() {
		return nodeCount;
	}
	
	protected abstract boolean shouldExpandNode(Node node);

}

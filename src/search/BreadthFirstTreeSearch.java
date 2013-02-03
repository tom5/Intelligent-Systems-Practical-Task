package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class BreadthFirstTreeSearch {
	public static Node findSolution(State initialConfiguration, GoalTest goalTester) {
		
		Queue<Node> fifoQueue = new LinkedList<Node>();
		fifoQueue.add(new Node(null, null, initialConfiguration, 0));
		while (!fifoQueue.isEmpty()) {
			Node node = fifoQueue.remove();
			if (goalTester.isGoalState(node.state))
				return node;
			else {
				Set<Action> possibleActions = node.state.getPossibleActions();
				for (Action action : possibleActions)
					fifoQueue.add(new Node(node, action, node.state.getActionResult(action), node.depth + 1));
			}
		}
		return null;
	}
}

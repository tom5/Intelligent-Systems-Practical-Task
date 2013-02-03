package search;

public interface Search {
	/**
	 * @return null if there is no solution, else the solution node
	 */
	public Node search(Node root, GoalTest goalTest);
	
	public int getNodesUsedInLastSearch();
}

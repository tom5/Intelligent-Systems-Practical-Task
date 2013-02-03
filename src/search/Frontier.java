package search;

public interface Frontier {
	public void clear();
	
	public boolean isEmpty();
	
	public Node getNextNode();
	
	/**
	 * returns true if the node was added to the frontier.
	 */
	public boolean add(Node node);
	
	public int maxNodesStored();
}

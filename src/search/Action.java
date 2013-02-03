package search;

public interface Action {
	
	/**
	 * This is assumed to be a non-negative integer
	 * @return the cost of the action
	 */
	public int cost();
}

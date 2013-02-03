package search;

import java.util.Set;


public interface State {

	public Set<Action> getPossibleActions();
	
	public State getActionResult(Action action);
	
	public boolean equals(Object other);
	
	public int hashCode();
}

package search;


public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth;
	public int nodeValueH;
	public int nodeValueG;
	
	public Node(Node parent, Action action, State tiles, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = tiles;
		this.depth = depth;
		this.nodeValueH = 0;
		this.nodeValueG = 0;
	}

	
	public Node(Node parent, Action action, State tiles, int depth, int nodeValueF, int nodeValueG) {
		this.parent = parent;
		this.action = action;
		this.state = tiles;
		this.depth = depth;
		this.nodeValueH = nodeValueF;
		this.nodeValueG = nodeValueG;
	}
}

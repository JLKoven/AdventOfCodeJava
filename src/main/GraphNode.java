package main;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
	

	private int nodeID;
	private T data;
	private boolean visited = false;
	private List<GraphNode> children = new ArrayList<>();
	
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<GraphNode> getChildren() {
		return children;
	}
	public void setChildren(List<GraphNode> children) {
		this.children = children;
	}

}

package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphGridNode<T> {
	
	private int nodeID;
	private T data;
	private int yCoord;
	private int xCoord;
	private boolean visited = false;
	private Set<GraphGridNode> neighbors = new HashSet<>();
	
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
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public Set<GraphGridNode> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(Set<GraphGridNode> neighbors) {
		this.neighbors = neighbors;
	}


}

package main;

import java.util.HashSet;
import java.util.Set;

public class GraphGrid<T> {
	

	private Set<GraphGridNode<T>> graphGrid = new HashSet(); 
	
	public Set<GraphGridNode<T>> getGraphGridSet() {
		return graphGrid;
	}

	public void setGraphGrid(Set<GraphGridNode<T>> graphGrid) {
		this.graphGrid = graphGrid;
	}


	public void addNode(T valueAt, int i, int v) {
		GraphGridNode<T> nodeToAdd = new GraphGridNode();
		Set<GraphGridNode<T>> setToAddTo = getGraphGridSet();
		nodeToAdd.setNodeID(setToAddTo.size()+1);
		nodeToAdd.setData(valueAt);
		nodeToAdd.setyCoord(i);
		nodeToAdd.setxCoord(v);
		nodeToAdd.setVisited(false);
//		nodeToAdd.setNeighbors(neighborSet);
		setToAddTo.add(nodeToAdd);
		setGraphGrid(setToAddTo);
	}

//	public static void addNode(T valueAt, int i, int v) {
// this would be making a change for ALL GRAPHGRIDS, not just a given graphgrid doing this 
//		
//	}
		
	
	
	

}

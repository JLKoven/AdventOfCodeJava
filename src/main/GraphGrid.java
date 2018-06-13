package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphGrid<T> {
	

	private Map<IntPair, GraphGridNode<T>> graphGrid = new HashMap(); 
	
	public Map<IntPair, GraphGridNode<T>> getGraphGridMap() {
		return graphGrid;
	}

	public void setGraphGrid(Map<IntPair, GraphGridNode<T>> graphGrid) {
		this.graphGrid = graphGrid;
	}


	public void addNode(T valueAt, int i, int v) {
		GraphGridNode<T> nodeToAdd = new GraphGridNode();
		Map<IntPair, GraphGridNode<T>> mapToAddTo = getGraphGridMap();
		nodeToAdd.setNodeID(mapToAddTo.size()+1);
		nodeToAdd.setData(valueAt);
		nodeToAdd.setyCoord(i);
		nodeToAdd.setxCoord(v);
		nodeToAdd.setVisited(false);
//		nodeToAdd.setNeighbors(neighborSet);
		
		//intpair
		IntPair newIntPair = new IntPair();
		newIntPair.setYCoord(i);
		newIntPair.setXCoord(v);
		
		mapToAddTo.put(newIntPair, nodeToAdd);
		setGraphGrid(mapToAddTo);
	}

	public GraphGridNode getANode() {
		if (graphGrid.isEmpty()){
			System.out.println("ERROR THIS SHOULD NOT HAPPEN");
			return null;
		} else {
			Collection<GraphGridNode<T>> values = graphGrid.values();
			return values.iterator().next();
		}
	}

	public Set<GraphGridNode<Character>> getAllContiguousNodesofSameCharValue(GraphGridNode<Character> initialGridNode, Set<GraphGridNode<Character>> existingSet) {		
		initialGridNode.setVisited(true);
		existingSet.add(initialGridNode);
		Set<GraphGridNode> neighbors = initialGridNode.getNeighbors();
		for (GraphGridNode<Character> neighborCandidate : neighbors){
			if (
					(initialGridNode.getData().equals(neighborCandidate.getData()))
					&&
					(false == neighborCandidate.isVisited())
					){
				existingSet = getAllContiguousNodesofSameCharValue(neighborCandidate, existingSet);
			}
		}
		return existingSet;
	}

	public void deleteThisNodeAndNodeFromNeighbors(GraphGrid graph, 
			GraphGridNode<Character> contiguousNode) {
		Set<GraphGridNode> setToDeleteFrom = contiguousNode.getNeighbors();
		for (GraphGridNode<Character> neighbor : setToDeleteFrom){
			Set<GraphGridNode> neighborSet = neighbor.getNeighbors();
			neighborSet.remove(contiguousNode);
			neighbor.setNeighbors(neighborSet);
		}
		
		Map map = graph.getGraphGridMap();
		IntPair coordOfNodeToDelete = new IntPair();
		coordOfNodeToDelete.setYCoord(contiguousNode.getyCoord());
		coordOfNodeToDelete.setXCoord(contiguousNode.getxCoord());
		map.remove(coordOfNodeToDelete, map.get(coordOfNodeToDelete));
		graph.setGraphGrid(map);
		
	}

//	public static void addNode(T valueAt, int i, int v) {
// this would be making a change for ALL GRAPHGRIDS, not just a given graphgrid doing this 
//		
//	}
		
	
	
	

}

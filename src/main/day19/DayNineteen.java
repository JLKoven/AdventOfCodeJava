package main.day19;

import java.io.File;
import java.net.URI;
import java.util.List;
import java.util.Map;

import main.GeneralFunction;
import main.GraphGrid;
import main.GraphGridNode;
import main.IntPair;

public class DayNineteen {
	
	public static void executeStandardPart1() {
//		--- Day 19: A Series of Tubes ---
//		Somehow, a network packet got lost and ended up here. It's trying to follow a routing diagram (your puzzle input), but it's confused about where to go.
//
//		Its starting point is just off the top of the diagram. Lines (drawn with |, -, and +) show the path it needs to take, starting by going down onto the only line connected to the top of the diagram. It needs to follow this path until it reaches the end (located somewhere within the diagram) and stop there.
//
//		Sometimes, the lines cross over each other; in these cases, it needs to continue going the same direction, and only turn left or right when there's no other option. In addition, someone has left letters on the line; these also don't change its direction, but it can use them to keep track of where it's been. For example:
//
//		     |          
//		     |  +--+    
//		     A  |  C    
//		 F---|----E|--+ 
//		     |  |  |  D 
//		     +B-+  +--+ 
//
//		Given this diagram, the packet needs to take the following path:
//
//		Starting at the only line touching the top of the diagram, it must go down, pass through A, and continue onward to the first +.
//		Travel right, up, and right, passing through B in the process.
//		Continue down (collecting C), right, and up (collecting D).
//		Finally, go all the way left through E and stopping at F.
//		Following the path to the end, the letters it sees on its path are ABCDEF.
//
//		The little packet looks up at you, hoping you can help it find the way. What letters will it see (in the order it would see them) if it follows the path? (The routing diagram is very wide; make sure you view it without line wrapping.)

		System.out.println("Day 19 Part 1");
		File file = new File("src/main/day19/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}

	public static String getAnswerPartOneImperative(List<String> gridLayout) {
		GraphGrid<Character> grid = initializePuzzleGraph(gridLayout);
		
		IntPair currentCoordinates = findStartingCoordinates(gridLayout.get(0));
		
		StringBuilder collectedString = new StringBuilder();
		boolean finishedMaze = false;
//		Character nextChar = new Character('|');
		String currentDirection = "DOWN";
		while (!finishedMaze ){
			currentDirection = processStep(currentDirection, currentCoordinates, 
					currentDirection, collectedString, grid,
					grid.getGraphGridMap().get(currentCoordinates));
			
		}
		
		return collectedString.toString();
	}

	private static String processStep(String priorDirection, 
			IntPair currentCoordinates, String currentDirection, 
			StringBuilder collectedString, GraphGrid<Character> grid, 
			GraphGridNode<Character> graphGridNode) {
		int currentX =  currentCoordinates.getXCoord();
		int currentY =  currentCoordinates.getYCoord();
		System.out.println("Processing step at x("+currentX+") and y("+currentY+").");
		IntPair newCoordinates = currentCoordinates;//ready for mutation 
		switch (graphGridNode.getData()){
			case '|': 
			//herp
				if ("DOWN".equals(currentDirection)){
					currentY = currentY-1;					
				} else if ("UP".equals(currentDirection)){
					currentY = currentY+1;
				} else {
					System.out.println("Error! Direction fail!");
				}
				newCoordinates.setXCoord(currentX);
				newCoordinates.setYCoord(currentY);
				currentCoordinates = newCoordinates;
				break;
			case '-': 
			//herp
				if ("LEFT".equals(currentDirection)){
					currentX = currentX-1;					
				} else if ("RIGHT".equals(currentDirection)){
					currentX = currentX+1;
				} else {
					System.out.println("Error! Direction fail!");
				}
				newCoordinates.setXCoord(currentX);
				newCoordinates.setYCoord(currentY);
				currentCoordinates = newCoordinates;
				break;
			case '+': 
			//herp
				if ("DOWN".equals(currentDirection)){
					//look in the other three directions 
					//find the first location in Grid which doesn't have a nonblank character 
					if ("LEFT" == (coordinatesNonblankAtDirectionOtherThan("DOWN", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("UP" == (coordinatesNonblankAtDirectionOtherThan("DOWN", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("DOWN", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} 
				} else if ("UP".equals(currentDirection)){
					//look in the other three directions 
					//find the first location in Grid which doesn't have a nonblank character 
					if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("LEFT" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} 
				} else if ("LEFT".equals(currentDirection)){
					//look in the other three directions 
					//find the first location in Grid which doesn't have a nonblank character 
					if ("UP" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} 
				} else if ("RIGHT".equals(currentDirection)){
					//look in the other three directions 
					//find the first location in Grid which doesn't have a nonblank character 
					if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("LEFT" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} else if ("UP" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
						//that's the new direction, set it
						//set coordinates accordingly 
					} 
				}
				break;
			default: 
				collectedString.append(graphGridNode.getData());
				if ("DOWN".equals(currentDirection)){
					currentY = currentY-1;					
				} else if ("UP".equals(currentDirection)){
					currentY = currentY+1;
				} else if ("LEFT".equals(currentDirection)){
					currentX = currentX-1;					
				} else if ("RIGHT".equals(currentDirection)){
					currentX = currentX+1;
				}
				newCoordinates.setXCoord(currentX);
				newCoordinates.setYCoord(currentY);
				currentCoordinates = newCoordinates;
				break;
		}
		/*
|
-
+
else
		 */
		return priorDirection;
		
	}

	private static String coordinatesNonblankAtDirectionOtherThan(String string, IntPair currentCoordinates, GraphGrid<Character> grid) {
		// TODO Auto-generated method stub
		return null;
	}

	private static IntPair findStartingCoordinates(String string) {
		IntPair startCoords = new IntPair();
		startCoords.setYCoord(0);
		for (int i=0; i<string.length(); i++){
			if (string.charAt(i) == '|'){
				startCoords.setXCoord(i);
				break;
			}
		}
		return startCoords;
	}

	private static GraphGrid<Character> initializePuzzleGraph(List<String> gridLayout) {
		GraphGrid<Character> grid = new GraphGrid();
		Map<IntPair, GraphGridNode<Character>> innerMap = grid.getGraphGridMap();
		
		//set innerMap
		for(int y=0; y<gridLayout.size(); y++){
			for (int x=0; x<gridLayout.get(y).length(); x++){
				IntPair coordinates = new IntPair();
				coordinates.setYCoord(y);
				coordinates.setXCoord(x);
				GraphGridNode<Character> node = new GraphGridNode();
//				private int nodeID;//not needed
//				private T data;
				node.setData(gridLayout.get(y).charAt(x));
//				private int yCoord;
				node.setyCoord(y);
//				private int xCoord;
				node.setxCoord(x);
//				private boolean visited = false;//not needed
//				private Set<GraphGridNode> neighbors = new HashSet<>();//not needed
				innerMap.put(coordinates, node);
				
			}
		}
		
		grid.setGraphGrid(innerMap);
		return grid;
	}



}

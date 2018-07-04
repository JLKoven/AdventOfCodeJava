package main.year2017.day19;

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
		File file = new File("src/main/year2017/day19/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}
	
	public static void executeStandardPart2() {
//		--- Day 19: A Series of Tubes ---
//		The packet is curious how many steps it needs to go.
//
//		For example, using the same routing diagram from the example above...
//
//		     |          
//		     |  +--+    
//		     A  |  C    
//		 F---|--|-E---+ 
//		     |  |  |  D 
//		     +B-+  +--+ 
//
//		...the packet would go:
//
//		6 steps down (including the first line at the top of the diagram).
//		3 steps right.
//		4 steps up.
//		3 steps right.
//		4 steps down.
//		3 steps right.
//		2 steps up.
//		13 steps left (including the F it stops on).
//		This would result in a total of 38 steps.
//
//		How many steps does the packet need to go?
		System.out.println("Day 19 Part 2");
		File file = new File("src/main/year2017/day19/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartTwoImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}

	public static String getAnswerPartOneImperative(List<String> gridLayout) {
		GraphGrid<Character> grid = initializePuzzleGraph(gridLayout);
		
		IntPair currentCoordinates = findStartingCoordinates(gridLayout.get(0));
		
		StringBuilder collectedString = new StringBuilder();
		boolean finishedMaze = false;
//		Character nextChar = new Character('|');
		String currentDirection = "DOWN";
		while (!finishedMaze){
			/*
			currentDirection = processStep(currentDirection, currentCoordinates, 
					currentDirection, collectedString, grid,
					grid.getGraphGridMap().get(currentCoordinates));
					*/
			
			int currentX =  currentCoordinates.getXCoord();
			int currentY =  currentCoordinates.getYCoord();
//			System.out.print("Processing step at x("+currentX+") and y("+currentY+"), ");
//			System.out.println("with character "+grid.getGraphGridMap().get(currentCoordinates).getData()+".");

//			IntPair newCoordinates = currentCoordinates;//ready for mutation 
			IntPair newCoordinates = new IntPair();//ready for mutation 
			newCoordinates.setYCoord(currentY);
			newCoordinates.setXCoord(currentX);

			switch (grid.getGraphGridMap().get(currentCoordinates).getData()){
				case '|': 
				//herp
					if ("DOWN".equals(currentDirection)){
						currentY = currentY+1;					
					} else if ("UP".equals(currentDirection)){
						currentY = currentY-1;
					} else if ("LEFT".equals(currentDirection)){
						currentX = currentX-1;					
					} else if ("RIGHT".equals(currentDirection)){
						currentX = currentX+1;
					} else {
						System.out.println("errorneous direction found with "+currentDirection+".");
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
					} else if ("UP".equals(currentDirection)){
						currentY = currentY-1;
					} else if ("DOWN".equals(currentDirection)){
						currentY = currentY+1;					
					} else {
						System.out.println("errorneous direction found with "+currentDirection+".");
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
							currentDirection = "LEFT";
							//set coordinates accordingly 
							currentX = currentX-1;											
//						} else if ("UP" == (coordinatesNonblankAtDirectionOtherThan("DOWN", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "UP";
//							//set coordinates accordingly 
//							currentY = currentY-1;
						} else if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("DOWN", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "RIGHT";
							//set coordinates accordingly 
							currentX = currentX+1;
						} else {
							System.out.println("wait. what?");
						}
					} else if ("UP".equals(currentDirection)){
						//look in the other three directions 
						//find the first location in Grid which doesn't have a nonblank character 
						if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "RIGHT";
							//set coordinates accordingly 
							currentX = currentX+1;
//						} else if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "DOWN";
//							//set coordinates accordingly 
//							currentY = currentY+1;					
						} else if ("LEFT" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "LEFT";
							//set coordinates accordingly 
							currentX = currentX-1;					
						} else {
							System.out.println("wait. what?");
						}
					} else if ("LEFT".equals(currentDirection)){
						//look in the other three directions 
						//find the first location in Grid which doesn't have a nonblank character 
						if ("UP" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "UP";
							//set coordinates accordingly 
							currentY = currentY-1;
//						} else if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "RIGHT";
//							//set coordinates accordingly 
//							currentX = currentX+1;
						} else if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "DOWN";
							//set coordinates accordingly 
							currentY = currentY+1;					
						} else {
							System.out.println("wait. what?");
						}
					} else if ("RIGHT".equals(currentDirection)){
						//look in the other three directions 
						//find the first location in Grid which doesn't have a nonblank character 
						if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "DOWN";
							//set coordinates accordingly 
							currentY = currentY+1;					
//						} else if ("LEFT" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "LEFT";
//							//set coordinates accordingly 
//							currentX = currentX-1;					
						} else if ("UP" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "UP";
							//set coordinates accordingly 
							currentY = currentY-1;
						} else {
							System.out.println("wait. what?");
						}
					}
					newCoordinates.setXCoord(currentX);
					newCoordinates.setYCoord(currentY);
					currentCoordinates = newCoordinates;
					break;
				default: 
					collectedString.append(grid.getGraphGridMap().get(currentCoordinates).getData());
					
					//test for break
					
					if ("DOWN".equals(currentDirection)){
						currentY = currentY+1;					
					} else if ("UP".equals(currentDirection)){
						currentY = currentY-1;
					} else if ("LEFT".equals(currentDirection)){
						currentX = currentX-1;					
					} else if ("RIGHT".equals(currentDirection)){
						currentX = currentX+1;
					} else {
						System.out.println("errorneous direction found with "+currentDirection+".");
					}
					newCoordinates.setXCoord(currentX);
					newCoordinates.setYCoord(currentY);
					currentCoordinates = newCoordinates;
					break;
			}
			

			if (!grid.getGraphGridMap().containsKey(currentCoordinates)){
				finishedMaze = true;
			}
			if (' '==grid.getGraphGridMap().get(currentCoordinates).getData()){
				finishedMaze = true;
			}
//			System.out.println("now to parse character "+grid.getGraphGridMap().get(currentCoordinates).getData()+".");

			
//			if(weAreAtEdgeOfMaze(currentDirection, currentCoordinates, grid)){
//				System.out.println("at edge of maze");
//				finishedMaze = true;
//			}
		}
		
		return collectedString.toString();
	}

	private static boolean weAreAtEdgeOfMaze(String currentDirection, IntPair currentCoordinates, GraphGrid<Character> grid) {
		System.out.println("current direction is "+currentDirection+".");
		int baseX = currentCoordinates.getXCoord();
		int baseY = currentCoordinates.getYCoord();
		int upY = baseY-1;
		int downY = baseY+1;
		int leftX = baseX-1;
		int rightX = baseX+1;
		IntPair upCoord = new IntPair();
		IntPair rightCoord = new IntPair();
		IntPair downCoord = new IntPair();
		IntPair leftCoord = new IntPair();
		upCoord.setXCoord(baseX);
		upCoord.setYCoord(upY);
		rightCoord.setXCoord(rightX);
		rightCoord.setYCoord(baseY);
		downCoord.setXCoord(baseX);
		downCoord.setYCoord(downY);
		leftCoord.setXCoord(leftX);
		leftCoord.setYCoord(baseY);
		
		if ("LEFT" == currentDirection){
			if (!grid.getGraphGridMap().containsKey(leftCoord)){
				return true;
			} 
		} else if ("UP" == currentDirection){
			if (!grid.getGraphGridMap().containsKey(upCoord)){
				return true;
			}
			
		} else if ("RIGHT" == currentDirection){
			if (!grid.getGraphGridMap().containsKey(rightCoord)){
				return true;
			}
			
		} else if ("DOWN" == currentDirection){
			if (!grid.getGraphGridMap().containsKey(downCoord)){
				return true;
			}
			
		} else {
			System.out.println("errorneous direction found with "+currentDirection+".");
		}
		return false;
	}

	private static String processStep(String priorDirection, 
			IntPair currentCoordinates, String currentDirection, 
			StringBuilder collectedString, GraphGrid<Character> grid, 
			GraphGridNode<Character> graphGridNode) {

		/*
|
-
+
else
		 */
		return priorDirection;
		
	}

	private static String coordinatesNonblankAtDirectionOtherThan(String initialDirection, IntPair currentCoordinates, GraphGrid<Character> grid) {
		int baseX = currentCoordinates.getXCoord();
		int baseY = currentCoordinates.getYCoord();
		int upY = baseY-1;
		int downY = baseY+1;
		int leftX = baseX-1;
		int rightX = baseX+1;
		IntPair upCoord = new IntPair();
		IntPair rightCoord = new IntPair();
		IntPair downCoord = new IntPair();
		IntPair leftCoord = new IntPair();
		upCoord.setXCoord(baseX);
		upCoord.setYCoord(upY);
		rightCoord.setXCoord(rightX);
		rightCoord.setYCoord(baseY);
		downCoord.setXCoord(baseX);
		downCoord.setYCoord(downY);
		leftCoord.setXCoord(leftX);
		leftCoord.setYCoord(baseY);
		
		
		if ("LEFT".equals(initialDirection)){
			//check 2 other directions 
			//check up
			if (grid.getGraphGridMap().containsKey(upCoord)){
				if (' '!=grid.getGraphGridMap().get(upCoord).getData()){
					return "UP";
				}
			}
//			//check right
//			if (grid.getGraphGridMap().containsKey(rightCoord)){
//				if (' '!=grid.getGraphGridMap().get(rightCoord).getData()){
//					return "RIGHT";
//				}
//			}
			//check down 
			if (grid.getGraphGridMap().containsKey(downCoord)){
				if (' '!=grid.getGraphGridMap().get(downCoord).getData()){
					return "DOWN";
				}
			}
		} else if ("UP".equals(initialDirection)){
			//check 2 other directions 
			//check right
			if (grid.getGraphGridMap().containsKey(rightCoord)){
				if (' '!=grid.getGraphGridMap().get(rightCoord).getData()){
					return "RIGHT";
				}
			}
//			//check down 
//			if (grid.getGraphGridMap().containsKey(downCoord)){
//				if (' '!=grid.getGraphGridMap().get(downCoord).getData()){
//					return "DOWN";
//				}
//			}
			//check left 
			if (grid.getGraphGridMap().containsKey(leftCoord)){
				if (' '!=grid.getGraphGridMap().get(leftCoord).getData()){
					return "LEFT";
				}
			}
		} else if ("RIGHT".equals(initialDirection)){
			//check 2 other directions 
			//check up
			if (grid.getGraphGridMap().containsKey(upCoord)){
				if (' '!=grid.getGraphGridMap().get(upCoord).getData()){
					return "UP";
				}
			}
			//check down 
			if (grid.getGraphGridMap().containsKey(downCoord)){
				if (' '!=grid.getGraphGridMap().get(downCoord).getData()){
					return "DOWN";
				}
			}
//			//check left 
//			if (grid.getGraphGridMap().containsKey(leftCoord)){
//				if (' '!=grid.getGraphGridMap().get(leftCoord).getData()){
//					return "LEFT";
//				}
//			}
		} else if ("DOWN".equals(initialDirection)){
			//check 2 other directions 
			//check up
//			if (grid.getGraphGridMap().containsKey(upCoord)){
//				if (' '!=grid.getGraphGridMap().get(upCoord).getData()){
//					return "UP";
//				}
//			}
//			//check right
			if (grid.getGraphGridMap().containsKey(rightCoord)){
				if (' '!=grid.getGraphGridMap().get(rightCoord).getData()){
					return "RIGHT";
				}
			}
			//check left 
			if (grid.getGraphGridMap().containsKey(leftCoord)){
				if (' '!=grid.getGraphGridMap().get(leftCoord).getData()){
					return "LEFT";
				}
			}
		} else {
			System.out.println("initial direction error message");
		}
		System.out.println("WHAT HAPPENED");
		return initialDirection;
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

	public static Integer getAnswerPartTwoImperative(List<String> gridLayout) {
		Integer stepsCounted=0;

		GraphGrid<Character> grid = initializePuzzleGraph(gridLayout);
		
		IntPair currentCoordinates = findStartingCoordinates(gridLayout.get(0));
		
		StringBuilder collectedString = new StringBuilder();
		boolean finishedMaze = false;
//		Character nextChar = new Character('|');
		String currentDirection = "DOWN";
		while (!finishedMaze){
			/*
			currentDirection = processStep(currentDirection, currentCoordinates, 
					currentDirection, collectedString, grid,
					grid.getGraphGridMap().get(currentCoordinates));
					*/
			stepsCounted++;
			int currentX =  currentCoordinates.getXCoord();
			int currentY =  currentCoordinates.getYCoord();
//			System.out.print("Processing step at x("+currentX+") and y("+currentY+"), ");
//			System.out.println("with character "+grid.getGraphGridMap().get(currentCoordinates).getData()+".");

//			IntPair newCoordinates = currentCoordinates;//ready for mutation 
			IntPair newCoordinates = new IntPair();//ready for mutation 
			newCoordinates.setYCoord(currentY);
			newCoordinates.setXCoord(currentX);

			switch (grid.getGraphGridMap().get(currentCoordinates).getData()){
				case '|': 
				//herp
					if ("DOWN".equals(currentDirection)){
						currentY = currentY+1;					
					} else if ("UP".equals(currentDirection)){
						currentY = currentY-1;
					} else if ("LEFT".equals(currentDirection)){
						currentX = currentX-1;					
					} else if ("RIGHT".equals(currentDirection)){
						currentX = currentX+1;
					} else {
						System.out.println("errorneous direction found with "+currentDirection+".");
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
					} else if ("UP".equals(currentDirection)){
						currentY = currentY-1;
					} else if ("DOWN".equals(currentDirection)){
						currentY = currentY+1;					
					} else {
						System.out.println("errorneous direction found with "+currentDirection+".");
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
							currentDirection = "LEFT";
							//set coordinates accordingly 
							currentX = currentX-1;											
//						} else if ("UP" == (coordinatesNonblankAtDirectionOtherThan("DOWN", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "UP";
//							//set coordinates accordingly 
//							currentY = currentY-1;
						} else if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("DOWN", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "RIGHT";
							//set coordinates accordingly 
							currentX = currentX+1;
						} else {
							System.out.println("wait. what?");
						}
					} else if ("UP".equals(currentDirection)){
						//look in the other three directions 
						//find the first location in Grid which doesn't have a nonblank character 
						if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "RIGHT";
							//set coordinates accordingly 
							currentX = currentX+1;
//						} else if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "DOWN";
//							//set coordinates accordingly 
//							currentY = currentY+1;					
						} else if ("LEFT" == (coordinatesNonblankAtDirectionOtherThan("UP", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "LEFT";
							//set coordinates accordingly 
							currentX = currentX-1;					
						} else {
							System.out.println("wait. what?");
						}
					} else if ("LEFT".equals(currentDirection)){
						//look in the other three directions 
						//find the first location in Grid which doesn't have a nonblank character 
						if ("UP" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "UP";
							//set coordinates accordingly 
							currentY = currentY-1;
//						} else if ("RIGHT" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "RIGHT";
//							//set coordinates accordingly 
//							currentX = currentX+1;
						} else if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("LEFT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "DOWN";
							//set coordinates accordingly 
							currentY = currentY+1;					
						} else {
							System.out.println("wait. what?");
						}
					} else if ("RIGHT".equals(currentDirection)){
						//look in the other three directions 
						//find the first location in Grid which doesn't have a nonblank character 
						if ("DOWN" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "DOWN";
							//set coordinates accordingly 
							currentY = currentY+1;					
//						} else if ("LEFT" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
//							//that's the new direction, set it
//							currentDirection = "LEFT";
//							//set coordinates accordingly 
//							currentX = currentX-1;					
						} else if ("UP" == (coordinatesNonblankAtDirectionOtherThan("RIGHT", currentCoordinates, grid))){
							//that's the new direction, set it
							currentDirection = "UP";
							//set coordinates accordingly 
							currentY = currentY-1;
						} else {
							System.out.println("wait. what?");
						}
					}
					newCoordinates.setXCoord(currentX);
					newCoordinates.setYCoord(currentY);
					currentCoordinates = newCoordinates;
					break;
				default: 
					collectedString.append(grid.getGraphGridMap().get(currentCoordinates).getData());
					
					//test for break
					
					if ("DOWN".equals(currentDirection)){
						currentY = currentY+1;					
					} else if ("UP".equals(currentDirection)){
						currentY = currentY-1;
					} else if ("LEFT".equals(currentDirection)){
						currentX = currentX-1;					
					} else if ("RIGHT".equals(currentDirection)){
						currentX = currentX+1;
					} else {
						System.out.println("errorneous direction found with "+currentDirection+".");
					}
					newCoordinates.setXCoord(currentX);
					newCoordinates.setYCoord(currentY);
					currentCoordinates = newCoordinates;
					break;
			}
			

			if (!grid.getGraphGridMap().containsKey(currentCoordinates)){
				finishedMaze = true;
			}
			if (' '==grid.getGraphGridMap().get(currentCoordinates).getData()){
				finishedMaze = true;
			}
//			System.out.println("now to parse character "+grid.getGraphGridMap().get(currentCoordinates).getData()+".");

			
//			if(weAreAtEdgeOfMaze(currentDirection, currentCoordinates, grid)){
//				System.out.println("at edge of maze");
//				finishedMaze = true;
//			}
		}
		
		return stepsCounted;
	}



}

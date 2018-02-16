package main.day3;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayThree {
	
	public static final String RIGHT = "Right";
	public static final String UP = "Up";
	public static final String LEFT = "Left";
	public static final String DOWN = "Down";

	public static void executeStandardPart1() {
	// --- Day 3: Spiral Memory ---
	// You come across an experimental new kind of memory stored on an infinite
	// two-dimensional grid.
	//
	// Each square on the grid is allocated in a spiral pattern starting at a
	// location marked 1 and then counting up while spiraling outward. For
	// example, the first few squares are allocated like this:
	//
	// 17 16 15 14 13
	// 18 5 4 3 12
	// 19 6 1 2 11
	// 20 7 8 9 10
	// 21 22 23---> ...
	// While this is very space-efficient (no squares are skipped), requested
	// data must be carried back to square 1 (the location of the only access
	// port for this memory system) by programs that can only move up, down,
	// left, or right. They always take the shortest path: the Manhattan
	// Distance between the location of the data and square 1.
	//
	// For example:
	//
	// Data from square 1 is carried 0 steps, since it's at the access port.
	// Data from square 12 is carried 3 steps, such as: down, left, left.
	// Data from square 23 is carried only 2 steps: up twice.
	// Data from square 1024 must be carried 31 steps.
	// How many steps are required to carry the data from the square identified
	// in your puzzle input all the way to the access port?
	//
	// input is 312051
		System.out.println("Day Three Part 1");
        File file = new File("src/main/day3/input.txt");
        URI uri = file.toURI();
		System.out.println("Data from square 312051 is carried " + DayThree.getAnswerPartOneImperative(getInput(uri)) + " steps!");
//		System.out.println("Data from square 312051 is carried " + DayThree.getAnswerPartOneFunctional(				
//				0, 0, 
//				RIGHT, 
//				0, 0, 0, 0, 
//				0, 	
//				getInput(uri)
//				) + " steps!");
	}
	


	public static void executeStandardPart2() {
	// --- Part Two ---
	// As a stress test on the system, the programs here clear the grid and then
	// store the value 1 in square 1. Then, in the same allocation order as
	// shown above, they store the sum of the values in all adjacent squares,
	// including diagonals.
	//
	// So, the first few squares' values are chosen as follows:
	//
	// Square 1 starts with the value 1.
	// Square 2 has only one adjacent filled square (with value 1), so it also
	// stores 1.
	// Square 3 has both of the above squares as neighbors and stores the sum of
	// their values, 2.
	// Square 4 has all three of the aforementioned squares as neighbors and
	// stores the sum of their values, 4.
	// Square 5 only has the first and fourth squares as neighbors, so it gets
	// the value 5.
	// Once a square is written, its value does not change. Therefore, the first
	// few squares would receive the following values:
	//
	// 147 142 133 122 59
	// 304 5 4 2 57
	// 330 10 1 1 54
	// 351 11 23 25 26
	// 362 747 806---> ...
	// What is the first value written that is larger than your puzzle input?
	// input is 277678
		System.out.println("Day Three Part 2");
        File file = new File("src/main/day3/input.txt");
        URI uri = file.toURI();
		try {
			System.out.println("Answer first larger than 277678 is "
					+ getAnswerPartTwoImperative(getInput(uri)) + ". Hooray!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	//Imperative

	public static int getAnswerPartOneImperative(int stepsFromOrigin) {
		int answer = 0;
		SpiralGridImperative grid = new SpiralGridImperative();
		for (int i = 0; i < stepsFromOrigin; i++) {
			grid.addCellToGrid();
		}
		SpiralGridCellImperative lastCell = grid.getMostRecentCell().get();
		answer = answer + Math.abs(lastCell.getXCoord());
		answer = answer + Math.abs(lastCell.getYCoord());
		return answer;
	}

	public static int getCumulativeValueOfThisCell(int index) {
		SpiralGridImperative grid = new SpiralGridImperative();
		for (int i = 0; i < index; i++) {
			grid.addCellToGrid();
		}
		SpiralGridCellImperative lastCell = grid.getMostRecentCell().get();
		return lastCell.getCellCumulativeValue();
	}

	public static int getAnswerPartTwoImperative(int input) {
		int answer = 0;
		SpiralGridImperative grid = new SpiralGridImperative();
		while (input > answer) {
			grid.addCellToGrid();
			SpiralGridCellImperative lastCell = grid.getMostRecentCell().get();
			answer = lastCell.getCellCumulativeValue();
		}
		return answer;
	}
	
	// Functional 
	public static int getAnswerPartOneFunctional(
			int xCoord, int yCoord, 
			String currentDirection, 
			int maxX, int maxY, int minX, int minY, 
			int currentSteps, 			
			int stepsFromOrigin
			) {
		System.out.println("Current values are "+xCoord+" and "+yCoord+".");
		if (currentSteps == stepsFromOrigin){
			return xCoord+yCoord;
		} else {
			
			if (RIGHT.equals(currentDirection)){
				xCoord++;
				//we're going to go right
				//but then, we're going to check against maxX, if yes
				//switch currentDirection to UP
				//change maxCoords
				if (xCoord > maxX){
					currentDirection = UP;
					maxX++;
				}
				//else, keep it as current
			} else if (UP.equals(currentDirection)){
				yCoord++;
				//we're going to go Up
				//but then, we're going to check against maxY, if yes
				//switch currentDirection to LEFT
				//change maxCoords
				if (yCoord > maxY){
					currentDirection = LEFT;
					maxY++;
				}
				//else, keep it as current
			} else if (LEFT.equals(currentDirection)){
				xCoord--;
				//we're going to go Left
				//but then, we're going to check against minX, if yes
				//switch currentDirection to DOWN
				//change maxCoords
				if (xCoord < minX){
					currentDirection = DOWN;
					minX--;
				}
				//else, keep it as current
			} else if (DOWN.equals(currentDirection)){
				yCoord--;
				//we're going to go Down
				//but then, we're going to check against minY, if yes
				//switch currentDirection to RIGHT
				//change maxCoords
				if (yCoord < minY){
					currentDirection = RIGHT;
					minY--;
				}
				//else, keep it as current
			} else {
				Exception error = new Exception();
				try {
					throw error;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			currentSteps++;
			return getAnswerPartOneFunctional(
					xCoord, yCoord, 
					currentDirection, 
					maxX, maxY, minX, minY, 
					currentSteps, 			
					stepsFromOrigin
					);
			
		}

	}
	

	private static int getInput(URI fileName) {
		List<String> linesAsString = new ArrayList<String>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Integer> lines = new ArrayList<Integer>();
		lines.addAll(linesAsString.stream().map(Integer::valueOf).collect(Collectors.toList()));
		return lines.get(0);
	}



}

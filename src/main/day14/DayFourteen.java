package main.day14;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.GeneralFunction;
import main.GraphGrid;
import main.GraphGridNode;
import main.IntPair;
import main.day10.DayTen;

public class DayFourteen {
	
	public static void executeStandardPart1() {
//		--- Day 14: Disk Defragmentation ---
//		Suddenly, a scheduled job activates the system's disk defragmenter. Were the situation different, you might sit and watch it for a while, but today, you just don't have that kind of time. It's soaking up valuable system resources that are needed elsewhere, and so the only option is to help it finish its task as soon as possible.
//
//		The disk in question consists of a 128x128 grid; each square of the grid is either free or used. On this disk, the state of the grid is tracked by the bits in a sequence of knot hashes.
//
//		A total of 128 knot hashes are calculated, each corresponding to a single row in the grid; each hash contains 128 bits which correspond to individual grid squares. Each bit of a hash indicates whether that square is free (0) or used (1).
//
//		The hash inputs are a key string (your puzzle input), a dash, and a number from 0 to 127 corresponding to the row. For example, if your key string were flqrgnkx, then the first row would be given by the bits of the knot hash of flqrgnkx-0, the second row from the bits of the knot hash of flqrgnkx-1, and so on until the last row, flqrgnkx-127.
//
//		The output of a knot hash is traditionally represented by 32 hexadecimal digits; each of these digits correspond to 4 bits, for a total of 4 * 32 = 128 bits. To convert to bits, turn each hexadecimal digit to its equivalent binary value, high-bit first: 0 becomes 0000, 1 becomes 0001, e becomes 1110, f becomes 1111, and so on; a hash that begins with a0c2017... in hexadecimal would begin with 10100000110000100000000101110000... in binary.
//
//		Continuing this process, the first 8 rows and columns for key flqrgnkx appear as follows, using # to denote used squares, and . to denote free ones:
//
//		##.#.#..-->
//		.#.#.#.#   
//		....#.#.   
//		#.#.##.#   
//		.##.#...   
//		##..#..#   
//		.#...#..   
//		##.#.##.-->
//		|      |   
//		V      V   
//		In this example, 8108 squares are used across the entire 128x128 grid.
//
//		Given your actual key string, how many squares are used?
		System.out.println("Day 14 Part 1");
		File file = new File("src/main/day14/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(GeneralFunction.getStandardInputString(uri)) + ".");
		
		
	}
	
	
	
	public static void executeStandardPart2() {
//		--- Part Two ---
//		Now, all the defragmenter needs to know is the number of regions. A region is a group of used squares that are all adjacent, not including diagonals. Every used square is in exactly one region: lone used squares form their own isolated regions, while several adjacent squares all count as a single region.
//
//		In the example above, the following nine regions are visible, each marked with a distinct digit:
//
//		11.2.3..-->
//		.1.2.3.4   
//		....5.6.   
//		7.8.55.9   
//		.88.5...   
//		88..5..8   
//		.8...8..   
//		88.8.88.-->
//		|      |   
//		V      V   
//		Of particular interest is the region marked 8; while it does not appear contiguous in this small view, all of the squares marked 8 are connected when considering the whole 128x128 grid. In total, in this example, 1242 regions are present.
//
//		How many regions are present given your key string?
		System.out.println("Day 14 Part 2");
		File file = new File("src/main/day14/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is " + getAnswerPartTwoImperative(GeneralFunction.getStandardInputString(uri)) + ".");
		
		
	}




	public static Integer getAnswerPartOneImperative(String input) {
		//List<String> hashList = createHashList(input);
		GraphGrid hashGraphGrid = createHashGraphGrid(input);

		
		return countSquares(hashGraphGrid);
	}
	



	public static Integer getAnswerPartTwoImperative(String input) {
		GraphGrid hashGraphGrid = createHashGraphGrid(input);

		
		return countAreas(hashGraphGrid);
	}



	public static Integer countAreas(GraphGrid hashGraphGrid) {
		
		Integer areaCounter = 0;
		Integer gridCounter = 0;
//		while visitedCounter < 128*128
		Integer visitedCounter = 0;//less than 16384
		while (visitedCounter < 16384){
			//
//			go through graph for a 1 or 0. 
			GraphGridNode initialGrid = hashGraphGrid.getANode();
			
			Character value = (Character) initialGrid.getData();
//			if ('1' == (char) initialGrid.getData()){
//				
//			} 

			//Okay. Start looking for all of its neighbors 
			//and add these to a set if they are also 1 
			//(and 'unvisited'), toggle THIS to 'visited'. 

			
	//
//			delete all of these nodes in this set :) 
	//
//			increment 'areafinder' by 1 if the node was 1
		}
		
		return areaCounter;
	}


	private static Integer countSquares(List<String> hashList) {
		int value=0;
		for (int i=0; i<hashList.size(); i++){
			for (int v=0; v<hashList.get(i).length(); v++){
				if ('1' == hashList.get(i).charAt(v)){
					value++;
				} else if ('0' == hashList.get(i).charAt(v)){
					
				} else {
					System.out.println("ERROR item is "+hashList.get(i).charAt(v)+".");
				}
			}
		}
		return value;
	}
	
	private static Integer countSquares(GraphGrid<Character> hashGraphGrid) {
		int value=0;
		for ( GraphGridNode<Character> node : hashGraphGrid.getGraphGridMap().values()){
			if ('1' == node.getData()){
				value++;
			} else if ('0' == node.getData()){
				
			} else {
				System.out.println("ERROR item is "+node.getData()+".");
			}
		}
/*
		for (int i=0; i<hashList.size(); i++){
			for (int v=0; v<hashList.get(i).length(); v++){
				if ('1' == hashList.get(i).charAt(v)){
					value++;
				} else if ('0' == hashList.get(i).charAt(v)){
					
				} else {
					System.out.println("ERROR item is "+hashList.get(i).charAt(v)+".");
				}
			}
		}
		*/
		return value;
	}



	private static List<String> createHashList(String input) {
		List<String> hashList = new ArrayList<>();
		for (int i=0; i<128; i++){
			String sourceHash = DayTen.getHash(getInputFromInputAndNumber(input, i));
			String newHash = getBinaryHash(sourceHash);
			hashList.add(newHash);
		}
		return hashList;
	}
	
	private static GraphGrid createHashGraphGrid(String input) {
		GraphGrid<Character> hashGraphGrid = new GraphGrid<Character>();
		for (int i=0; i<128; i++){
			String sourceHash = DayTen.getHash(getInputFromInputAndNumber(input, i));
			String newHash = getBinaryHash(sourceHash);
			for (int v=0; v<newHash.length(); v++){
				hashGraphGrid.addNode(newHash.charAt(v), i, v);
			}
		}
		for (GraphGridNode<Character> node : hashGraphGrid.getGraphGridMap().values()){
			//			node.setValidNeighbors(node, hashGraphGrid);
			Set<GraphGridNode> newSet = new HashSet();
			IntPair coordinates = new IntPair();
			coordinates.setYCoord(node.getyCoord());
			coordinates.setXCoord(node.getxCoord());
			//check if north neighbor exists. If it does, add it 
			if (0 < node.getyCoord()){				
				IntPair coordinatesNorth = new IntPair();
				coordinatesNorth.setYCoord(node.getyCoord()-1);
				coordinatesNorth.setXCoord(node.getxCoord());
				GraphGridNode northNeighbor = hashGraphGrid.getGraphGridMap()
						.get(coordinatesNorth);
				newSet.add(northNeighbor);
			}
			//check if east neighbor exists. If it does, add it
			if (127 > node.getxCoord()){				
				IntPair coordinatesEast = new IntPair();
				coordinatesEast.setYCoord(node.getyCoord());
				coordinatesEast.setXCoord(node.getxCoord()+1);
				GraphGridNode eastNeighbor = hashGraphGrid.getGraphGridMap()
						.get(coordinatesEast);
				newSet.add(eastNeighbor);
			}
			//check if south neighbor exists. If it does, add it	
			if (127 > node.getyCoord()){				
				IntPair coordinatesSouth = new IntPair();
				coordinatesSouth.setYCoord(node.getyCoord()+1);
				coordinatesSouth.setXCoord(node.getxCoord());
				GraphGridNode southNeighbor = hashGraphGrid.getGraphGridMap()
						.get(coordinatesSouth);
				newSet.add(southNeighbor);
			}
			//check if west neighbor exists. If it does, add it
			if (0 < node.getxCoord()){				
				IntPair coordinatesWest = new IntPair();
				coordinatesWest.setYCoord(node.getyCoord());
				coordinatesWest.setXCoord(node.getxCoord()-1);
				GraphGridNode westNeighbor = hashGraphGrid.getGraphGridMap()
						.get(coordinatesWest);
				newSet.add(westNeighbor);
			}
			node.setNeighbors(newSet);		
//			System.out.println("Node id is "+node.getNodeID()+".");
//			System.out.println("Node y is "+node.getyCoord()+".");
//			System.out.println("Node x is "+node.getxCoord()+".");
//			System.out.println("Node neighbor set size is "+node.getNeighbors().size()+".");
//			for (GraphGridNode neighbor : node.getNeighbors()){
//				System.out.println("neighbor's ID is "+neighbor.getNodeID()+".");
//			}
//			System.out.println("");

		}
		return hashGraphGrid ;
	}



	private static String getBinaryHash(String sourceHash) {
		StringBuilder builder = new StringBuilder();
		for (int i=0; i<sourceHash.length(); i++){
			builder.append(convertHexToBin(sourceHash.charAt(i)));
		}
		return builder.toString();
	}



	private static String convertHexToBin(char charAt) {
		int i = Integer.parseInt(Character.toString(charAt), 16);
		return String.format("%04d", Integer.parseInt(Integer.toBinaryString(i)));
	}



	private static String getInputFromInputAndNumber(String input, int i) {
		StringBuilder builder = new StringBuilder();
		builder.append(input);
		builder.append("-");
		builder.append(Integer.toString(i));
		return builder.toString();
	}




}

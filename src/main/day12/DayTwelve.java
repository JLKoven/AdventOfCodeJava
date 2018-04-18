package main.day12;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.GeneralFunction;
import main.GraphNode;

public class DayTwelve {

	public static void executeStandardPart1() {
//		Walking along the memory banks of the stream, you find a small village that is experiencing a little confusion: some programs can't communicate with each other.
//
//		Programs in this village communicate using a fixed system of pipes. Messages are passed between programs using these pipes, but most programs aren't connected to each other directly. Instead, programs pass messages between each other until the message reaches the intended recipient.
//
//		For some reason, though, some of these messages aren't ever reaching their intended recipient, and the programs suspect that some pipes are missing. They would like you to investigate.
//
//		You walk through the village and record the ID of each program and the IDs with which it can communicate directly (your puzzle input). Each program has one or more programs with which it can communicate, and these pipes are bidirectional; if 8 says it can communicate with 11, then 11 will say it can communicate with 8.
//
//		You need to figure out how many programs are in the group that contains program ID 0.
//
//		For example, suppose you go door-to-door like a travelling salesman and record the following list:
//
//		0 <-> 2
//		1 <-> 1
//		2 <-> 0, 3, 4
//		3 <-> 2, 4
//		4 <-> 2, 3, 6
//		5 <-> 6
//		6 <-> 4, 5
//		In this example, the following programs are in the group that contains program ID 0:
//
//		Program 0 by definition.
//		Program 2, directly connected to program 0.
//		Program 3 via program 2.
//		Program 4 via program 2.
//		Program 5 via programs 6, then 4, then 2.
//		Program 6 via programs 4, then 2.
//		Therefore, a total of 6 programs are in this group; all but program 1, which has a pipe that connects it to itself.
//
//		How many programs are in the group that contains program ID 0?
		System.out.println("Day 12 Part 1");
		File file = new File("src/main/day12/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri), 0) + ".");
				
	}

	public static void executeStandardPart2() {
		// TODO Auto-generated method stub
		
	}

	public static Integer getAnswerPartOneImperative(List<String> input, int initialIndex) {
		
		Stack<Integer> destinationList = new Stack();
		Set<Integer> visitedList = new HashSet<>();
		//start index initialIndex
		
		String initialStringToProcess = input.get(initialIndex);
//		Integer startIndex = processLeft(stringToProcess);
		visitedList.add(initialIndex);

		List<Integer> initialNodesAsIntegers = processRight(initialStringToProcess);
		for (Integer node : initialNodesAsIntegers){
			if (!visitedList.contains(node)){
				destinationList.push(node);
			}
			visitedList.add(node);
		}
		
		
		while (!destinationList.isEmpty()){
			Integer targetNode = destinationList.pop();
			String stringToProcess = input.get(targetNode);
			visitedList.add(targetNode);//might not need this
			List<Integer> nodesAsIntegers = processRight(stringToProcess);
			for (Integer node : nodesAsIntegers){
				if (!visitedList.contains(node)){
					destinationList.push(node);
				}
				visitedList.add(node);
			}

		}
		return visitedList.size();
		
//		Pattern pattern = Pattern.compile(stringToProcess);
//		Matcher rightSide = pattern.matcher("[-.]+");
		
//		String leftSide = [^,]*$
		
		
//		"[-.]+"
		

		
//		List<String> input = new ArrayList<>();
//		input.add("0 <-> 2");
//		input.add("1 <-> 1");
//		input.add("2 <-> 0, 3, 4");
//		input.add("3 <-> 2, 4");
//		input.add("4 <-> 2, 3, 6");
//		input.add("5 <-> 6");
//		input.add("6 <-> 4, 5");
//		int index = 2;
//		String stringToProcess = input.get(index);

//		Pattern secondPattern = Pattern.compile("[-.]+");
//		Matcher nodeList = secondPattern.matcher(rightSide.group(0));
//		if (nodeList.find()){
//			System.out.println(nodeList.group(0));
//		} else {
//			System.out.println("uh oh!");
//		}
		
		
	}

	private static List<Integer> processRight(String stringToProcess) {
		Pattern initialRightPattern = Pattern.compile("[^>]*$");
		Matcher rightSide = initialRightPattern.matcher(stringToProcess);
//		if (rightSide.find()){
////			System.out.println(rightSide.group(0));
//		} else {
////			System.out.println("whoops");
//		}
//		System.out.println("");
		String[] nodes;
		if (rightSide.find()){
			nodes = rightSide.group(0).split("[,]+");
		} else {
			nodes = null;
		}
		List<Integer> nodesAsIntegers = GeneralFunction.convertStringArrayToIntegerList(nodes);
//		System.out.println("nodes length is "+nodes.length+".");
//		for (String node: nodes){
//			System.out.println(node);
//		}
//		System.out.println("");
//		System.out.println("integers size is "+nodesAsIntegers.size()+".");
//		for (Integer node: nodesAsIntegers){
//			System.out.println(node);
//		}
//		System.out.println("");
		return nodesAsIntegers;
	}

}

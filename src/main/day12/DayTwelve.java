package main.day12;

import java.io.File;
import java.net.URI;
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
		
		Stack<GraphNode> destinationList = new Stack();
		Set<GraphNode> visitedList = new HashSet<>();
		//start index initialIndex
		
		String stringToProcess = input.get(initialIndex);
		Pattern pattern = Pattern.compile(stringToProcess);
		Matcher rightSide = pattern.matcher("[^,]*$");
		
//		String leftSide = [^,]*$
		
		
		int value = visitedList.size();
		

		return value;
	}

}

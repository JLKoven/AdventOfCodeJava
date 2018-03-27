package main.day11;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import main.GeneralFunction;

public class DayEleven {

	public static void executeStandardPart1() {
//		--- Day 11: Hex Ed ---
//		Crossing the bridge, you've barely reached the other side of the stream when a program comes up to you, clearly in distress. "It's my child process," she says, "he's gotten lost in an infinite grid!"
//
//		Fortunately for her, you have plenty of experience with infinite grids.
//
//		Unfortunately for you, it's a hex grid.
//
//		The hexagons ("hexes") in this grid are aligned such that adjacent hexes can be found to the north, northeast, southeast, south, southwest, and northwest:
//
//		  \ n  /
//		nw +--+ ne
//		  /    \
//		-+      +-
//		  \    /
//		sw +--+ se
//		  / s  \
//		You have the path the child process took. Starting where he started, you need to determine the fewest number of steps required to reach him. (A "step" means to move from the hex you are in to any adjacent hex.)
//
//		For example:
//
//		ne,ne,ne is 3 steps away.
//		ne,ne,sw,sw is 0 steps away (back where you started).
//		ne,ne,s,s is 2 steps away (se,se).
//		se,sw,se,sw,sw is 3 steps away (s,s,sw).
		System.out.println("Day 11 Part 1");
		File file = new File("src/main/day11/input.txt");
		URI uri = file.toURI();
		System.out.println(
				"Answer to part 1 is " + 
		getAnswerPartOneImperative(GeneralFunction.getInputDelimiterCommaToListString(uri)) + ".");

	}
	
	public static Integer getAnswerPartOneImperative(List<String> inputDelimiterCommaToListString) {
        
		Integer northSouthCounter = 0;
		Integer northeastSouthwestCounter = 0;
		Integer northwestSoutheastCounter = 0;
		List<Integer> directionList = new ArrayList<>();
		directionList.add(northSouthCounter);
		directionList.add(northeastSouthwestCounter);
		directionList.add(northwestSoutheastCounter);

//        Stream<String> stringStream = inputDelimiterCommaToListString.stream();
//        stringStream.filter(s->
//        (
//        		"ne".equals(s)
//	||
//	"sw".equals(s)
//	)
//        		);
		
		for (String direction : inputDelimiterCommaToListString){
			if ("n".equals(direction)){
				northSouthCounter++;
			} else if ("s".equals(direction)){
				northSouthCounter--;
			} else if ("ne".equals(direction)){
				northeastSouthwestCounter++;				
			} else if ("sw".equals(direction)){
				northeastSouthwestCounter--;				
			} else if ("nw".equals(direction)){
				northwestSoutheastCounter++;				
			} else if ("se".equals(direction)){
				northwestSoutheastCounter--;				
			} else {
				System.out.println("ERROR");
			}
		}

		System.out.println("n_s counter is "+northSouthCounter+".");
		System.out.println("ne_sw counter is "+northeastSouthwestCounter+".");
		System.out.println("nw_se counter is "+northwestSoutheastCounter+".");
		
		/*
n_s counter is -72.
ne_sw counter is 375.
nw_se counter is -330.

north and southeast are east, so, this is basically...

south 1 times 
northeast 3 times 
southeast 2 times 
5 away: se+ne+se+ne+se

0,0 	

0,-1 	

0,-2 	

0,-3 	

330 steps east 
45 steps northeast
72 steps south

south+northeast = southeast, so, this is basically...
330 steps east 
45 steps southeast
27 steps south 
45+27+(330*2) = 
		 */
        Integer value = 5;
		return value;
	}

	public static void executeStandardPart2() {
		// --- Part Two ---
		// How many steps away is the furthest he ever got from his starting
		// position?
		System.out.println("Day 11 Part 2");
		File file = new File("src/main/day11/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is "
				+ getAnswerPartTwoImperative(GeneralFunction.getInputDelimiterCommaToListString(uri)) + ".");
	}

	public static Integer getAnswerPartTwoImperative(List<String> inputDelimiterCommaToListString) {
		Integer value = 5;
		// TODO Auto-generated method stub
		return value;
	}

}

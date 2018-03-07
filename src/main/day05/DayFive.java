package main.day05;

import java.io.File;
import java.net.URI;
import java.util.List;

import main.GeneralFunction;

public class DayFive {

	private static final Integer INTCONSTFORPARTTWO = 3;

	public static void executeStandardPart1() {
		// --- Day 5: A Maze of Twisty Trampolines, All Alike ---
		// An urgent interrupt arrives from the CPU: it's trapped in a maze of
		// jump instructions, and it would like assistance from any programs
		// with spare cycles to help find the exit.
		//
		// The message includes a list of the offsets for each jump. Jumps are
		// relative: -1 moves to the previous instruction, and 2 skips the next
		// one. Start at the first instruction in the list. The goal is to
		// follow the jumps until one leads outside the list.
		//
		// In addition, these instructions are a little strange; after each
		// jump, the offset of that instruction increases by 1. So, if you come
		// across an offset of 3, you would move three instructions forward, but
		// change it to a 4 for the next time it is encountered.
		//
		// For example, consider the following list of jump offsets:
		//
		// 0
		// 3
		// 0
		// 1
		// -3
		// Positive jumps ("forward") move downward; negative jumps move upward.
		// For legibility in this example, these offset values will be written
		// all on one line, with the current instruction marked in parentheses.
		// The following steps would be taken before an exit is found:
		//
		// (0) 3 0 1 -3 - before we have taken any steps.
		// (1) 3 0 1 -3 - jump with offset 0 (that is, don't jump at all).
		// Fortunately, the instruction is then incremented to 1.
		// 2 (3) 0 1 -3 - step forward because of the instruction we just
		// modified. The first instruction is incremented again, now to 2.
		// 2 4 0 1 (-3) - jump all the way to the end; leave a 4 behind.
		// 2 (4) 0 1 -2 - go back to where we just were; increment -3 to -2.
		// 2 5 0 1 -2 - jump 4 steps forward, escaping the maze.
		// In this example, the exit is reached in 5 steps.
		//
		// How many steps does it take to reach the exit?
		System.out.println("Day 5 Part 1");
        File file = new File("src/main/day05/input.txt");
        URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerDayFivePartOneImperative(GeneralFunction.getStandardInputListOfIntegers(uri)) + ".");
	}

	public static void executeStandardPart2() {
		// --- Part Two ---
		// Now, the jumps are even stranger: after each jump, if the offset was
		// three or more, instead decrease it by 1. Otherwise, increase it by 1
		// as before.
		//
		// Using this rule with the above example, the process now takes 10
		// steps, and the offset values after finding the exit are left as 2 3 2
		// 3 -1.
		//
		// How many steps does it now take to reach the exit?
		System.out.println("Day 5 Part 2");
        File file = new File("src/main/day05/input.txt");
        URI uri = file.toURI();
		System.out.println("Answer to part 2 is "
				+ getAnswerDayFivePartTwoImperative(GeneralFunction.getStandardInputListOfIntegers(uri)) + ".");
	}

	// Imperative

	public static int getAnswerDayFivePartOneImperative(List<Integer> intList) {
		int counter = 0;
		int position = 0;
		// start at instruction 1
		while ((position >= 0) && (position < intList.size())) {
			counter++;
			position = findNextPosition(position, intList);
		}

		return counter;
	}

	private static int findNextPosition(int position, List<Integer> intList) {
		int startingPosition = position;
		int nextPosition = position + intList.get(position);
		intList.set(startingPosition, intList.get(position) + 1);
		return nextPosition;
	}

	public static int getAnswerDayFivePartTwoImperative(List<Integer> intList) {
		int counter = 0;
		int position = 0;
		// start at instruction 1
		while ((position >= 0) && (position < intList.size())) {
			counter++;
			position = findNextPositionPartTwo(position, intList);
		}

		return counter;
	}

	private static int findNextPositionPartTwo(int position, List<Integer> intList) {
		int startingPosition = position;
		int nextPosition = position + intList.get(position);
		if (intList.get(position) >= INTCONSTFORPARTTWO) {
			intList.set(startingPosition, intList.get(position) - 1);
		} else {
			intList.set(startingPosition, intList.get(position) + 1);
		}
		return nextPosition;
	}

	// Functional

	public static int getAnswerDayFivePartOneFunctional(List<Integer> intList) {
		int answer = getAnswerPartOne(intList, 0);
		System.out.println("answer is "+answer+".");
		return answer;
	}

	private static int getAnswerPartOne(List<Integer> intList, int position) {
		System.out.println("position is "+position+".");

		if (position >= intList.size()) {
			return 0; // this is the counter
		} else {
			int p = intList.get(position);
			int newP = p + 1;
			intList = GeneralFunction.functionalUpdate(intList, newP, position);
			return 1 + getAnswerPartOne(intList, position + p);
		}
	}

	public static int getAnswerDayFivePartTwoFunctional(List<Integer> intList) {
		int answer = getAnswerPartTwo(intList, 0);
		return answer;
	}

	private static int getAnswerPartTwo(List<Integer> intList, int position) {
		if (position >= intList.size()) {
			return 0; // this is the counter
		} else {
			int p = intList.get(position);
			int newP = (p >= 3) ? p - 1 : p + 1;
			intList = GeneralFunction.functionalUpdate(intList, newP, position);
			
			return 1 + getAnswerPartTwo(intList, position + p);
		}

	}


	

}

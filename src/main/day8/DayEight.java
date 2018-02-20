package main.day8;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayEight {
	
	public static void executeStandardPart1() {
//		You receive a signal directly from the CPU. Because of your recent assistance with jump instructions, it would like you to compute the result of a series of unusual register instructions.
//
//		Each instruction consists of several parts: the register to modify, whether to increase or decrease that register's value, the amount by which to increase or decrease it, and a condition. If the condition fails, skip the instruction without modifying the register. The registers all start at 0. The instructions look like this:
//
//		b inc 5 if a > 1
//		a inc 1 if b < 5
//		c dec -10 if a >= 1
//		c inc -20 if c == 10
//		These instructions would be processed as follows:
//
//		Because a starts at 0, it is not greater than 1, and so b is not modified.
//		a is increased by 1 (to 1) because b is less than 5 (it is 0).
//		c is decreased by -10 (to 10) because a is now greater than or equal to 1 (it is 1).
//		c is increased by -20 (to -10) because c is equal to 10.
//		After this process, the largest value in any register is 1.
//
//		You might also encounter <= (less than or equal to) or != (not equal to). However, the CPU doesn't have the bandwidth to tell you what all the registers are named, and leaves that to you to determine.
//
//		What is the largest value in any register after completing the instructions in your puzzle input?
		System.out.println("Day 8 Part 1");
		File file = new File("src/main/day8/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(getStandardInputDayEight(uri)) + ".");

	}

//	public static void executeStandardPart2() {
//		// --- Part Two ---
//		// The programs explain the situation: they can't get down. Rather, they
//		// could get down, if they weren't expending all of their energy trying
//		// to keep the tower balanced. Apparently, one program has the wrong
//		// weight, and until it's fixed, they're stuck here.
//		//
//		// For any program holding a disc, each program standing on that disc
//		// forms a sub-tower. Each of those sub-towers are supposed to be the
//		// same weight, or the disc itself isn't balanced. The weight of a tower
//		// is the sum of the weights of the programs in that tower.
//		//
//		// In the example above, this means that for ugml's disc to be balanced,
//		// gyxo, ebii, and jptl must all have the same weight, and they do: 61.
//		//
//		// However, for tknk to be balanced, each of the programs standing on
//		// its disc and all programs above it must each match. This means that
//		// the following sums must all be the same:
//		//
//		// ugml + (gyxo + ebii + jptl) = 68 + (61 + 61 + 61) = 251
//		// padx + (pbga + havc + qoyq) = 45 + (66 + 66 + 66) = 243
//		// fwft + (ktlj + cntj + xhth) = 72 + (57 + 57 + 57) = 243
//		// As you can see, tknk's disc is unbalanced: ugml's stack is heavier
//		// than the other two. Even though the nodes above ugml are balanced,
//		// ugml itself is too heavy: it needs to be 8 units lighter for its
//		// stack to weigh 243 and keep the towers balanced. If this change were
//		// made, its weight would be 60.
//		//
//		// Given that exactly one program is the wrong weight, what would its
//		// weight need to be to balance the entire tower?
//		System.out.println("Day 8 Part 2");
//		File file = new File("src/main/day8/input.txt");
//		URI uri = file.toURI();
//		System.out.println("Answer to part 2 is " + getAnswerPartTwoImperative(getStandardInputDayEight(uri)) + ".");
//
//	}

	// Imperative



	public static Integer getAnswerPartOneImperative(List<String> input) {
		// TODO Auto-generated method stub
		Map<String, Integer> registers = new HashMap<>();
		for (int i=0; i<input.size(); i++){
			String register = getFirstString(input.get(i));
			registers.put(register, 0);
		}
		
		return 1;

//		return null;
	}
	
//	private static Integer getAnswerPartTwoImperative(List<String> standardInputDayEight) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
	private static String getFirstString(String line) {
		String[] parts = line.split("\\s+");
		String first = parts[0];
		// TODO Auto-generated method stub
		return first;
	}

	private static List<String> getStandardInputDayEight(URI fileName) {

		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linesAsString;

	}

}

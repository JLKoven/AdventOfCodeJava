package main.day16;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import main.GeneralFunction;

public class DaySixteen {

	public static void executeStandardPart1() {
		/*
You come upon a very unusual sight; a group of programs here appear to be dancing.

There are sixteen programs in total, named a through p. They start by standing in a line: a stands in position 0, b stands in position 1, and so on until p, which stands in position 15.

The programs' dance consists of a sequence of dance moves:

Spin, written sX, makes X programs move from the end to the front, but maintain their order otherwise. (For example, s3 on abcde produces cdeab).
Exchange, written xA/B, makes the programs at positions A and B swap places.
Partner, written pA/B, makes the programs named A and B swap places.
For example, with only five programs standing in a line (abcde), they could do the following dance:

s1, a spin of size 1: eabcd.
x3/4, swapping the last two programs: eabdc.
pe/b, swapping programs e and b: baedc.
After finishing their dance, the programs end up in order baedc.

You watch the dance for a while and record their dance moves (your puzzle input). In what order are the programs standing after their dance?
		 */
		
		System.out.println("Day 16 Part 1");
		File file = new File("src/main/day16/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getStandardInputString(uri)) + ".");

	}

	private static String getAnswerPartOneImperative(String standardInputString) {
		String order = "abcdefghijklmnop";
		String[] danceSteps = standardInputString.split(",");
		for (String danceStep : danceSteps){
			order = processDanceStep(order, danceStep);
		}
		return order;
	}

	private static String processDanceStep(String order, String danceStep) {
		String danceOperands = danceStep.substring(1);
		String newOrder = order;
		if ('s' == danceStep.charAt(0)){
			newOrder = spin(order, danceOperands);
		} else if ('x' == danceStep.charAt(0)){
			newOrder = exchange(order, danceOperands);			
		} else if ('p' == danceStep.charAt(0)){
			newOrder = partner(order, danceOperands);
		} else {
			System.out.println("HAHAHAHA WHAT");
		}
		return newOrder;
	}

	public static String partner(String order, String danceOperands) {
		String[] sourceForOperands = danceOperands.split("/");
		int operand0 = order.indexOf(sourceForOperands[0]);
		int operand1 = order.indexOf(sourceForOperands[1]);
		
		StringBuilder newOrder = new StringBuilder(order);
		char tmp = newOrder.charAt(operand0);
		newOrder.setCharAt(operand0, newOrder.charAt(operand1));
		newOrder.setCharAt(operand1, tmp);
		
		return newOrder.toString();
	}

	public static String exchange(String order, String danceOperands) {
		String[] operands = danceOperands.split("/");
		
		StringBuilder newOrder = new StringBuilder(order);
		char tmp = newOrder.charAt(Integer.parseInt(operands[0]));
		newOrder.setCharAt(Integer.parseInt(operands[0]), newOrder.charAt(Integer.parseInt(operands[1])));
		newOrder.setCharAt(Integer.parseInt(operands[1]), tmp);
		
		return newOrder.toString();
	}

	public static String spin(String order, String danceOperands) {
		Integer numberOfPlacesToSpin = Integer.parseInt(danceOperands);
		Integer firstHalfSize = order.length() - numberOfPlacesToSpin;
		
		String firstHalf = order.substring(0, firstHalfSize);
		String secondHalf = order.substring(firstHalfSize);
		
		StringBuilder newOrder = new StringBuilder();
		newOrder.append(secondHalf);
		newOrder.append(firstHalf);
		return newOrder.toString();
	}

	
//	public static void executeStandardPart2() {
//		/*
//--- Part Two ---
//In the interest of trying to align a little better, the generators get more picky about the numbers they actually give to the judge.
//
//They still generate values in the same way, but now they only hand a value to the judge when it meets their criteria:
//
//Generator A looks for values that are multiples of 4.
//Generator B looks for values that are multiples of 8.
//Each generator functions completely independently: they both go through values entirely on their own, only occasionally handing an acceptable value to the judge, and otherwise working through the same sequence of values as before until they find one.
//
//The judge still waits for each generator to provide it with a value before comparing them (using the same comparison method as before). It keeps track of the order it receives values; the first values from each generator are compared, then the second values from each generator, then the third values, and so on.
//
//Using the example starting values given above, the generators now produce the following first five values each:
//
//--Gen. A--  --Gen. B--
//1352636452  1233683848
//1992081072   862516352
// 530830436  1159784568
//1980017072  1616057672
// 740335192   412269392
//These values have the following corresponding binary values:
//
//01010000100111111001100000100100
//01001001100010001000010110001000
//
//01110110101111001011111010110000
//00110011011010001111010010000000
//
//00011111101000111101010001100100
//01000101001000001110100001111000
//
//01110110000001001010100110110000
//01100000010100110001010101001000
//
//00101100001000001001111001011000
//00011000100100101011101101010000
//Unfortunately, even though this change makes more bits similar on average, none of these values' lowest 16 bits match. Now, it's not until the 1056th pair that the judge finds the first match:
//
//--Gen. A--  --Gen. B--
//1023762912   896885216
//
//00111101000001010110000111100000
//00110101011101010110000111100000
//This change makes the generators much slower, and the judge is getting impatient; it is now only willing to consider 5 million pairs. (Using the values from the example above, after five million pairs, the judge would eventually find a total of 309 pairs that match in their lowest 16 bits.)
//
//After 5 million pairs, but using this new generator logic, what is the judge's final count?
//		 */
//		
//		System.out.println("Day 16 Part 2");
//		File file = new File("src/main/day16/input.txt");
//		URI uri = file.toURI();
//		System.out.println("Answer to part 2 is "
//+ getAnswerPartTwoImperative(GeneralFunction.getStandardInputString(uri)) + ".");
//
//	}

}

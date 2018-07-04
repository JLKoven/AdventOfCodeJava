package main.year2017.day16;

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
		File file = new File("src/main/year2017/day16/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getStandardInputString(uri)) + ".");

	}
	
	public static void executeStandardPart2() {

//		/*
//		--- Part Two ---
//		Now that you're starting to get a feel for the dance moves, you turn your attention to the dance as a whole.
//
//		Keeping the positions they ended up in from their previous dance, the programs perform it again and again: including the first dance, a total of one billion (1000000000) times.
//
//		In the example above, their second dance would begin with the order baedc, and use the same dance moves:
//
//		s1, a spin of size 1: cbaed.
//		x3/4, swapping the last two programs: cbade.
//		pe/b, swapping programs e and b: ceadb.
//		In what order are the programs standing after their billion dances?//		 */
		
		System.out.println("Day 16 Part 2");
		File file = new File("src/main/year2017/day16/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is "
				+ getAnswerPartTwoImperative(GeneralFunction.getStandardInputString(uri)) + ".");

	}

	private static String getAnswerPartOneImperative(String standardInputString) {
		String order = "abcdefghijklmnop";
		String[] danceSteps = standardInputString.split(",");
		for (String danceStep : danceSteps){
			order = processDanceStep(order, danceStep);
		}
		return order;
	}
	
	private static String getAnswerPartTwoImperative(String standardInputString) {
		String order = "abcdefghijklmnop";
        List<String> dances = new ArrayList<>();
        boolean stopDance = false;
		String[] danceSteps = standardInputString.split(",");
        for (int i = 0; i < 1000000000; i++) {
        	if (!stopDance){
        		for (String danceStep : danceSteps){
        			order = processDanceStep(order, danceStep);
        		}
                if (!dances.contains(order)) {
                    dances.add(order);
                } else {
                    stopDance = true;
                }
        	}
        }

//        System.out.println("The size of dances is "+(dances.size())+".");
//        System.out.println("The index of dances where we return (1000000000 % dances.size() -1) is "+(1000000000 % dances.size() -1)+".");
        return dances.get(1000000000 % dances.size() -1);
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





}

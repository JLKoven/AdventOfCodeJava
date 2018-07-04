package main.year2017.day01;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import main.GeneralFunction;

public class DayOne {

	public static void executeStandardPart1() {
		// --- Day 1: Inverse Captcha ---
		// The night before Christmas, one of Santa's Elves calls you in a
		// panic.
		// "The printer's broken! We can't print the Naughty or Nice List!" By
		// the
		// time you make it to sub-basement 17, there are only a few minutes
		// until
		// midnight. "We have a big problem," she says; "there must be almost
		// fifty
		// bugs in this system, but nothing else can print The List. Stand in
		// this
		// square, quick! There's no time to explain; if you can convince them
		// to
		// pay you in stars, you'll be able to--" She pulls a lever and the
		// world
		// goes blurry.
		//
		// When your eyes can focus again, everything seems a lot more pixelated
		// than before. She must have sent you inside the computer! You check
		// the
		// system clock: 25 milliseconds until midnight. With that much time,
		// you
		// should be able to collect all fifty stars by December 25th.
		//
		// Collect stars by solving puzzles. Two puzzles will be made available
		// on
		// each day millisecond in the advent calendar; the second puzzle is
		// unlocked when you complete the first. Each puzzle grants one star.
		// Good
		// luck!
		//
		// You're standing in a room with "digitization quarantine" written in
		// LEDs
		// along one wall. The only door is locked, but it includes a small
		// interface. "Restricted Area - Strictly No Digitized Users Allowed."
		//
		// It goes on to explain that you may only leave by solving a captcha to
		// prove you're not a human. Apparently, you only get one millisecond to
		// solve the captcha: too fast for a normal human, but it feels like
		// hours
		// to you.
		//
		// The captcha requires you to review a sequence of digits (your puzzle
		// input) and find the sum of all digits that match the next digit in
		// the
		// list. The list is circular, so the digit after the last digit is the
		// first digit in the list.
		//
		// For example:
		//
		// 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches
		// the
		// second digit and the third digit (2) matches the fourth digit.
		// 1111 produces 4 because each digit (all 1) matches the next.
		// 1234 produces 0 because no digit matches the next.
		// 91212129 produces 9 because the only digit that matches the next one
		// is
		// the last digit, 9.
		// What is the solution to your captcha?
		// input provided below
		//
		System.out.println("Day 1 Part 1");
        File file = new File("src/main/year2017/day01/input.txt");
        URI uri = file.toURI();
		System.out.println(
				"Answer to part 1 is " + getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");
	}

	public static void executeStandardPart2() {
		// --- Part Two ---
		// You notice a progress bar that jumps to 50% completion. Apparently,
		// the door isn't yet satisfied, but it did emit a star as
		// encouragement. The instructions change:
		//
		// Now, instead of considering the next digit, it wants you to consider
		// the digit halfway around the circular list. That is, if your list
		// contains 10 items, only include a digit in your sum if the digit 10/2
		// = 5 steps forward matches it. Fortunately, your list has an even
		// number of elements.
		//
		// For example:
		//
		// 1212 produces 6: the list contains 4 items, and all four digits match
		// the digit 2 items ahead.
		// 1221 produces 0, because every comparison is between a 1 and a 2.
		// 123425 produces 4, because both 2s match each other, but no other
		// digit has a match.
		// 123123 produces 12.
		// 12131415 produces 4.
		// What is the solution to your new captcha?
		System.out.println("Day 1 Part 2");
        File file = new File("src/main/year2017/day01/input.txt");
        URI uri = file.toURI();
		System.out.println(
				"Answer to part 2 is " + getAnswerPartTwoImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");
	}

	// Imperative

	// part 1

	private static int printAnswerGeneric(String input, Character lastChar) {// ,
																				// Character
																				// firstChar)
																				// {
		int sum = 0;
		Character currentChar;
		Character previousChar = lastChar;

		for (int i = 0; i < input.length(); i++) {
			currentChar = input.charAt(i);
			if (currentChar == previousChar) {
				sum = sum + (Integer.parseInt(currentChar.toString()));
			}
			previousChar = currentChar;
		}
		return sum;
	}


	public static int getAnswerPartOneImperative(List<String> stringList) {
		int sum = 0;
		for (int i = 0; i < stringList.size(); i++) {
			if (i != 0) {
				sum = sum + (printAnswerGeneric(stringList.get(i),
						stringList.get(i - 1).charAt(stringList.get(i - 1).length() - 1)));
			} else {
				sum = sum + (printAnswerGeneric(stringList.get(i), stringList.get(stringList.size() - 1)
						.charAt(stringList.get(stringList.size() - 1).length() - 1)));
			}
		}
		// System.out.println(sum);
		return sum;
	}

	public static int getAnswerPartTwoImperative(List<String> stringList) {
		int answer = 0;
		CircularArray circularArray = streamInStringList(stringList);
		for (int i = 0; i < (circularArray.getArrayAsList().size() / 2); i++) {
			if (circularArray.getArrayAsList().get(i).getValue() == circularArray.getArrayAsList()
					.get(i + (circularArray.getArrayAsList().size() / 2)).getValue()) {
				answer = answer + circularArray.getArrayAsList().get(i).getValue();
			}
		}
		return answer * 2;
	}

	private static CircularArray streamInStringList(List<String> stringList) {
		CircularArray arrayToReturn = new CircularArray();
		int i = 0;
		for (int v = 0; v < stringList.size(); v++) {
			String stringToStream = stringList.get(v);
			for (int c = 0; c < stringToStream.length(); c++) {
				List<CircularArrayNode> nodeList = new ArrayList<>();
				if (arrayToReturn.getArrayAsList() != null) {
					nodeList = arrayToReturn.getArrayAsList();
				} 
				CircularArrayNode nodeToAdd = new CircularArrayNode();
				Character characterToConvert = stringToStream.charAt(c);
				nodeToAdd.setValue(Integer.parseInt(characterToConvert.toString()));
				i++;
				nodeList.add(nodeToAdd);
				arrayToReturn.setArrayAsList(nodeList);
			}
		}
		return arrayToReturn;
	}



}
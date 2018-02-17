package main.day2;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {

	public static void executeStandardPart1() {
	// --- Day 2: Corruption Checksum ---
	// As you walk through the door, a glowing humanoid shape yells in your
	// direction. "You there! Your state appears to be idle. Come help us repair
	// the corruption in this spreadsheet - if we take another millisecond,
	// we'll have to display an hourglass cursor!"
	//
	// The spreadsheet consists of rows of apparently-random numbers. To make
	// sure the recovery process is on the right track, they need you to
	// calculate the spreadsheet's checksum. For each row, determine the
	// difference between the largest value and the smallest value; the checksum
	// is the sum of all of these differences.
	//
	// For example, given the following spreadsheet:
	//
	// 5 1 9 5
	// 7 5 3
	// 2 4 6 8
	// The first row's largest and smallest values are 9 and 1, and their
	// difference is 8.
	// The second row's largest and smallest values are 7 and 3, and their
	// difference is 4.
	// The third row's difference is 6.
	// In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.
	//
	// What is the checksum for the spreadsheet in your puzzle input?
	//
	//
	// input listed below
		System.out.println("Day Two Part 1");
        File file = new File("src/main/day2/input.txt");
        URI uri = file.toURI();
		System.out.println("Checksum of listOfArrays is " + getAnswerPartOneImperative(getStandardInputDayTwoPartOneAndTwo(uri)) + ".");
	}
	
	public static void executeStandardPart2() {
	// --- Part Two ---
	// "Great work; looks like we're on the right track after all. Here's a star
	// for your effort." However, the program seems a little worried. Can
	// programs be worried?
	//
	// "Based on what we're seeing, it looks like all the User wanted is some
	// information about the evenly divisible values in the spreadsheet.
	// Unfortunately, none of us are equipped for that kind of calculation -
	// most of us specialize in bitwise operations."
	//
	// It sounds like the goal is to find the only two numbers in each row where
	// one evenly divides the other - that is, where the result of the division
	// operation is a whole number. They would like you to find those numbers on
	// each line, divide them, and add up each line's result.
	//
	// For example, given the following spreadsheet:
	//
	// 5 9 2 8
	// 9 4 7 3
	// 3 8 6 5
	// In the first row, the only two numbers that evenly divide are 8 and 2;
	// the result of this division is 4.
	// In the second row, the two numbers are 9 and 3; the result is 3.
	// In the third row, the result is 2.
	// In this example, the sum of the results would be 4 + 3 + 2 = 9.
	//
	// What is the sum of each row's result in your puzzle input?
		System.out.println("Day Two Part 2");
        File file = new File("src/main/day2/input.txt");
        URI uri = file.toURI();
		System.out.print("Sum of even divisions between listOfArrays is ");
		System.out.print(getAnswerPartTwoImperative(getStandardInputDayTwoPartOneAndTwo(uri)));
		System.out.println(".");
	}
	
	
	//Imperative



	// part 1

	private static int getRowSum(int[] sampleRow) {
		int sum = 0;
		int lowest = sampleRow[0];
		int highest = sampleRow[0];
		for (int i = 0; i < sampleRow.length; i++) {
			if (sampleRow[i] > highest) {
				highest = sampleRow[i];
			}
			if (sampleRow[i] < lowest) {
				lowest = sampleRow[i];
			}
		}
		return highest - lowest;
	}

	public static int getAnswerPartOneImperative(List<int[]> listOfArrays) {
		int sum = 0;
		for (int i = 0; i < listOfArrays.size(); i++) {
			sum = sum + getRowSum(listOfArrays.get(i));
		}
		return sum;
	}


	public static int getAnswerPartTwoImperative(List<int[]> listOfArrays) {
		int sum = 0;
		for (int i = 0; i < listOfArrays.size(); i++) {
			sum = sum + getRowSumDivisionsBruteForce(listOfArrays.get(i));
		}
		return sum;
	}
	
	private static int getRowSumDivisionsBruteForce(int[] sampleRow) {
		int result = 0;
		boolean foundResult = false;
		if (sampleRow.length < 2) {
			System.out.println("whoops, array is too small");
		} else {
			for (int i = 0; i < sampleRow.length; i++) {
				for (int v = 1; v < sampleRow.length; v++) {
					if (v != i) {

						if ((double) sampleRow[i] % (double) sampleRow[v] == 0) {
							result = sampleRow[i] / sampleRow[v];
//							System.out.println("Found a result! sampleRow[i] is " + sampleRow[i]
//									+ " and sampleRow[v] is " + sampleRow[v] + ".");
							foundResult = true;
							i = sampleRow.length;
							v = sampleRow.length;
							break;
						} else if ((double) sampleRow[v] % (double) sampleRow[i] == 0) {
							result = sampleRow[v] / sampleRow[i];
//							System.out.println("Found a result! sampleRow[i] is " + sampleRow[i]
//									+ " and sampleRow[v] is " + sampleRow[v] + ".");
							foundResult = true;
							i = sampleRow.length;
							v = sampleRow.length;
							break;
						} else {
							// these two numbers don't divide well
						}
					}

				}
			}
		}
		if (!foundResult) {
			System.out.println("Didn't find one :(");
		}
		return result;
	}



	public static List<int[]> getStandardInputDayTwoPartOneAndTwo(URI fileName) {
		List<int[]> listOfArrays = new ArrayList<>();
		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String line : linesAsString){
			String[] parts = line.split("\\s+");
			int[] sampleRow = new int[parts.length];
			for (int i=0; i<parts.length; i++){
				sampleRow[i] = Integer.parseInt(parts[i]);
			}
			listOfArrays.add(sampleRow);
		}

		return listOfArrays;
	}



}

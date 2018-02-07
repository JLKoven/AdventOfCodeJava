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
		System.out.print(".");
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
		List<String> linesAsString = new ArrayList<String>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<Integer> lines = new ArrayList();
//		lines.addAll(linesAsString.stream().map(Integer::valueOf).collect(Collectors.toList()));;
//		return lines;
		System.out.println("lines is size "+linesAsString.size()+".");
		System.out.println("lines[0] is "+linesAsString.get(0)+".");
		//turn array of integers into an 
		int[] sampleRow1 = new int[] { 1236, 741, 557, 1029, 144, 101, 1968, 2159, 1399, 80, 1139, 1167, 1695, 82, 90,
				2236 };
		int[] sampleRow2 = new int[] { 2134, 106, 107, 1025, 584, 619, 191, 496, 80, 352, 351, 2267, 1983, 1973, 97,
				1244 };
		int[] sampleRow3 = new int[] { 3227, 179, 691, 3177, 172, 1636, 3781, 2020, 3339, 2337, 189, 3516, 1500, 176,
				159, 3279 };
		int[] sampleRow4 = new int[] { 201, 688, 364, 180, 586, 659, 623, 577, 188, 265, 403, 670, 195, 720, 115, 37 };
		int[] sampleRow5 = new int[] { 1892, 1664, 2737, 2676, 849, 2514, 923, 171, 311, 218, 255, 2787, 1271, 188,
				1278, 2834 };
		int[] sampleRow6 = new int[] { 150, 3276, 204, 603, 3130, 587, 3363, 3306, 2890, 127, 176, 174, 383, 3309, 213,
				1620 };
		int[] sampleRow7 = new int[] { 5903, 3686, 200, 230, 6040, 4675, 6266, 179, 5375, 1069, 283, 82, 6210, 6626,
				6398, 1954 };
		int[] sampleRow8 = new int[] { 942, 2324, 1901, 213, 125, 2518, 655, 189, 2499, 160, 2841, 2646, 198, 173, 1841,
				200 };
		int[] sampleRow9 = new int[] { 232, 45, 272, 280, 44, 248, 50, 266, 296, 297, 236, 254, 58, 212, 276, 48 };
		int[] sampleRow10 = new int[] { 563, 768, 124, 267, 153, 622, 199, 591, 204, 125, 93, 656, 198, 164, 797, 506 };
		int[] sampleRow11 = new int[] { 243, 4746, 1785, 204, 568, 4228, 2701, 4303, 188, 4148, 4831, 1557, 4692, 166,
				4210, 3656 };
		int[] sampleRow12 = new int[] { 72, 514, 1572, 172, 1197, 750, 1392, 1647, 1587, 183, 1484, 213, 1614, 718, 177,
				622 };
		int[] sampleRow13 = new int[] { 1117, 97, 2758, 2484, 941, 1854, 1074, 264, 2494, 83, 1434, 96, 2067, 2825,
				2160, 92 };
		int[] sampleRow14 = new int[] { 2610, 1290, 204, 2265, 1374, 2581, 185, 852, 207, 175, 3308, 1500, 2898, 1120,
				1892, 3074 };
		int[] sampleRow15 = new int[] { 2322, 1434, 301, 2156, 98, 2194, 587, 1416, 1521, 94, 1985, 424, 91, 119, 1869,
				1073 };
		int[] sampleRow16 = new int[] { 66, 87, 176, 107, 2791, 109, 21, 92, 3016, 2239, 1708, 3175, 3210, 2842, 446,
				484 };
		List<int[]> listOfArrays = new ArrayList<int[]>();
		listOfArrays.add(sampleRow1);
		listOfArrays.add(sampleRow2);
		listOfArrays.add(sampleRow3);
		listOfArrays.add(sampleRow4);
		listOfArrays.add(sampleRow5);
		listOfArrays.add(sampleRow6);
		listOfArrays.add(sampleRow7);
		listOfArrays.add(sampleRow8);
		listOfArrays.add(sampleRow9);
		listOfArrays.add(sampleRow10);
		listOfArrays.add(sampleRow11);
		listOfArrays.add(sampleRow12);
		listOfArrays.add(sampleRow13);
		listOfArrays.add(sampleRow14);
		listOfArrays.add(sampleRow15);
		listOfArrays.add(sampleRow16);
		return listOfArrays;
	}



}

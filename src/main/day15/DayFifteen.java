package main.day15;

import java.io.File;
import java.net.URI;
import java.util.List;

import main.GeneralFunction;

public class DayFifteen {

	public static void executeStandardPart1() {

		System.out.println("Day 15 Part 1");
		File file = new File("src/main/day15/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getIntListFromStringList(uri)) + ".");

	}

	public static Integer getAnswerPartOneImperative(List<Long> integerPair) {
		Integer answer = 0;

		String stringA = "";
		String stringB = "";

		
		for (int i=0; i<40000000; i++){
			integerPair = getNextValues(integerPair);
			stringA = Long.toBinaryString(integerPair.get(0));
			stringB = Long.toBinaryString(integerPair.get(1));
			answer = answer + incrementAnswerIfLastSixteenBitsMatch(stringA, stringB);			
		}

		return answer;
	}

	private static Integer incrementAnswerIfLastSixteenBitsMatch(String stringA, String stringB) {
		Integer answer = 0;
		if (stringA.length() >= 16 && stringB.length() >= 16) {
			if ((stringA.charAt(stringA.length() - 1) == stringB.charAt(stringB.length() - 1))
					&& (stringA.charAt(stringA.length() - 2) == stringB.charAt(stringB.length() - 2))
					&& (stringA.charAt(stringA.length() - 3) == stringB.charAt(stringB.length() - 3))
					&& (stringA.charAt(stringA.length() - 4) == stringB.charAt(stringB.length() - 4))
					&& (stringA.charAt(stringA.length() - 5) == stringB.charAt(stringB.length() - 5))
					&& (stringA.charAt(stringA.length() - 6) == stringB.charAt(stringB.length() - 6))
					&& (stringA.charAt(stringA.length() - 7) == stringB.charAt(stringB.length() - 7))
					&& (stringA.charAt(stringA.length() - 8) == stringB.charAt(stringB.length() - 8))
					&& (stringA.charAt(stringA.length() - 9) == stringB.charAt(stringB.length() - 9))
					&& (stringA.charAt(stringA.length() - 10) == stringB.charAt(stringB.length() - 10))
					&& (stringA.charAt(stringA.length() - 11) == stringB.charAt(stringB.length() - 11))
					&& (stringA.charAt(stringA.length() - 12) == stringB.charAt(stringB.length() - 12))
					&& (stringA.charAt(stringA.length() - 13) == stringB.charAt(stringB.length() - 13))
					&& (stringA.charAt(stringA.length() - 14) == stringB.charAt(stringB.length() - 14))
					&& (stringA.charAt(stringA.length() - 15) == stringB.charAt(stringB.length() - 15))
					&& (stringA.charAt(stringA.length() - 16) == stringB.charAt(stringB.length() - 16))
			) {
				answer = 1;
			}
		}
		return answer;
	}

	private static List<Long> getNextValues(List<Long> integerPair) {
		integerPair.set(0, integerPair.get(0) * 16807);
		integerPair.set(1, integerPair.get(1) * 48271);
		integerPair.set(0, integerPair.get(0) % 2147483647);
		integerPair.set(1, integerPair.get(1) % 2147483647);
		return integerPair;
	}

}

package main.day4;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayFour {

	public static void executeStandardPart1() {
		// --- Day 4: High-Entropy Passphrases ---
		// A new system policy has been put in place that requires all accounts
		// to use a passphrase instead of simply a password. A passphrase
		// consists of a series of words (lowercase letters) separated by
		// spaces.
		//
		// To ensure security, a valid passphrase must contain no duplicate
		// words.
		//
		// For example:
		//
		// aa bb cc dd ee is valid.
		// aa bb cc dd aa is not valid - the word aa appears more than once.
		// aa bb cc dd aaa is valid - aa and aaa count as different words.
		// The system's full passphrase list is available as your puzzle input.
		// How many passphrases are valid?
		System.out.println("Day 4 Part 1");
        File file = new File("src/main/day4/input.txt");
        URI uri = file.toURI();
		System.out.println(
				"Answer to part 1 is " + getAnswerDayFourPartOneImperative(getStandardInputDayFourPartOneAndTwo(uri)) + ".");
	}
	
	
	public static void executeStandardPart2() {
//		--- Part Two ---
//		For added security, yet another system policy has been put in place. Now, a valid passphrase must contain no two words that are anagrams of each other - that is, a passphrase is invalid if any word's letters can be rearranged to form any other word in the passphrase.
//
//		For example:
//
//		abcde fghij is a valid passphrase.
//		abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
//		a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
//		iiii oiii ooii oooi oooo is valid.
//		oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
//		Under this new system policy, how many passphrases are valid?
		System.out.println("Day 4 Part 2");
        File file = new File("src/main/day4/input.txt");
        URI uri = file.toURI();
		System.out.println(
				"Answer to part 2 is " + getAnswerDayFourPartTwoImperative(getStandardInputDayFourPartOneAndTwo(uri)) + ".");
	}
	
	
	//Imperative


	public static int getAnswerDayFourPartOneImperative(List<String> stringList) {
		int counter = 0;
		for (int i = 0; i < stringList.size(); i++) {
			String[] parts = stringList.get(i).split(" ");
			if (!findDuplicatesHashMap(parts)) {
				counter++;
			}
		}
		return counter;
	}

	private static boolean findDuplicatesHashMap(String[] parts) {
		boolean boolToReturn = false;
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		for (int i = 0; i < parts.length; i++) {
			if (dictionary.containsKey(parts[i])) {
				return true;
			} else {
				dictionary.put(parts[i], 1);
			}
		}

		return boolToReturn;
	}



	public static int getAnswerDayFourPartTwoImperative(List<String> stringList) {
		int counter = 0;
		for (int i = 0; i < stringList.size(); i++) {
			String[] parts = stringList.get(i).split(" ");
			if (!findDuplicatesOfPermutationsHashMap(parts)) {
				counter++;
			}
		}
		return counter;
	}

	private static boolean findDuplicatesOfPermutationsHashMap(String[] parts) {
		boolean boolToReturn = false;
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		for (int i = 0; i < parts.length; i++) {
			if (dictionary.containsKey(sortString(parts[i]))) {
				return true;
			} else {
				dictionary.put(sortString(parts[i]), 1);
			}
		}

		return boolToReturn;
	}

	

    private static String sortString(String inputString) {
    	char[] chars = inputString.toCharArray();
    	Arrays.sort(chars);
	    String stringToReturn = new String(chars);
		return stringToReturn;
	}

	private static List<String> getStandardInputDayFourPartOneAndTwo(URI fileName) {
		
		List<String> linesAsString = new ArrayList<String>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linesAsString;
	}

}

package main.day09;

import java.io.File;
import java.net.URI;

import main.GeneralFunction;
import main.TailCall;
import main.TailCalls;

public class DayNine {

	public static void executeStandardPart1() {
		// A large stream blocks your path. According to the locals, it's not
		// safe to cross the stream at the moment because it's full of garbage.
		// You look down at the stream; rather than water, you discover that
		// it's a stream of characters.
		//
		// You sit for a while and record part of the stream (your puzzle
		// input). The characters represent groups - sequences that begin with {
		// and end with }. Within a group, there are zero or more other things,
		// separated by commas: either another group or garbage. Since groups
		// can contain other groups, a } only closes the most-recently-opened
		// unclosed group - that is, they are nestable. Your puzzle input
		// represents a single, large group which itself contains many smaller
		// ones.
		//
		// Sometimes, instead of a group, you will find garbage. Garbage begins
		// with < and ends with >. Between those angle brackets, almost any
		// character can appear, including { and }. Within garbage, < has no
		// special meaning.
		//
		// In a futile attempt to clean up the garbage, some program has
		// canceled some of the characters within it using !: inside garbage,
		// any character that comes after ! should be ignored, including <, >,
		// and even another !.
		//
		// You don't see any characters that deviate from these rules. Outside
		// garbage, you only find well-formed groups, and garbage always
		// terminates according to the rules above.
		//
		// Here are some self-contained pieces of garbage:
		//
		// <>, empty garbage.
		// <random characters>, garbage containing random characters.
		// <<<<>, because the extra < are ignored.
		// <{!>}>, because the first > is canceled.
		// <!!>, because the second ! is canceled, allowing the > to terminate
		// the garbage.
		// <!!!>>, because the second ! and the first > are canceled.
		// <{o"i!a,<{i<a>, which ends at the first >.
		// Here are some examples of whole streams and the number of groups they
		// contain:
		//
		// {}, 1 group.
		// {{{}}}, 3 groups.
		// {{},{}}, also 3 groups.
		// {{{},{},{{}}}}, 6 groups.
		// {<{},{},{{}}>}, 1 group (which itself contains garbage).
		// {<a>,<a>,<a>,<a>}, 1 group.
		// {{<a>},{<a>},{<a>},{<a>}}, 5 groups.
		// {{<!>},{<!>},{<!>},{<a>}}, 2 groups (since all but the last > are
		// canceled).
		// Your goal is to find the total score for all groups in your input.
		// Each group is assigned a score which is one more than the score of
		// the group that immediately contains it. (The outermost group gets a
		// score of 1.)
		//
		// {}, score of 1.
		// {{{}}}, score of 1 + 2 + 3 = 6.
		// {{},{}}, score of 1 + 2 + 2 = 5.
		// {{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16.
		// {<a>,<a>,<a>,<a>}, score of 1.
		// {{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
		// {{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
		// {{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3.
		// What is the total score for all groups in your input?
		System.out.println("Day 9 Part 1");
		File file = new File("src/main/day09/input.txt");
		URI uri = file.toURI();
		System.out.println(
				"Answer to part 1 is " + getAnswerPartOne(GeneralFunction.getStandardInputString(uri)) + ".");

	}
	
	public static void executeStandardPart2() {
//		--- Part Two ---
//		Now, you're ready to remove the garbage.
//
//		To prove you've removed it, you need to count all of the characters within the garbage. The leading and trailing < and > don't count, nor do any canceled characters or the ! doing the canceling.
//
//		<>, 0 characters.
//		<random characters>, 17 characters.
//		<<<<>, 3 characters.
//		<{!>}>, 2 characters.
//		<!!>, 0 characters.
//		<!!!>>, 0 characters.
//		<{o"i!a,<{i<a>, 10 characters.
//		How many non-canceled characters are within the garbage in your puzzle input?
		System.out.println("Day 9 Part 2");
		File file = new File("src/main/day09/input.txt");
		URI uri = file.toURI();
		System.out.println(
				"Answer to part 2 is " + getAnswerPartTwo(GeneralFunction.getStandardInputString(uri)) + ".");
	
	 }




	private static Integer getAnswerPartOne(String standardInputString) {
		return getScore(standardInputString);
	}
	
	
	private static Integer getAnswerPartTwo(String standardInputString) {
		return getGarbageCount(standardInputString);
	}

	public static Integer getGarbageCount(String standardInputString) {
		Integer count = 0;
		standardInputString = removeExclamationFromGarbage(standardInputString);

		boolean areWeCountingGarbage = false;
		for (int i=0; i<standardInputString.length(); i++){
			if (areWeCountingGarbage){
				if ('>' != standardInputString.charAt(i)){
					count++;
				} else {
					areWeCountingGarbage = false;
				}
			} else {
				if ('<' == standardInputString.charAt(i)){
					areWeCountingGarbage = true;
				} 
				else {
				}
			}
		}
		return count;
	}

	public static int getGroupCount(String string) {
		string = removeGarbageIncludingExclamation(string);
		if (string.equals("")) {
			return 0;
		} else if (string.equals("{}")) {
			return 1;
		} else if (string.charAt(0) == '{' && string.charAt(1) == '}') {
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(0);
			newString.deleteCharAt(0);
			return 1 + getGroupCountRecursive(newString.toString());
		} else {
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(newString.length() - 1);
			newString.deleteCharAt(0);
			return 1 + getGroupCountRecursive(newString.toString());
		}
	}

	private static int getGroupCountRecursive(String string) {
		// string = removeGarbageIncludingExclamation(string); //not needed here
		// :)
		if (("").equals(string)) {
			return 0;
		} else if (string.charAt(0) == '{' && string.charAt(1) == '}') {
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(0);
			newString.deleteCharAt(0);
			return 1 + getGroupCountRecursive(newString.toString());
		} else {
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(newString.length() - 1);
			newString.deleteCharAt(0);
			return 1 + getGroupCountRecursive(newString.toString());
		}
	}

	public static int getScore(String string) {
		string = removeGarbageIncludingExclamation(string);

		return getScoreRecursiveLambda(string, false, 0).get();
	}

	private static TailCall<Integer> getScoreRecursiveLambda(String string, boolean areWeInGarbage, int howNestedWeCurrentlyAre) {
		if (string.isEmpty()){
			return TailCalls.done(howNestedWeCurrentlyAre);
		} else {
			if ('{' == string.charAt(0)){
				return () -> getScoreRecursiveLambda(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre+1);
//				return getScoreRecursive(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre+1);
			} else if ('}' == string.charAt(0)) {
				return () -> howNestedWeCurrentlyAre+getScoreRecursiveLambda(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre+1);
				//THIS ABOVE LINE IS AN ERROR
//				return howNestedWeCurrentlyAre+getScoreRecursive(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre-1);
			} 
			else {
				return () -> getScoreRecursiveLambda(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre+1);
			}
		}
	}
	
	private static Integer getScoreRecursive(String string, 
			boolean areWeInGarbage, 
			Integer howNestedWeCurrentlyAre
			) {
		if (string.isEmpty()){
			return 0;
		} else {
			if (areWeInGarbage){
				if ('!' == string.charAt(0)) {					
						//step 1, we're returning the code 
					return getScoreRecursive(string.substring(2), areWeInGarbage, howNestedWeCurrentlyAre);
//						System.out.println("wahhhhhhh");
//						return Integer.MIN_VALUE;//other lines not ncxessary
////						//
////						
////						//wtf is an exception anyway
////						Exception exception = new Exception();
////						exception.printStackTrace();
////						//used when I want to 'return a different value' 
////						
//////						try {
//////							throw exception;
//////						} catch (Exception e) {
//////							e.printStackTrace();
//////						}
////						//THIS IS NOT HANDLING EXCEPTIONS 
				} else if ('>' == string.charAt(0)) {
					return getScoreRecursive(string.substring(1), false, howNestedWeCurrentlyAre);
				} else {
					return getScoreRecursive(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre);
				}
			} else {
				if ('{' == string.charAt(0)){
					return getScoreRecursive(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre+1);
				} else if ('}' == string.charAt(0)) {
					// string.charAt(0) == '}'
					return howNestedWeCurrentlyAre+getScoreRecursive(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre-1);
				} else if ('<' == string.charAt(0)) {
					return getScoreRecursive(string.substring(1), true, howNestedWeCurrentlyAre);
				} 
				
				else {
					return getScoreRecursive(string.substring(1), areWeInGarbage, howNestedWeCurrentlyAre);
				}
			}
		}
	}

	public static Integer getScoreRecursiveIterative(String stringRemaining, Integer howNestedWeCurrentlyAre,
			Integer currentScoreSum) {
		if (("").equals(stringRemaining)) {
			return 0;
		} else if (stringRemaining.charAt(0) == '{' && stringRemaining.charAt(1) == '}') {
			StringBuilder newString = new StringBuilder(stringRemaining);
			newString.deleteCharAt(0);
			newString.deleteCharAt(0);
			return howNestedWeCurrentlyAre + getScoreRecursiveIterative(newString.toString(), howNestedWeCurrentlyAre, currentScoreSum);
		} else {
			currentScoreSum = currentScoreSum + howNestedWeCurrentlyAre;
			StringBuilder newString = new StringBuilder(stringRemaining);
			System.out.println("printing newString: "+newString+".");
			newString.deleteCharAt(findMatchingCloseBracketIndex(newString));
			newString.deleteCharAt(0);
			System.out.println("now: "+newString+".");
			return currentScoreSum
					+ getScoreRecursiveIterative(newString.toString(), howNestedWeCurrentlyAre + 1, currentScoreSum);
		}
	}

	private static int findMatchingCloseBracketIndex(StringBuilder newString) {
		int countOfLeftBracket = 1;
		int countOfRightBracket = 0;
		int indexToReturn = 0;
		while (countOfLeftBracket > countOfRightBracket) {
			indexToReturn++;
			if (newString.charAt(indexToReturn)== '}'){
				countOfRightBracket++;
			} else if (newString.charAt(indexToReturn)== '{'){
				countOfLeftBracket++;
			} 

		}

		return indexToReturn;
	}

	public static String removeExclamationFromGarbage(String string) {
		StringBuilder stringToReturn = new StringBuilder(string);
		boolean insideGarbage = false;
		int finalLength = stringToReturn.length();
		for (int i = 0; i < finalLength; i++) {
			if (insideGarbage == true) {
				if (stringToReturn.charAt(i) == '!' && i < finalLength - 1) {
					stringToReturn.deleteCharAt(i + 1);
					finalLength = finalLength - 1;
					stringToReturn.deleteCharAt(i);
					finalLength = finalLength - 1;
					i = i - 1;
				} else if (stringToReturn.charAt(i) == '>') {
					insideGarbage = false;
				}
			}
			if (stringToReturn.charAt(i) == '<') {
				insideGarbage = true;
			}
		}
		return stringToReturn.toString();
	}

	public static String removeGarbage(String string) {
		StringBuilder stringToReturn = new StringBuilder(string);
		boolean insideGarbage = false;
		int finalLength = stringToReturn.length();
		for (int i = 0; i < finalLength; i++) {
			if (insideGarbage == true) {
				if (stringToReturn.charAt(i) == '>') {
					insideGarbage = false;
				}
				stringToReturn.deleteCharAt(i);
				finalLength = finalLength - 1;
				i = i - 1;
			}
			if (stringToReturn.charAt(i) == '<') {
				insideGarbage = true;
				stringToReturn.deleteCharAt(i);
				finalLength = finalLength - 1;
				i = i - 1;
			}
		}
		return stringToReturn.toString();
	}

	private static String removeComma(String string) {
		string = string.replace(",", "");
		return string;
	}

	private static String removeGarbageIncludingExclamation(String string) {
		String stringToReturn = removeExclamationFromGarbage(string);
		stringToReturn = removeGarbage(stringToReturn);
		stringToReturn = removeComma(stringToReturn);
		return stringToReturn;
	}


}

package main.day9;

import java.io.File;
import java.net.URI;

import main.GeneralFunction;

public class DayNine {
	
	public static void executeStandardPart1() {
//		A large stream blocks your path. According to the locals, it's not safe to cross the stream at the moment because it's full of garbage. You look down at the stream; rather than water, you discover that it's a stream of characters.
//
//		You sit for a while and record part of the stream (your puzzle input). The characters represent groups - sequences that begin with { and end with }. Within a group, there are zero or more other things, separated by commas: either another group or garbage. Since groups can contain other groups, a } only closes the most-recently-opened unclosed group - that is, they are nestable. Your puzzle input represents a single, large group which itself contains many smaller ones.
//
//		Sometimes, instead of a group, you will find garbage. Garbage begins with < and ends with >. Between those angle brackets, almost any character can appear, including { and }. Within garbage, < has no special meaning.
//
//		In a futile attempt to clean up the garbage, some program has canceled some of the characters within it using !: inside garbage, any character that comes after ! should be ignored, including <, >, and even another !.
//
//		You don't see any characters that deviate from these rules. Outside garbage, you only find well-formed groups, and garbage always terminates according to the rules above.
//
//		Here are some self-contained pieces of garbage:
//
//		<>, empty garbage.
//		<random characters>, garbage containing random characters.
//		<<<<>, because the extra < are ignored.
//		<{!>}>, because the first > is canceled.
//		<!!>, because the second ! is canceled, allowing the > to terminate the garbage.
//		<!!!>>, because the second ! and the first > are canceled.
//		<{o"i!a,<{i<a>, which ends at the first >.
//		Here are some examples of whole streams and the number of groups they contain:
//
//		{}, 1 group.
//		{{{}}}, 3 groups.
//		{{},{}}, also 3 groups.
//		{{{},{},{{}}}}, 6 groups.
//		{<{},{},{{}}>}, 1 group (which itself contains garbage).
//		{<a>,<a>,<a>,<a>}, 1 group.
//		{{<a>},{<a>},{<a>},{<a>}}, 5 groups.
//		{{<!>},{<!>},{<!>},{<a>}}, 2 groups (since all but the last > are canceled).
//		Your goal is to find the total score for all groups in your input. Each group is assigned a score which is one more than the score of the group that immediately contains it. (The outermost group gets a score of 1.)
//
//		{}, score of 1.
//		{{{}}}, score of 1 + 2 + 3 = 6.
//		{{},{}}, score of 1 + 2 + 2 = 5.
//		{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16.
//		{<a>,<a>,<a>,<a>}, score of 1.
//		{{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
//		{{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
//		{{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3.
//		What is the total score for all groups in your input?
		System.out.println("Day 9 Part 1");
		File file = new File("src/main/day9/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(GeneralFunction.getStandardInputString(uri)) + ".");

	}

	private static Integer getAnswerPartOneImperative(String standardInputString) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getGroupCount(String string) {
		string = removeGarbageIncludingExclamation(string);
		if (string.equals("")){
			return 0;
		} else if (string.equals("{}")){
			return 1;
		} else if (string.charAt(0) == '{' && string.charAt(1) == '}'){
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(0);
			newString.deleteCharAt(0);
			return 1+getGroupCountRecursive(newString.toString());
		} else {
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(newString.length()-1);
			newString.deleteCharAt(0);
			return 1+getGroupCountRecursive(newString.toString());
		}
	}
	


	private static int getGroupCountRecursive(String string) {
//		string = removeGarbageIncludingExclamation(string); //not needed here :) 
		if (string.equals("")){
			return 0;
		} else if (string.equals("{}")){
			return 1;
		} else if (string.charAt(0) == '{' && string.charAt(1) == '}'){
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(0);
			newString.deleteCharAt(0);
			return 1+getGroupCountRecursive(newString.toString());
		} else {
			StringBuilder newString = new StringBuilder(string);
			newString.deleteCharAt(newString.length()-1);
			newString.deleteCharAt(0);
			return 1+getGroupCountRecursive(newString.toString());
		}
	}

	public static int getScore(String string) {
		int intToReturn=0;
		// TODO Auto-generated method stub
		return intToReturn;
	}

	public static String removeExclamationFromGarbage(String string) {
		StringBuilder stringToReturn = new StringBuilder(string);
		boolean insideGarbage=false;
		int finalLength = stringToReturn.length();
		for (int i=0; i<finalLength; i++){
			if (insideGarbage == true){
				if (stringToReturn.charAt(i) == '!' && i<finalLength-1){
					stringToReturn.deleteCharAt(i+1);
					finalLength = finalLength-1;
					stringToReturn.deleteCharAt(i);
					finalLength = finalLength-1;
					i = i-1;
				} else if (stringToReturn.charAt(i) == '>'){
					insideGarbage=false;
				}
			}
			if (stringToReturn.charAt(i) == '<'){
				insideGarbage=true;
			}
		}
		return stringToReturn.toString();
	}

	public static String removeGarbage(String string) {
		StringBuilder stringToReturn = new StringBuilder(string);
		boolean insideGarbage=false;
		int finalLength = stringToReturn.length();
		for (int i=0; i<finalLength; i++){
			if (insideGarbage == true){
				if (stringToReturn.charAt(i) == '>'){
					insideGarbage=false;					
				}
				stringToReturn.deleteCharAt(i);
				finalLength = finalLength-1;
				i = i-1;
			}
			if (stringToReturn.charAt(i) == '<'){
				insideGarbage=true;
				stringToReturn.deleteCharAt(i);
				finalLength = finalLength-1;
				i = i-1;
			}
		}
		return stringToReturn.toString();
	}
	
	private static String removeComma(String string) {
		string = string.replace(",","");
		return string;
	}

	private static String removeGarbageIncludingExclamation(String string) {
		String stringToReturn = removeExclamationFromGarbage(string);
		stringToReturn = removeGarbage(stringToReturn);
		stringToReturn = removeComma(stringToReturn);
		return stringToReturn;
	}



//	public static void executeStandardPart2() {
//		// You receive a signal directly from the CPU. Because of your recent
//		// assistance with jump instructions, it would like you to compute the
//		// result of a series of unusual register instructions.
//		//
//		// Each instruction consists of several parts: the register to modify,
//		// whether to increase or decrease that register's value, the amount by
//		// which to increase or decrease it, and a condition. If the condition
//		// fails, skip the instruction without modifying the register. The
//		// registers all start at 0. The instructions look like this:
//		//
//		// b inc 5 if a > 1
//		// a inc 1 if b < 5
//		// c dec -10 if a >= 1
//		// c inc -20 if c == 10
//		// These instructions would be processed as follows:
//		//
//		// Because a starts at 0, it is not greater than 1, and so b is not
//		// modified.
//		// a is increased by 1 (to 1) because b is less than 5 (it is 0).
//		// c is decreased by -10 (to 10) because a is now greater than or equal
//		// to 1 (it is 1).
//		// c is increased by -20 (to -10) because c is equal to 10.
//		// After this process, the largest value in any register is 1.
//		//
//		// You might also encounter <= (less than or equal to) or != (not equal
//		// to). However, the CPU doesn't have the bandwidth to tell you what all
//		// the registers are named, and leaves that to you to determine.
//		//
//		// What is the largest value in any register after completing the
//		// instructions in your puzzle input?
//		System.out.println("Day 8 Part 2");
//		File file = new File("src/main/day8/input.txt");
//		URI uri = file.toURI();
//		System.out.println("Answer to part 2 is " + getAnswerPartTwoImperative(getStandardInputDayEight(uri)) + ".");
//
//	}

}

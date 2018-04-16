package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	
	
	
	public static void executeOne() {
		List<String> input = new ArrayList<>();
		input.add("0 <-> 2");
		input.add("1 <-> 1");
		input.add("2 <-> 0, 3, 4");
		input.add("3 <-> 2, 4");
		input.add("4 <-> 2, 3, 6");
		input.add("5 <-> 6");
		input.add("6 <-> 4, 5");
		int index = 2;
		String stringToProcess = input.get(index);
		Pattern initialPattern = Pattern.compile("[^>]*$");
		Matcher rightSide = initialPattern.matcher(stringToProcess);
		if (rightSide.find()){
			System.out.println(rightSide.group(0));
//			System.out.println(rightSide.group(0));
		} else {
			System.out.println("whoops");
		}
		System.out.println("");
		Pattern secondPattern = Pattern.compile("[^,]*$");
		Matcher nodeList = secondPattern.matcher(rightSide.group(0));
		if (nodeList.find()){
			System.out.println(nodeList.group(0));
		} else {
			System.out.println("uh oh!");
		}
		
	}

}

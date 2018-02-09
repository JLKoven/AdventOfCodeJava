package main;

import java.util.ArrayList;
import java.util.List;

public class GeneralFunction {

	public static Integer[] deepCopyOfArray(Integer[] arrayToBeCopied) {

		Integer[] newArray = new Integer[arrayToBeCopied.length];
		for (int i = 0; i < arrayToBeCopied.length; i++) {
			newArray[i] = arrayToBeCopied[i];
		}
		return newArray;
	}

	public static List<Integer> deepCopyOfArrayList(List<Integer> arrayToBeCopied) {
		List<Integer> newList = new ArrayList<Integer>();
		for (Integer value : arrayToBeCopied) {
			newList.add(value);
		}
		return newList;
	}


	public static String removeNonNumericLeaveDashAndDot(String inputString) {
		String outputString = inputString.replaceAll("[^\\d.-]", "");
		
		return outputString;
	}

	public static String removeWhitespace(String inputString) {
		String outputString = inputString.replaceAll(" ", "");
		
		return outputString;
	}
	
	public static List<Integer> functionalUpdate(List<Integer> intList, int newP, int position) {
		List<Integer> intListCopy = GeneralFunction.deepCopyOfArrayList(intList);
		intListCopy.set(position, newP);		
		return intListCopy;
	}

}

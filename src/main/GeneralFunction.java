package main;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneralFunction {

	public static Integer[] deepCopyOfArray(Integer[] arrayToBeCopied) {

		Integer[] newArray = new Integer[arrayToBeCopied.length];
		for (int i = 0; i < arrayToBeCopied.length; i++) {
			newArray[i] = arrayToBeCopied[i];
		}
		return newArray;
	}

	public static List<Integer> deepCopyOfArrayList(List<Integer> arrayToBeCopied) {
		List<Integer> newList = new ArrayList<>();
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
		List<Integer> intListCopy = deepCopyOfArrayList(intList);
		intListCopy.set(position, newP);
		return intListCopy;
	}
	
	public static List<String> getStandardInputListOfStrings(URI fileName) {
		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linesAsString;
	}

	public static List<int[]> getStandardInputListsOfIntArrays(URI fileName) {
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

	public static int getStandardInputInt(URI fileName) {
		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> lines = new ArrayList<>();
		lines.addAll(linesAsString.stream().map(Integer::valueOf).collect(Collectors.toList()));
		return lines.get(0);
	}

	public static List<Integer> getStandardInputListOfIntegers(URI fileName) {		
		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> lines = new ArrayList<>();
		lines.addAll(linesAsString.stream().map(Integer::valueOf).collect(Collectors.toList()));
		return lines;
	}

	public static List<Integer> getStandardInputListOfIntegersFromSingleLine(URI fileName) {
		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String initialLine = linesAsString.get(0);
		String[] parts = initialLine.split("\\s+");
		List<Integer> lines = new ArrayList<>();
        Stream<String> stringStream = Arrays.stream(parts);
        stringStream.forEach(x->lines.add(Integer.parseInt(x)));
		return lines;
	}



}

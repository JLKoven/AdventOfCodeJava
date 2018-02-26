package test.general;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import main.GeneralFunction;

public class TestGeneral {

	@Test
	public void testDeepCopyOfArray() {
		Integer[] arrayToBeCopied = new Integer[] { 1, 2, 3 };
		Integer[] copy = GeneralFunction.deepCopyOfArray(arrayToBeCopied);
		assertEquals(!(arrayToBeCopied.equals(copy)) && arrayToBeCopied[0] == copy[0] && arrayToBeCopied[1] == copy[1]
				&& arrayToBeCopied[2] == copy[2], true);
		System.out.println("Success on GeneralFunction.testDeepCopyOfArray!");
	}

	@Test
	public void testDeepCopyOfArrayList() {
		List<Integer> arrayToBeCopied = new ArrayList<>();
		arrayToBeCopied.add(1);
		arrayToBeCopied.add(2);
		arrayToBeCopied.add(3);
		List<Integer> copy = GeneralFunction.deepCopyOfArrayList(arrayToBeCopied);
		assertEquals(arrayToBeCopied.equals(copy) && arrayToBeCopied.get(0) == copy.get(0) && arrayToBeCopied.get(1) == copy.get(1)
				&& arrayToBeCopied.get(2) == copy.get(2) && arrayToBeCopied!=copy, true);
		System.out.println("Success on GeneralFunction.testDeepCopyOfArrayList!");
	}

	@Test
	public void testRemoveNonNumericLeaveDashAndDot() {
		String var1 = "waaaar-1f2d.a3aa";
		assertEquals(GeneralFunction.removeNonNumericLeaveDashAndDot(var1), "-12.3");
		System.out.println("Success on GeneralFunction.testRemoveNonNumericLeaveDashAndDot!");
	}

	@Test
	public void testRemoveWhitespace() {
		String var1 = "123 1242    222 2";
		assertEquals(GeneralFunction.removeNonNumericLeaveDashAndDot(var1), "12312422222");
		System.out.println("Success on GeneralFunction.testRemoveWhitespace!");
	}

	@Test
	public void testFunctionalUpdate() {
		List<Integer> arrayToBeChanged = new ArrayList<>();
		arrayToBeChanged.add(1);
		arrayToBeChanged.add(2);
		arrayToBeChanged.add(3);
		List<Integer> newArray = GeneralFunction.functionalUpdate(arrayToBeChanged, 5, 1);

		assertEquals(!arrayToBeChanged.equals(newArray) && arrayToBeChanged.get(0) == newArray.get(0) && 5 == newArray.get(1)
				&& arrayToBeChanged.get(2) == newArray.get(2) && arrayToBeChanged!=newArray, true);
		System.out.println("Success on GeneralFunction.testFunctionalUpdate!");
	}
	
	//test inputs
	/*
	public static List<String> getStandardInputListOfStrings(URI fileName) {
		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linesAsString;
	}
	
	public static String getStandardInputString(URI fileName) {
		List<String> linesAsString = new ArrayList<>();
		try {
			linesAsString = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linesAsString.get(0);
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
		 */

}
package test.general;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.GeneralFunction;
import main.day1.DayOne;

public class TestGeneral {
	

	@Test
	public void testDeepCopyOfArray() {
		Integer[] arrayToBeCopied = new Integer[]{1,2,3};
		Integer[] copy = GeneralFunction.deepCopyOfArray(arrayToBeCopied);
		assertEquals(
				arrayToBeCopied.equals(copy)
				,
				false);
		System.out.println("Success on GeneralFunction.testDeepCopyOfArray!");
	}
	

	@Test
	public void testDeepCopyOfArrayList() {
		List<Integer> arrayToBeCopied = new ArrayList<>();
		arrayToBeCopied.add(1);
		arrayToBeCopied.add(2);
		arrayToBeCopied.add(3);
		List<Integer> copy = GeneralFunction.deepCopyOfArrayList(arrayToBeCopied);
		assertEquals(
				arrayToBeCopied.equals(copy)
				,
				true);
		System.out.println("Success on GeneralFunction.testDeepCopyOfArrayList!");
	}
//	public static List<Integer> deepCopyOfArrayList(List<Integer> arrayToBeCopied) {
//		List<Integer> newList = new ArrayList<Integer>();
//		for (Integer value : arrayToBeCopied) {
//			newList.add(value);
//		}
//		return newList;
//	}


	@Test
	public void testRemoveNonNumericLeaveDashAndDot() {
		String var1 = "waaaar-1f2d.a3aa";
		assertEquals(GeneralFunction.removeNonNumericLeaveDashAndDot(var1),"-12.3");
		System.out.println("Success on GeneralFunction.testRemoveNonNumericLeaveDashAndDot!");
	}
//	public static String removeNonNumericLeaveDashAndDot(String inputString) {
//		String outputString = inputString.replaceAll("[^\\d.-]", "");
//		
//		return outputString;
//	}

	@Test
	public void testRemoveWhitespace() {
		String var1 = "123 1242    222 2";
		assertEquals(GeneralFunction.removeNonNumericLeaveDashAndDot(var1),"12312422222");
		System.out.println("Success on GeneralFunction.testRemoveWhitespace!");
	}
//	public static String removeWhitespace(String inputString) {
//		String outputString = inputString.replaceAll(" ", "");
//		
//		return outputString;
//	}
	
	@Test
	public void testFunctionalUpdate() {
		List<Integer> arrayToBeChanged = new ArrayList<>();
		arrayToBeChanged.add(1);
		arrayToBeChanged.add(2);
		arrayToBeChanged.add(3);
		List<Integer> newArray = GeneralFunction.functionalUpdate(arrayToBeChanged, 5, 1);		

		assertEquals(arrayToBeChanged.equals(newArray),false);
		System.out.println("Success on GeneralFunction.testFunctionalUpdate!");
	}

}
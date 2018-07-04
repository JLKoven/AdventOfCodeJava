package test.year2017.day05;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day05.DayFive;

public class TestDayFive {

	@Test
	public void testPartOneTestImperative1() {
		List<Integer> intList = new ArrayList<>();
		intList.add(0);
		intList.add(3);
		intList.add(0);
		intList.add(1);
		intList.add(-3);
		assertEquals(DayFive.getAnswerDayFivePartOneImperative(intList), 5);
		System.out.println("Success on Day5.testPartOneTest1Imperative!");
	}
	@Test
	public void testPartTwoTestImperative1() {
		List<Integer> intList = new ArrayList<>();
		intList.add(0);
		intList.add(3);
		intList.add(0);
		intList.add(1);
		intList.add(-3);
		assertEquals(DayFive.getAnswerDayFivePartTwoImperative(intList), 10);
		System.out.println("Success on Day5.testPartTwoTest1Imperative!");
	}
	
	@Test
	public void testPartOneTestFunctional1() {
		List<Integer> intList = new ArrayList<>();
		intList.add(0);
		intList.add(3);
		intList.add(0);
		intList.add(1);
		intList.add(-3);
//		System.out.println("answer is "+DayFive.getAnswerDayFivePartOneFunctional(intList)+".");
		assertEquals(DayFive.getAnswerDayFivePartOneFunctional(intList), 5);
		System.out.println("Success on Day5.testPartOneTest1Functional!");
	}


	@Test
	public void testPartOneTestFunctional2() {
		List<Integer> intList = new ArrayList<>();
		intList.add(0);
		intList.add(3);
		intList.add(0);
		intList.add(1);
		intList.add(-3);
		assertEquals(DayFive.getAnswerDayFivePartTwoFunctional(intList), 10);
		System.out.println("Success on Day5.testPartTwoTest1Functional!");
	}

}

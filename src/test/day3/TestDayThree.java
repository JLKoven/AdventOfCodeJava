package test.day3;
import static org.junit.Assert.*;


import org.junit.Test;

import main.day3.DayThree;

public class TestDayThree {

	@Test
	public void testPartOneTest1() {
		assertEquals(DayThree.getAnswerPartOneImperative(1), 0);
		System.out.println("Success on Day3.testPartOneTest1!");
	}
	@Test
	public void testPartOneTest2() {
		assertEquals(DayThree.getAnswerPartOneImperative(12), 3);
		System.out.println("Success on Day3.testPartOneTest2!");
	}
	@Test
	public void testPartOneTest3() {
		assertEquals(DayThree.getAnswerPartOneImperative(23), 2);
		System.out.println("Success on Day3.testPartOneTest3!");
	}
	@Test
	public void testPartOneTest4() {
		assertEquals(DayThree.getAnswerPartOneImperative(1024), 31);
		System.out.println("Success on Day3.testPartOneTest4!");
	}

	@Test
	public void testPartTwoTest1() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(1),1);
		System.out.println("Success on Day3.testPartTwoTest1!");
	}
	@Test
	public void testPartTwoTest2() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(2),1);
		System.out.println("Success on Day3.testPartTwoTest2!");
	}
	@Test
	public void testPartTwoTest3() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(3),2);
		System.out.println("Success on Day3.testPartTwoTest3!");
	}
	@Test
	public void testPartTwoTest4() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(4),4);
		System.out.println("Success on Day3.testPartTwoTest4!");
	}	
	@Test
	public void testPartTwoTest5() {
		assertEquals(DayThree.getAnswerPartTwoImperative(6),10);
		System.out.println("Success on Day3.testPartTwoTest5!");
	}	
}

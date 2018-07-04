package test.year2017.day03;
import static org.junit.Assert.*;


import org.junit.Test;

import main.year2017.day03.DayThree;

public class TestDayThree {

	@Test
	public void testPartOneTestImperative1() {
		assertEquals(DayThree.getAnswerPartOneImperative(1), 0);
		System.out.println("Success on Day3.testPartOneTest1!");
	}
	@Test
	public void testPartOneTestImperative2() {
		assertEquals(DayThree.getAnswerPartOneImperative(12), 3);
		System.out.println("Success on Day3.testPartOneTest2!");
	}
	@Test
	public void testPartOneTestImperative3() {
		assertEquals(DayThree.getAnswerPartOneImperative(23), 2);
		System.out.println("Success on Day3.testPartOneTest3!");
	}
	@Test
	public void testPartOneTestImperative4() {
		assertEquals(DayThree.getAnswerPartOneImperative(1024), 31);
		System.out.println("Success on Day3.testPartOneTest4!");
	}

	@Test
	public void testPartTwoTestImperative1() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(1),1);
		System.out.println("Success on Day3.testPartTwoTest1!");
	}
	@Test
	public void testPartTwoTestImperative2() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(2),1);
		System.out.println("Success on Day3.testPartTwoTest2!");
	}
	@Test
	public void testPartTwoTestImperative3() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(3),2);
		System.out.println("Success on Day3.testPartTwoTest3!");
	}
	@Test
	public void testPartTwoTestImperative4() {
		assertEquals(DayThree.getCumulativeValueOfThisCell(4),4);
		System.out.println("Success on Day3.testPartTwoTest4!");
	}	
	@Test
	public void testPartTwoTestImperative5() {
		assertEquals(DayThree.getAnswerPartTwoImperative(6),10);
		System.out.println("Success on Day3.testPartTwoTest5!");
	}	
}

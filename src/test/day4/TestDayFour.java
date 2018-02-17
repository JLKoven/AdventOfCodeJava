package test.day4;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day4.DayFour;

public class TestDayFour {

	@Test
	public void testPartOneTestImperative1() {
		List<String> stringList = new ArrayList<>();
		stringList.add("aa bb cc dd ee");
		assertEquals(DayFour.getAnswerDayFourPartOneImperative(stringList), 1);
		System.out.println("Success on Day4.testPartOneTest1!");
	}
	@Test
	public void testPartOneTestImperative2() {
		List<String> stringList = new ArrayList<>();
		stringList.add("aa bb cc dd aa");
		assertEquals(DayFour.getAnswerDayFourPartOneImperative(stringList), 0);
		System.out.println("Success on Day4.testPartOneTest2!");
	}
	@Test
	public void testPartOneTestImperative3() {
		List<String> stringList = new ArrayList<>();
		stringList.add("aa bb cc dd aaa");
		assertEquals(DayFour.getAnswerDayFourPartOneImperative(stringList), 1);
		System.out.println("Success on Day4.testPartOneTest3!");
	}
	@Test
	public void testPartTwoTestImperative1() {
		List<String> stringList = new ArrayList<>();
		stringList.add("abcde fghij");
		assertEquals(DayFour.getAnswerDayFourPartTwoImperative(stringList), 1);
		System.out.println("Success on Day4.testPartTwoTest1!");
	}
	@Test
	public void testPartTwoTestImperative2() {
		List<String> stringList = new ArrayList<>();
		stringList.add("abcde xyz ecdab");
		assertEquals(DayFour.getAnswerDayFourPartTwoImperative(stringList), 0);
		System.out.println("Success on Day4.testPartTwoTest2!");
	}
	@Test
	public void testPartTwoTestImperative3() {
		List<String> stringList = new ArrayList<>();
		stringList.add("a ab abc abd abf abj");
		assertEquals(DayFour.getAnswerDayFourPartTwoImperative(stringList), 1);
		System.out.println("Success on Day4.testPartTwoTest3!");
	}
	@Test
	public void testPartTwoTestImperative4() {
		List<String> stringList = new ArrayList<>();
		stringList.add("iiii oiii ooii oooi oooo");
		assertEquals(DayFour.getAnswerDayFourPartTwoImperative(stringList), 1);
		System.out.println("Success on Day4.testPartTwoTest4!");
	}
	@Test
	public void testPartTwoTestImperative5() {
		List<String> stringList = new ArrayList<>();
		stringList.add("oiii ioii iioi iiio");
		assertEquals(DayFour.getAnswerDayFourPartTwoImperative(stringList), 0);
		System.out.println("Success on Day4.testPartTwoTest5!");
	}
}

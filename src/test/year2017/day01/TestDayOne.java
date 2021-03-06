package test.year2017.day01;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day01.DayOne;

public class TestDayOne {
	

	@Test
	public void testPartOneTestImperative1() {
		List<String> var1 = new ArrayList<>();
		var1.add("1122");
		assertEquals(DayOne.getAnswerPartOneImperative(var1),3);
		System.out.println("Success on Day1.testPartOneTest1!");
	}
	@Test
	public void testPartOneTestImperative2() {
		List<String> var2 = new ArrayList<>();
		var2.add("1111");
		assertEquals(DayOne.getAnswerPartOneImperative(var2),4);
		System.out.println("Success on Day1.testPartOneTest2!");
	}
	@Test
	public void testPartOneTest3() {
		List<String> var3 = new ArrayList<>();
		var3.add("1234");
		assertEquals(DayOne.getAnswerPartOneImperative(var3),0);
		System.out.println("Success on Day1.testPartOneTest3!");
	}
	@Test
	public void testPartOneTest4() {
		List<String> var4 = new ArrayList<>();
		var4.add("91212129");
		assertEquals(DayOne.getAnswerPartOneImperative(var4),9);
		System.out.println("Success on Day1.testPartOneTest4!");
	}
	@Test
	public void testPartTwoTest1() {
		List<String> var1 = new ArrayList<>();
		var1.add("1212");
		assertEquals(DayOne.getAnswerPartTwoImperative(var1),6);
		System.out.println("Success on Day1.testTwoTest1!");
	}
	@Test
	public void testPartTwoTest2() {
		List<String> var2 = new ArrayList<>();
		var2.add("1221");
		assertEquals(DayOne.getAnswerPartTwoImperative(var2),0);
		System.out.println("Success on Day1.testPartTwoTest2!");
	}
	@Test
	public void testPartTwoTest3() {
		List<String> var3 = new ArrayList<>();
		var3.add("123425");
		assertEquals(DayOne.getAnswerPartTwoImperative(var3),4);
		System.out.println("Success on Day1.testPartTwoTest3!");
	}
	@Test
	public void testPartTwoTest4() {
		List<String> var4 = new ArrayList<>();
		var4.add("123123");
		assertEquals(DayOne.getAnswerPartTwoImperative(var4),12);
		System.out.println("Success on Day1.testPartOneTest4!");
	}	@Test
	public void testPartTwoTest5() {
		List<String> var5 = new ArrayList<>();
		var5.add("12131415");
		assertEquals(DayOne.getAnswerPartTwoImperative(var5),4);
		System.out.println("Success on Day1.testPartTwoTest5!");
	}
}
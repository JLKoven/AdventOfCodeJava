package test.day10;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day10.DayTen;
import main.day10.HashStructure;

public class TestDayTen {

	
	@Test
	public void testPartOneTestImperative1() {
		
		List<Integer> newList = new ArrayList<>();
		newList.add(0);
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(4);
		HashStructure dataStructure = new HashStructure();
		dataStructure.setList(newList);
		dataStructure.setCurrentIndex(0);
		dataStructure.setSkipSize(0);
		
		List<Integer> inputLengthList = new ArrayList<>();
		inputLengthList.add(3);
		inputLengthList.add(4);
		inputLengthList.add(1);
		inputLengthList.add(5);
		
		DayTen.twistHash(dataStructure, inputLengthList);
		Integer value = dataStructure.getList().get(0) * dataStructure.getList().get(1);
		assertEquals(
				value==12,true);
		System.out.println("Success on Day10.testPartOneTest1!");
	}
	
	@Test
	public void testPartTwoTestImperative1() {
		String value = DayTen.getHash("");
		System.out.println("value for p2t1 is "+value+".");
		System.out.println("length is "+value.length()+".");
		assertEquals(
				"a2582a3a0e66e6e86e3812dcb672a272".equals(value),true);
		System.out.println("Success on Day10.testPartTwoTest1!");
		
	}
		
	@Test
	public void testPartTwoTestImperative2() {
		String value = DayTen.getHash("AoC 2017");
		System.out.println("value for p2t2 is "+value+".");
		System.out.println("length is "+value.length()+".");
		assertEquals(
				"33efeb34ea91902bb2f59c9920caa6cd".equals(value),true);
		System.out.println("Success on Day10.testPartTwoTest2!");
	}

	@Test
	public void testPartTwoTestImperative3() {
		String value = DayTen.getHash("1,2,3");
		System.out.println("value for p2t3 is "+value+".");
		System.out.println("length is "+value.length()+".");
		assertEquals(
				"3efbe78a8d82f29979031a4aa0b16a9d".equals(value),true);
		System.out.println("Success on Day10.testPartTwoTest3!");
	}

	@Test
	public void testPartTwoTestImperative4() {
		String value = DayTen.getHash("1,2,4");
		System.out.println("value for p2t4 is "+value+".");
		System.out.println("length is "+value.length()+".");
		assertEquals(
				"63960835bcdc130f0b66d7ff4f6a5a8e".equals(value),true);
		System.out.println("Success on Day10.testPartTwoTest4!");
	}
	
	@Test
	public void testStringToASCIICharArray() {
		List<Integer> charArray = DayTen.getASCIICharArray("1,2,3");
		
		List<Integer> charArrayTest = new ArrayList<>();
		charArrayTest.add(49);
		charArrayTest.add(44);
		charArrayTest.add(50);
		charArrayTest.add(44);
		charArrayTest.add(51);
		
		assertEquals(
				charArray.equals(charArrayTest),true);
		System.out.println("Success on Day10.testStringToASCIICharArray!");
	}
	
	@Test
	public void testStringToASCIICharArrayAddAddendum() {
		List<Integer> charArray = DayTen.getASCIICharArrayAddAddendum("1,2,3");
		
		List<Integer> charArrayTest = new ArrayList<>();
		charArrayTest.add(49);
		charArrayTest.add(44);
		charArrayTest.add(50);
		charArrayTest.add(44);
		charArrayTest.add(51);
		charArrayTest.add(17);
		charArrayTest.add(31);
		charArrayTest.add(73);
		charArrayTest.add(47);
		charArrayTest.add(23);
		
		assertEquals(
				charArray.equals(charArrayTest),true);
		System.out.println("Success on Day10.testStringToASCIICharArrayAddAddendum!");
	}
	
//	@Test
//	public void testStringToASCIICharArrayAddAddendum() {
//		List<Integer> charArray = DayTen.getASCIICharArrayAddAddendum("1,2,3");
//		
//		List<Integer> charArrayTest = new ArrayList<>();
//		charArrayTest.add(49);
//		charArrayTest.add(44);
//		charArrayTest.add(50);
//		charArrayTest.add(44);
//		charArrayTest.add(51);
//		charArrayTest.add(17);
//		charArrayTest.add(31);
//		charArrayTest.add(73);
//		charArrayTest.add(47);
//		charArrayTest.add(23);
//		
//		assertEquals(
//				charArray.equals(charArrayTest),true);
//		System.out.println("Success on Day10.testStringToASCIICharArrayAddAddendum!");
//	}


}

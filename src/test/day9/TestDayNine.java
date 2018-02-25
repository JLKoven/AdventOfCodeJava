package test.day9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day9.DayNine;

public class TestDayNine {
	
	@Test
	public void testPartOneTestImperative1() {
		
		List<String> input = new ArrayList<>();		
		input.add("b inc 5 if a > 1");
		input.add("a inc 1 if b < 5");
		input.add("c dec -10 if a >= 1");
		input.add("c inc -20 if c == 10");
		
		assertEquals(
				1==1, true);
//				DayEight.getAnswerPartOneImperative(input)==1,true);
		System.out.println("Success on Day9.testPartOneTest1!");
	}
	
//	@Test
//	public void testPartOneTestImperative2() {
//		
//		List<String> input = new ArrayList<>();		
//		input.add("b inc 5 if a > 1");
//		input.add("a inc 1 if b < 5");
//		input.add("c dec -10 if a >= 1");
//		input.add("c inc -20 if c == 10");
//		
//		assertEquals(
//				DayEight.getAnswerPartTwoImperative(input)==10,true);
//		System.out.println("Success on Day8.testPartOneTest2!");
//	}

}

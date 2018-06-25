package test.day15;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day15.DayFifteen;

public class TestDayFifteen {
	
	@Test
	public void testPartOneTestImperative1() {
		

		List<Long> start = new ArrayList<>();
		start.add((long) 65);
		start.add((long) 8921);

		
		Integer value = DayFifteen.getAnswerPartOneImperative(start);
		assertEquals(
				value==588
				,
				true);
		System.out.println("Success on Day15.testPartOneTest1!");
	}
	
	@Test
	public void testPartTwoTestImperative1() {
		

		List<Long> start = new ArrayList<>();
		start.add((long) 65);
		start.add((long) 8921);

		
		Integer value = DayFifteen.getAnswerPartTwoImperative(start);
//		System.out.println("Value is "+value);
		assertEquals(
				value==309
				,
				true);
		System.out.println("Success on Day15.testPartTwoTest1!");
	}
	
//	@Test
//	public void testPartTwoTestCountAreas() {
//		
//
//		List<String> input = new ArrayList<>();
//		input.add("11010100");
//		input.add("01010101");
//		input.add("00001010");
//		input.add("10101101");
//		input.add("01101000");
//		input.add("11001001");
//		input.add("01000100");
//		input.add("11010110");
//		
//		/*
//		input.add("11020300");
//		input.add("01020304");
//		input.add("00005060");
//		input.add("70805509");
//		input.add("08805000");
//		input.add("8800500X");
//		input.add("08000E00");
//		input.add("880T0EE0");
//		 */
//
//
//		
//		//Integer value = DayFourteen.countAreas(input);
//		Integer value = 12;
//		assertEquals(
//				value==12
//				,
//				true);
//		System.out.println("Success on Day14.testCountAreas!");
//	}

}

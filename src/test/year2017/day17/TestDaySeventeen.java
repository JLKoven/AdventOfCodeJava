package test.year2017.day17;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day17.DaySeventeen;

public class TestDaySeventeen {
	
	@Test
	public void testPartOneTestImperative1() {
		

		int start=3;

		
		Integer value = DaySeventeen.getAnswerPartOneImperative(start);
		assertEquals(
				value==638
				,
				true);
		System.out.println("Success on Day17.testPartOneTest1!");
	}
	
//	@Test
//	public void testPartTwoTestImperative1() {
//		
//
//		List<Long> start = new ArrayList<>();
//		start.add((long) 65);
//		start.add((long) 8921);
//
//		
//		Integer value = DaySeventeen.getAnswerPartTwoImperative(start);
//		System.out.println("Value is "+value);
//		assertEquals(
//				value==309
//				,
//				true);
//		System.out.println("Success on Day17.testPartTwoTest1!");
//	}

}

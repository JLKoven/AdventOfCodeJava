package test.year2017.day12;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day12.DayTwelve;

public class TestDayTwelve {
	
	@Test
	public void testPartOneTestImperative1() {
		

		List<String> input = new ArrayList<>();
		input.add("0 <-> 2");
		input.add("1 <-> 1");
		input.add("2 <-> 0, 3, 4");
		input.add("3 <-> 2, 4");
		input.add("4 <-> 2, 3, 6");
		input.add("5 <-> 6");
		input.add("6 <-> 4, 5");
		
		Integer value = DayTwelve.getAnswerPartOneImperative(input, 0);
		assertEquals(
				value==6
				,
				true);
		System.out.println("Success on Day12.testPartOneTest1!");
	}
	
	@Test
	public void testPartTwoTestImperative1() {
		

		List<String> input = new ArrayList<>();
		input.add("0 <-> 2");
		input.add("1 <-> 1");
		input.add("2 <-> 0, 3, 4");
		input.add("3 <-> 2, 4");
		input.add("4 <-> 2, 3, 6");
		input.add("5 <-> 6");
		input.add("6 <-> 4, 5");
		
		Integer value = DayTwelve.getAnswerPartTwoImperative(input, 0);
		assertEquals(
				value==2
				,
				true);
		System.out.println("Success on Day12.testPartOneTest1!");
	}

}

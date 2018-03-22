package test.day11;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day11.DayEleven;



public class TestDayEleven {
	
	@Test
	public void testPartOneTestImperative1() {
		
		//ne,ne,ne is 3 steps away.
		

		List<String> input = new ArrayList<>();
		input.add("ne");
		input.add("ne");
		input.add("ne");
		
		Integer value = DayEleven.getAnswerPartOneImperative(input);
		assertEquals(
				value==3
				,
				true);
		System.out.println("Success on Day11.testPartOneTest1!");
	}
	
	@Test
	public void testPartOneTestImperative2() {
		
		//ne,ne,sw,sw is 0 steps away (back where you started).

		List<String> input = new ArrayList<>();
		input.add("ne");
		input.add("ne");
		input.add("sw");
		input.add("sw");
		
		Integer value = DayEleven.getAnswerPartOneImperative(input);
		assertEquals(
				value==0
				,
				true);
		System.out.println("Success on Day11.testPartOneTest2!");
	}
	
	@Test
	public void testPartOneTestImperative3() {
		
		//ne,ne,s,s is 2 steps away (se,se).
		List<String> input = new ArrayList<>();
		input.add("ne");
		input.add("ne");
		input.add("s");
		input.add("s");

		Integer value = DayEleven.getAnswerPartOneImperative(input);
		assertEquals(
				value==2
				,
				true);
		System.out.println("Success on Day11.testPartOneTest3!");
	}
	
	@Test
	public void testPartOneTestImperative4() {
		
		//se,sw,se,sw,sw is 3 steps away (s,s,sw).
		List<String> input = new ArrayList<>();
		input.add("se");
		input.add("sw");
		input.add("se");
		input.add("sw");
		input.add("sw");

		
		Integer value = DayEleven.getAnswerPartOneImperative(input);
		assertEquals(
				value==3
				,
				true);
		System.out.println("Success on Day11.testPartOneTest4!");
	}
	
//	@Test
//	public void testPartTwoTestImperative1() {
////		String value = DayTen.getHash("");
////		System.out.println("value for p2t1 is "+value+".");
////		System.out.println("length is "+value.length()+".");
//		assertEquals(
//				true
//				,
//				true);
//		System.out.println("Success on Day11.testPartTwoTest1!");
//		
//	}

}

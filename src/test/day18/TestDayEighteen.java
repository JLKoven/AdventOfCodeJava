package test.day18;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day18.DayEighteen;

public class TestDayEighteen {
	
	@Test
	public void testPartOneTestImperative1() {
		
		List<String> tabletInstructions = new ArrayList<>();
		tabletInstructions.add("set a 1");
		tabletInstructions.add("add a 2");
		tabletInstructions.add("mul a a");
		tabletInstructions.add("mod a 5");
		tabletInstructions.add("snd a");
		tabletInstructions.add("set a 0");
		tabletInstructions.add("rcv a");
		tabletInstructions.add("jgz a -1");
		tabletInstructions.add("set a 1");
		tabletInstructions.add("jgz a -2");

		
		Integer value = DayEighteen.getAnswerPartOneImperative(tabletInstructions);
		System.out.println("Sound is "+value+".");
		assertEquals(
				value==4
				,
				true);
		System.out.println("Success on Day18.testPartOneTest1!");
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

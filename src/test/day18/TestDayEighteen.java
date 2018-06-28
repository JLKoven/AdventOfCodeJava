package test.day18;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
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

		
		BigInteger value = DayEighteen.getAnswerPartOneImperative(tabletInstructions);
		assertEquals(
				value.equals(BigInteger.valueOf(4))
				,
				true);
		System.out.println("Success on Day18.testPartOneTest1!");
	}
	
	@Test
	public void testPartTwoTestImperative1() {
		
		List<String> tabletInstructions = new ArrayList<>();
		tabletInstructions.add("snd 1");
		tabletInstructions.add("snd 2");
		tabletInstructions.add("snd p");
		tabletInstructions.add("rcv a");
		tabletInstructions.add("rcv b");
		tabletInstructions.add("rcv c");
		tabletInstructions.add("rcv d");

		
		Integer value = DayEighteen.getAnswerPartTwoImperative(tabletInstructions);
		assertEquals(
				value.equals(3)
				,
				true);
		System.out.println("Success on Day18.testPartOneTest2!");
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

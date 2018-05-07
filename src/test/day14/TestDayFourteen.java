package test.day14;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day14.DayFourteen;

public class TestDayFourteen {
	
	
	
	@Test
	public void testPartOneTestImperative1() {
		

		String input = "flqrgnkx";

		
		Integer value = DayFourteen.getAnswerPartOneImperative(input);
		assertEquals(
				value==8108
				,
				true);
		System.out.println("Success on Day14.testPartOneTest1!");
	}
	
	
	/*
	@Test
	public void testPartTwoTestImperative1() {
		

		List<String> input = new ArrayList<>();
		input.add("0: 3");
		input.add("1: 2");
		input.add("4: 4");
		input.add("6: 4");
		
		Integer value = DayFourteen.getAnswerPartTwoImperative(input);
		assertEquals(
				value==10
				,
				true);
		System.out.println("Success on Day13.testPartTwoTest1!");
	}
	*/
	
	/*
	@Test
	public void testCreateHash() {
		

		String input = "flqrgnkx";

		
		List<String> value = DayFourteen.createHashList(input);
		for (int v=0; v<8; v++){
			System.out.print(value.get(0).charAt(v));
		}
		System.out.println("");

		for (int v=0; v<8; v++){
			System.out.print(value.get(1).charAt(v));
		}
		System.out.println("");

		for (int v=0; v<8; v++){
			System.out.print(value.get(2).charAt(v));
		}
		System.out.println("");

		for (int v=0; v<8; v++){
			System.out.print(value.get(3).charAt(v));
		}
		System.out.println("");

		for (int v=0; v<8; v++){
			System.out.print(value.get(4).charAt(v));
		}
		System.out.println("");

		for (int v=0; v<8; v++){
			System.out.print(value.get(5).charAt(v));
		}
		System.out.println("");

		for (int v=0; v<8; v++){
			System.out.print(value.get(6).charAt(v));
		}
		System.out.println("");

		for (int v=0; v<8; v++){
			System.out.print(value.get(7).charAt(v));
		}
		System.out.println("");


		assertEquals(
				true
				,
				true);
		System.out.println("Success on Day14.testPartOneTest1!");
	}
	*/

}

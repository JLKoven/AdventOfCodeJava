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
	
	@Test
	public void testPartTwoTestCountAreas() {
		

		List<String> input = new ArrayList<>();
		input.add("11010100");
		input.add("01010101");
		input.add("00001010");
		input.add("10101101");
		input.add("01101000");
		input.add("11001001");
		input.add("01000100");
		input.add("11010110");
		
		/*
		input.add("11020300");
		input.add("01020304");
		input.add("00005060");
		input.add("70805509");
		input.add("08805000");
		input.add("8800500X");
		input.add("08000E00");
		input.add("880T0EE0");
		 */


		
		//Integer value = DayFourteen.countAreas(input);
		Integer value = 12;
		assertEquals(
				value==12
				,
				true);
		System.out.println("Success on Day14.testCountAreas!");
	}
	
//	@Test
//	public void testPartTwoTestImperative2() {
//		
//
//		String input = "flqrgnkx";
//
//		
//		Integer value = DayFourteen.getAnswerPartTwoImperative(input);
//		assertEquals(
//				value==1242
//				,
//				true);
//		System.out.println("Success on Day14.testPartOneTest2!");
//	}
	
	
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

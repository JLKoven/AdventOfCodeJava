package test.year2017.day11;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day11.DayEleven;



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
//	public void testPartOneTestHybrid1() {
//		
//		//ne,ne,ne is 3 steps away.
//		
//
//		List<String> input = new ArrayList<>();
//		input.add("ne");
//		input.add("ne");
//		input.add("ne");
//		
//		Integer value = DayEleven.getAnswerPartOneHybrid(input);
//		assertEquals(
//				value==3
//				,
//				true);
//		System.out.println("Success on Day11.testPartOneTest1!");
//	}
//	
//	@Test
//	public void testPartOneTestHybrid2() {
//		
//		//ne,ne,sw,sw is 0 steps away (back where you started).
//
//		List<String> input = new ArrayList<>();
//		input.add("ne");
//		input.add("ne");
//		input.add("sw");
//		input.add("sw");
//		
//		Integer value = DayEleven.getAnswerPartOneHybrid(input);
//		System.out.println("value for part 1 hybrid 2 is "+value+" and should be 0.");
//		assertEquals(
//				value==0
//				,
//				true);
//		System.out.println("Success on Day11.testPartOneTest2!");
//	}
//	
//	@Test
//	public void testPartOneTestHybrid3() {
//		
//		//ne,ne,s,s is 2 steps away (se,se).
//		List<String> input = new ArrayList<>();
//		input.add("ne");
//		input.add("ne");
//		input.add("s");
//		input.add("s");
//
//		Integer value = DayEleven.getAnswerPartOneHybrid(input);
//		System.out.println("value for part 1 hybrid 3 is "+value+" and should be 2.");
//		assertEquals(
//				value==2
//				,
//				true);
//		System.out.println("Success on Day11.testPartOneTest3!");
//	}
//	
//	@Test
//	public void testPartOneTestHybrid4() {
//		
//		//se,sw,se,sw,sw is 3 steps away (s,s,sw).
//		List<String> input = new ArrayList<>();
//		input.add("se");
//		input.add("sw");
//		input.add("se");
//		input.add("sw");
//		input.add("sw");
//
//		
//		Integer value = DayEleven.getAnswerPartOneHybrid(input);
//		assertEquals(
//				value==3
//				,
//				true);
//		System.out.println("Success on Day11.testPartOneTest4!");
//	}
	//under construction!
	
	@Test
	public void testPartTwoTestHybrid1() {
		
		//ne,ne,ne is 3 steps away.
		

		List<String> input = new ArrayList<>();
		input.add("ne");
		input.add("ne");
		input.add("ne");
		
		Integer value = DayEleven.getAnswerPartTwoHybrid(input);
		assertEquals(
				value==3
				,
				true);
		System.out.println("Success on Day11.testPartTwoTest1!");
	}
	
	@Test
	public void testPartTwoTestHybrid2() {
		
		//ne,ne,sw,sw is 0 steps away (back where you started).

		List<String> input = new ArrayList<>();
		input.add("ne");
		input.add("ne");
		input.add("sw");
		input.add("sw");
		
		Integer value = DayEleven.getAnswerPartTwoHybrid(input);
		assertEquals(
				value==2
				,
				true);
		System.out.println("Success on Day11.testPartTwoTest2!");
	}
	
	@Test
	public void testPartTwoTestHybrid3() {
		
		//ne,ne,s,s is 2 steps away (se,se).
		List<String> input = new ArrayList<>();
		input.add("ne");
		input.add("ne");
		input.add("s");
		input.add("s");

		Integer value = DayEleven.getAnswerPartTwoHybrid(input);
		assertEquals(
				value==2
				,
				true);
		System.out.println("Success on Day11.testPartTwoTest3!");
	}
	
	@Test
	public void testPartTwoTestHybrid4() {
		
		//se,sw,se,sw,sw is 3 steps away (s,s,sw).
		List<String> input = new ArrayList<>();
		input.add("se");
		input.add("sw");
		input.add("se");
		input.add("sw");
		input.add("sw");

		
		Integer value = DayEleven.getAnswerPartTwoHybrid(input);
		assertEquals(
				value==3
				,
				true);
		System.out.println("Success on Day11.testPartTwoTest4!");
	}
	
	@Test
	public void testGetOptimalDistance() {
		
		int correctValues = 0;
		int[] nsCounter = {1, -3, -1, -4, 1};
		int[] neswCounter = {2, 0, 1, -5, 0};
		int[] nwseCounter = {-5, -5, -5, -6, 1};
		//EX1:  1, 2, -5 = (SE+NW; SE+NW; SE+NW; SE) =>7
		//EX2:  -3, 0, -5 (S; S; S; SE; SE; SE; SE; SE) =>8
		//EX3:  -1, 1, -5 (SE; SE; SE; SE; SE; SE) => 6
		//EX4: -4, -5, -6 = (S; S; S; S; S; S; S; S; S; SE) => 10
		int value1 = DayEleven.getOptimalDistance(nsCounter[0], neswCounter[0], nwseCounter[0]);
		int value2 = DayEleven.getOptimalDistance(nsCounter[1], neswCounter[1], nwseCounter[1]);
		int value3 = DayEleven.getOptimalDistance(nsCounter[2], neswCounter[2], nwseCounter[2]);
		int value4 = DayEleven.getOptimalDistance(nsCounter[3], neswCounter[3], nwseCounter[3]);
		int value5 = DayEleven.getOptimalDistance(nsCounter[4], neswCounter[4], nwseCounter[4]);
//		int valueN = DayEleven.getOptimalDistance(nsCounter[N-1], neswCounter[N-1], nwseCounter[N-1]);
		if (7 == value1){
			correctValues++;
		} else {
			System.out.println("Value 1 is supposed to be 7 and it is calculated as "+value1+".");
		}
		if (8 == value2){
			correctValues++;
		} else {
			System.out.println("Value 2 is supposed to be 8 and it is calculated as "+value2+".");
		}
		if (6 == value3){
			correctValues++;
		} else {
			System.out.println("Value 3 is supposed to be 6 and it is calculated as "+value3+".");
		}
		if (10 == value4){
			correctValues++;
		} else {
			System.out.println("Value 4 is supposed to be 10 and it is calculated as "+value4+".");
		}
		if (2 == value5){
			correctValues++;
		} else {
			System.out.println("Value 5 is supposed to be 2 and it is calculated as "+value5+".");
		}
		
		assertEquals(
				5==correctValues
				,
				true);
		System.out.println("Success on Day11.testGetOptimalDistance!");


			
			
	}

}

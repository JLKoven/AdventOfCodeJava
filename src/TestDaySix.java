import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDaySix {

	@Test
	public void testPartOneTest1() {

		List<Integer> array = new ArrayList<Integer>();
		array.add(0);
		array.add(2);
		array.add(7);
		array.add(0);
		assertEquals(
				DaySix.printAnswerPartOne(array), 5);
		System.out.println("Success on Day5.testPartOneTest1!");
	}
	
	@Test
	public void testPartOneTest2() {

		List<Integer> array = new ArrayList<Integer>();
		array.add(0);
		array.add(2);
		array.add(7);
		array.add(0);
		assertEquals(
				DaySix.printAnswerPartTwo(array), 4);
		System.out.println("Success on Day6.testPartTwoTest1!");
	}

}

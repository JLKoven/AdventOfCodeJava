import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDayFive {

	@Test
	public void testPartOneTest3() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(0);
		intList.add(3);
		intList.add(0);
		intList.add(1);
		intList.add(-3);
		assertEquals(DayFive.printAnswerDayFivePartOne(intList), 5);
		System.out.println("Success on Day5.testPartOneTest1!");
	}
	@Test
	public void testPartTwoTest1() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(0);
		intList.add(3);
		intList.add(0);
		intList.add(1);
		intList.add(-3);
		assertEquals(DayFive.printAnswerDayFivePartTwo(intList), 10);
		System.out.println("Success on Day5.testPartTwoTest1!");
	}

}

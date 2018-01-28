import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDayFour {

	@Test
	public void testPartOneTest1() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("aa bb cc dd ee");
		assertEquals(DayFour.printAnswerDayFourPartOne(stringList), 1);
		System.out.println("Success on Day3.testPartOneTest1!");
	}
	@Test
	public void testPartOneTest2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("aa bb cc dd aa");
		assertEquals(DayFour.printAnswerDayFourPartOne(stringList), 0);
		System.out.println("Success on Day3.testPartOneTest1!");
	}
	@Test
	public void testPartOneTest3() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("aa bb cc dd aaa");
		assertEquals(DayFour.printAnswerDayFourPartOne(stringList), 1);
		System.out.println("Success on Day3.testPartOneTest1!");
	}
}

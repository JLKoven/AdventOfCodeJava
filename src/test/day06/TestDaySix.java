package test.day06;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day06.DaySix;

public class TestDaySix {

	@Test
	public void testPartOneTestImperative1() {

		List<Integer> array = new ArrayList<>();
		array.add(0);
		array.add(2);
		array.add(7);
		array.add(0);
		assertEquals(
				DaySix.getAnswerPartOneImperative(array), 5);
		System.out.println("Success on Day6.testPartOneTest1!");
	}
	
	@Test
	public void testPartOneTestImperative2() {

		List<Integer> array = new ArrayList<>();
		array.add(0);
		array.add(2);
		array.add(7);
		array.add(0);
		assertEquals(
				DaySix.getAnswerPartTwoImperative(array), 4);
		System.out.println("Success on Day6.testPartTwoTest1!");
	}

}

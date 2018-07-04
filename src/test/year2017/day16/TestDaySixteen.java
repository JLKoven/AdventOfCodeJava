package test.year2017.day16;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day16.DaySixteen;

public class TestDaySixteen {

	// String testString = "abcde";
	@Test
	public void testSpin() {
		String testString = "abcde";
		String newString = DaySixteen.spin(testString, "1");
		assertEquals(newString.equals("eabcd"), true);
		System.out.println("Success on Day16.testSpin!");
	}

	@Test
	public void testExchange() {
		String testString = "eabcd";
		String newString = DaySixteen.exchange(testString, "3/4");
		assertEquals(newString.equals("eabdc"), true);
		System.out.println("Success on Day16.testExchange!");
	}

	@Test
	public void testPartner() {
		String testString = "eabdc";
		String newString = DaySixteen.partner(testString, "e/b");
		assertEquals(newString.equals("baedc"), true);
		System.out.println("Success on Day16.testPartner!");
	}

	// @Test
	// public void testPartOneTestImperative1() {
	//
	//
	// List<Long> start = new ArrayList<>();
	// start.add((long) 65);
	// start.add((long) 8921);
	//
	//
	// Integer value = DayFifteen.getAnswerPartOneImperative(start);
	// assertEquals(
	// value==588
	// ,
	// true);
	// System.out.println("Success on Day15.testPartOneTest1!");
	// }
	//
	// @Test
	// public void testPartTwoTestImperative1() {
	//
	//
	// List<Long> start = new ArrayList<>();
	// start.add((long) 65);
	// start.add((long) 8921);
	//
	//
	// Integer value = DayFifteen.getAnswerPartTwoImperative(start);
	// System.out.println("Value is "+value);
	// assertEquals(
	// value==309
	// ,
	// true);
	// System.out.println("Success on Day15.testPartTwoTest1!");
	// }

}

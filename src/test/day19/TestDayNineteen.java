package test.day19;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day19.DayNineteen;

public class TestDayNineteen {

	@Test
	public void testPartOneTestImperative1() {

		List<String> gridLayout = new ArrayList<>();
		gridLayout.add("     |          ");
		gridLayout.add("     |  +--+    ");
		gridLayout.add("     A  |  C    ");
		gridLayout.add(" F---|----E|--+ ");
		gridLayout.add("     |  |  |  D ");
		gridLayout.add("     +B-+  +--+ ");

		String value = DayNineteen.getAnswerPartOneImperative(gridLayout);
//		System.out.println("found "+value+".");
		assertEquals(value.equals("ABCDEF"), true);
		System.out.println("Success on Day18.testPartOneTest1!");
	}

	// @Test
	// public void testPartTwoTestImperative1() {
	//
	// List<String> tabletInstructions = new ArrayList<>();
	// tabletInstructions.add("snd 1");
	// tabletInstructions.add("snd 2");
	// tabletInstructions.add("snd p");
	// tabletInstructions.add("rcv a");
	// tabletInstructions.add("rcv b");
	// tabletInstructions.add("rcv c");
	// tabletInstructions.add("rcv d");
	//
	//
	// Integer value =
	// DayEighteen.getAnswerPartTwoImperative(tabletInstructions);
	//
	// assertEquals(
	// value.equals(3)
	// ,
	// true);
	// System.out.println("Success on Day18.testPartOneTest2!");
	// }

}

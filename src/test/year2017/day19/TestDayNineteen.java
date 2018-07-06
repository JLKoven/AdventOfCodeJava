package test.year2017.day19;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day19.DayNineteen;

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
		System.out.println("Success on Day19.testPartOneTest1!");
	}

	 @Test
	 public void testPartTwoTestImperative1() {
	
			List<String> gridLayout = new ArrayList<>();
			gridLayout.add("     |          ");
			gridLayout.add("     |  +--+    ");
			gridLayout.add("     A  |  C    ");
			gridLayout.add(" F---|----E|--+ ");
			gridLayout.add("     |  |  |  D ");
			gridLayout.add("     +B-+  +--+ ");

			Integer value = DayNineteen.getAnswerPartTwoImperative(gridLayout);
	
	 assertEquals(
	 value.equals(38)
	 ,
	 true);
	 System.out.println("Success on Day19.testPartOneTest2!");
	 }

}

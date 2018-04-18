package test.day13;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day13.DayThirteen;


public class TestDayThirteen {
	
	@Test
	public void testPartOneTestImperative1() {
		

		List<String> input = new ArrayList<>();
		input.add("0: 3");
		input.add("1: 2");
		input.add("4: 4");
		input.add("6: 4");
		
		Integer value = DayThirteen.getAnswerPartOneImperative(input);
		assertEquals(
				value==24
				,
				true);
		System.out.println("Success on Day13.testPartOneTest1!");
	}
	

}

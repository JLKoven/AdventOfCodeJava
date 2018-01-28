import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDayTwo {

	@Test
	public void testPartOneTest1() {
		List<int[]> var1 = new ArrayList<>();
		int[] arrayA = {5,1,9,5};
		var1.add(arrayA);
		int[] arrayB = {7,5,3};
		var1.add(arrayB);
		int[] arrayC = {2,4,6,8};
		var1.add(arrayC);
		assertEquals(DayTwo.getListRowSum(var1),18);
		System.out.println("Success on Day2.testPartOneTest1!");
	}
	@Test
	public void testPartTwoTest1() {
		List<int[]> var2 = new ArrayList<>();
		int[] arrayA = {5,9,2,8};
		var2.add(arrayA);
		int[] arrayB = {9,4,7,3};
		var2.add(arrayB);
		int[] arrayC = {3,8,6,5};
		var2.add(arrayC);
		assertEquals(DayTwo.getListRowSumDivisions(var2),9);
		System.out.println("Success on Day2.testPartTwoTest1!");
	}

}

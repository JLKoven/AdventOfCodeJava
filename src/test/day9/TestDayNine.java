package test.day9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day9.DayNine;

public class TestDayNine {
	
	@Test
	public void testPartOneTestImperative1() {
		
		
		/*
<>, empty garbage.
<random characters>, garbage containing random characters.
<<<<>, because the extra < are ignored.
<{!>}>, because the first > is canceled.
<!!>, because the second ! is canceled, allowing the > to terminate the garbage.
<!!!>>, because the second ! and the first > are canceled.
<{o"i!a,<{i<a>, which ends at the first >.
		 */

		
		/*
{}, 1 group.
{{{}}}, 3 groups.
{{},{}}, also 3 groups.
{{{},{},{{}}}}, 6 groups.
{<{},{},{{}}>}, 1 group (which itself contains garbage).
{<a>,<a>,<a>,<a>}, 1 group.
{{<a>},{<a>},{<a>},{<a>}}, 5 groups.
{{<!>},{<!>},{<!>},{<a>}}, 2 groups (since all but the last > are canceled).
		 */
		
		/*
{}, score of 1.
{{{}}}, score of 1 + 2 + 3 = 6.
{{},{}}, score of 1 + 2 + 2 = 5.
{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16.
{<a>,<a>,<a>,<a>}, score of 1.
{{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
{{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
{{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3.
		 */
		
		assertEquals(
				DayNine.getGroupCount("{}")==1,true);
		System.out.println("Success on Day9.testPartOneTest1!");
	}
	@Test
	public void testPartOneTestImperative2() {
		assertEquals(
				DayNine.getGroupCount("{{{}}}")==3,true);
		System.out.println("Success on Day9.testPartOneTest2!");
	}
	@Test
	public void testPartOneTestImperative3() {
		System.out.println(DayNine.getGroupCount("{{},{}}"));
		assertEquals(
				DayNine.getGroupCount("{{},{}}")==3,true);
		System.out.println("Success on Day9.testPartOneTest3!");

	}
	@Test
	public void testPartOneTestImperative4() {
		assertEquals(
				DayNine.getGroupCount("{{{},{},{{}}}}")==6,true);
		System.out.println("Success on Day9.testPartOneTest4!");

	}
	@Test
	public void testPartOneTestImperative5() {
		assertEquals(
				DayNine.getGroupCount("{<{},{},{{}}>}")==1,true);
		System.out.println("Success on Day9.testPartOneTest5!");

	}
	@Test
	public void testPartOneTestImperative6() {
		assertEquals(
				DayNine.getGroupCount("{<a>,<a>,<a>,<a>}")==1,true);
		System.out.println("Success on Day9.testPartOneTest6!");

	}
	@Test
	public void testPartOneTestImperative7() {
		assertEquals(
				DayNine.getGroupCount("{{<a>},{<a>},{<a>},{<a>}}")==5,true);
		System.out.println("Success on Day9.testPartOneTest7!");

	}
	@Test
	public void testPartOneTestImperative8() {
		assertEquals(
				DayNine.getGroupCount("{{<!>},{<!>},{<!>},{<a>}}")==2,true);
		System.out.println("Success on Day9.testPartOneTest8!");

	}
	
	@Test
	public void testPartOneTestImperative9() {
		
		
		assertEquals(
				DayNine.getScore("{}")==1,true);
		System.out.println("Success on Day9.testPartOneTest9!");
	}
	@Test
	public void testPartOneTestImperative10() {
		assertEquals(
				DayNine.getScore("{{{}}}")==6,true);
		System.out.println("Success on Day9.testPartOneTest10!");
	}
	@Test
	public void testPartOneTestImperative11() {
		assertEquals(
				DayNine.getScore("{{},{}}")==5,true);
		System.out.println("Success on Day9.testPartOneTest11!");

	}
	@Test
	public void testPartOneTestImperative12() {
		assertEquals(
				DayNine.getScore("{{{},{},{{}}}}")==16,true);
		System.out.println("Success on Day9.testPartOneTest12!");

	}
	@Test
	public void testPartOneTestImperative13() {
		assertEquals(
				DayNine.getScore("{<{},{},{{}}>}")==1,true);
		System.out.println("Success on Day9.testPartOneTest13!");

	}
	@Test
	public void testPartOneTestImperative14() {
		assertEquals(
				DayNine.getScore("{<a>,<a>,<a>,<a>}")==9,true);
		System.out.println("Success on Day9.testPartOneTest14!");

	}
	@Test
	public void testPartOneTestImperative15() {
		assertEquals(
				DayNine.getScore("{{<a>},{<a>},{<a>},{<a>}}")==9,true);
		System.out.println("Success on Day9.testPartOneTest15!");

	}
	@Test
	public void testPartOneTestImperative16() {
		assertEquals(
				DayNine.getScore("{{<!>},{<!>},{<!>},{<a>}}")==3,true);
		System.out.println("Success on Day9.testPartOneTest16!");

	}
	@Test
	public void testPartOneTestImperativeGarbageSubremoval() {
		assertEquals(
				DayNine.removeExclamationFromGarbage(
						"{{<!>},{<!>},{<!>},{<a>}}")
				.equals(
						"{{<},{<},{<},{<a>}}"
						),true);
		System.out.println("Success on Day9.testPartOneTest16!");
	}
	@Test
	public void testPartOneTestImperativeGarbageRemoval() {
		assertEquals(
				DayNine.removeGarbage(
						"{{<},{<},{<},{<a>}}")
				.equals(
						"{{}}"
						),true);
		System.out.println("Success on Day9.testPartOneTest16!");
	}
	
//	@Test
//	public void testPartOneTestImperative2() {
//		
//		List<String> input = new ArrayList<>();		
//		input.add("b inc 5 if a > 1");
//		input.add("a inc 1 if b < 5");
//		input.add("c dec -10 if a >= 1");
//		input.add("c inc -20 if c == 10");
//		
//		assertEquals(
//				DayEight.getAnswerPartTwoImperative(input)==10,true);
//		System.out.println("Success on Day8.testPartOneTest2!");
//	}

}

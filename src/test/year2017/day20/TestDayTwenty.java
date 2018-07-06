package test.year2017.day20;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.year2017.day20.DayTwenty;


public class TestDayTwenty {
	
	@Test
	public void testPartOneTestImperative1() {

		List<String> particleSetInitialization = new ArrayList<>();
		particleSetInitialization.add("p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>");
		particleSetInitialization.add("p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>");
		
		/*
p=<-1027,-979,-188>, v=<7,60,66>, a=<9,1,-7>
p=<-1846,-1539,-1147>, v=<88,145,67>, a=<6,-5,2>		 */
//		p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4
//				p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>                         (0)(1)
//
//				p=< 4,0,0>, v=< 1,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4
//				p=< 2,0,0>, v=<-2,0,0>, a=<-2,0,0>                      (1)   (0)

		Integer particleID = DayTwenty.getAnswerPartOneImperative(particleSetInitialization);
		System.out.println("found "+particleID+".");
		assertEquals(particleID.equals(0), true);
		System.out.println("Success on Day20.testPartOneTest1!");
	}

//	 @Test
//	 public void testPartTwoTestImperative1() {
//	
//			List<String> gridLayout = new ArrayList<>();
//			gridLayout.add("     |          ");
//			gridLayout.add("     |  +--+    ");
//			gridLayout.add("     A  |  C    ");
//			gridLayout.add(" F---|----E|--+ ");
//			gridLayout.add("     |  |  |  D ");
//			gridLayout.add("     +B-+  +--+ ");
//
//			Integer value = DayNineteen.getAnswerPartTwoImperative(gridLayout);
//	
//	 assertEquals(
//	 value.equals(38)
//	 ,
//	 true);
//	 System.out.println("Success on Day18.testPartOneTest2!");
//	 }

}

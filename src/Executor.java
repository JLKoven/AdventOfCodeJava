import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Executor {

	public static void main(String[] args) {

//		DayOne.executeStandardPart1();
//		DayOne.executeStandardPart2();
//
//		DayTwo.executeStandardPart1();
//		DayTwo.executeStandardPart2();
//
//		DayThree.executeStandardPart1();
//		DayThree.executeStandardPart2();
		
//		DayFour.executeStandardPart1();
//		DayFour.executeStandardPart2();

		DayFive.executeStandardPart1();
		DayFive.executeStandardPart2();
		
		System.out.println("test");
		Integer[] newIntArray = {3, 4, 10};
		Integer[] newIntArray2 = {4, 5, 8};
		Map<Integer[], Integer> AlreadySeen = new HashMap<Integer[], Integer>();
		AlreadySeen.put(newIntArray,1);
		Set<Integer[]> newSet = new HashSet<Integer[]>();
		newSet.add(newIntArray);
		System.out.println("Does this map contain unmodified map? Answer is: "+AlreadySeen.containsKey(newIntArray2)+".");
		System.out.println("Does this map contain unmodified set? Answer is: "+newSet.contains(newIntArray2)+".");
		newIntArray2[0] = 3;
		newIntArray2[1] = 5;
		newIntArray2[2] = 8;
		System.out.println("Does this map contain modified map? Answer is: "+AlreadySeen.containsKey(newIntArray2)+".");
		System.out.println("Does this map contain unmodified set? Answer is: "+newSet.contains(newIntArray2)+".");
		

		
		
		//DaySix.executeStandardPart1();

	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

//		DayFive.executeStandardPart1();
//		DayFive.executeStandardPart2();
		
		System.out.println("test");
		Integer[] newIntArray = {3, 4, 10};
		Integer[] newIntArray2 = {4, 5, 8};
		List<Integer> newIntAList = new ArrayList<Integer>();
		List<Integer> newIntAList2 = new ArrayList<Integer>();
		newIntAList.add(3);
		newIntAList.add(4);
		newIntAList.add(10);
		newIntAList2.add(4);
		newIntAList2.add(5);
		newIntAList2.add(8);
		Map<Integer[], Integer> AlreadySeenArray = new HashMap<Integer[], Integer>();
		AlreadySeenArray.put(newIntArray,1);
		Set<Integer[]> newSetArray = new HashSet<Integer[]>();
		newSetArray.add(newIntArray);
		Map<List<Integer>, Integer> AlreadySeenArrayList = new HashMap<List<Integer>, Integer>();
		AlreadySeenArrayList.put(newIntAList,1);
		Set<List<Integer>> newSetArrayList = new HashSet<List<Integer>>();
		newSetArrayList.add(newIntAList);
		System.out.println("Does this map contain unmodified map? Answer is: "+AlreadySeenArray.containsKey(newIntArray2)+".");
		System.out.println("Does this map contain unmodified set? Answer is: "+newSetArray.contains(newIntArray2)+".");
		System.out.println("Does this map contain unmodified map? Answer is: "+AlreadySeenArrayList.containsKey(newIntAList2)+".");
		System.out.println("Does this map contain unmodified set? Answer is: "+newSetArrayList.contains(newIntAList2)+".");
		System.out.println("Are these objects equal? Answer is: "+newIntArray == newIntArray2+".");
		System.out.println("Are these objects equal? Answer is: "+newIntArray.equals(newIntArray2)+".");
		System.out.println("Are these objects equal? Answer is: "+newIntAList == newIntAList2+".");
		System.out.println("Are these objects equal? Answer is: "+newIntAList.equals(newIntAList2)+".");
		newIntArray2[0] = 3;
		newIntArray2[1] = 4;
		newIntArray2[2] = 10;
		newIntAList2.set(0, 3);
		newIntAList2.set(1, 4);
		newIntAList2.set(2, 10);
		System.out.println("Does this map contain modified map? Answer is: "+AlreadySeenArray.containsKey(newIntArray2)+".");
		System.out.println("Does this map contain modified set? Answer is: "+newSetArray.contains(newIntArray2)+".");
		System.out.println("Does this map contain modified map? Answer is: "+AlreadySeenArrayList.containsKey(newIntAList2)+".");
		System.out.println("Does this map contain modified set? Answer is: "+newSetArrayList.contains(newIntAList2)+".");
		System.out.println("Are these objects equal? Answer is: "+newIntArray == newIntArray2+".");
		System.out.println("Are these objects equal? Answer is: "+newIntArray.equals(newIntArray2)+".");
		System.out.println("Are these objects equal? Answer is: "+newIntAList == newIntAList2+".");
		System.out.println("Are these objects equal? Answer is: "+newIntAList.equals(newIntAList2)+".");
		

		System.out.println("test part 2");
		int[] arrayPrimordial = {4, 5, 6};
		Integer[] arrayInteger = {4, 5, 6};
		ArrayList<Integer> convetedArrayList = new ArrayList<>(Arrays.asList(arrayInteger));
		ArrayList<Integer> convetedArrayListViaJava8 = (ArrayList<Integer>) Arrays.stream( arrayPrimordial ).boxed().collect( Collectors.toList() );
		System.out.println("Index at 0 is "+convetedArrayList.get(0)+" and "+convetedArrayListViaJava8.get(0)+".");
		System.out.println("Index at 1 is "+convetedArrayList.get(1)+" and "+convetedArrayListViaJava8.get(1)+".");
		System.out.println("Index at 2 is "+convetedArrayList.get(2)+" and "+convetedArrayListViaJava8.get(2)+".");
		
		//DaySix.executeStandardPart1();

	}

}

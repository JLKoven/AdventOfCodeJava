import java.util.HashMap;
import java.util.Map;

public class DaySix {

	public static void executeStandardPart1() {
//		A debugger program here is having an issue: it is trying to repair a memory reallocation routine, but it keeps getting stuck in an infinite loop.
//
//		In this area, there are sixteen memory banks; each memory bank can hold any number of blocks. The goal of the reallocation routine is to balance the blocks between the memory banks.
//
//		The reallocation routine operates in cycles. In each cycle, it finds the memory bank with the most blocks (ties won by the lowest-numbered memory bank) and redistributes those blocks among the banks. To do this, it removes all of the blocks from the selected bank, then moves to the next (by index) memory bank and inserts one of the blocks. It continues doing this until it runs out of blocks; if it reaches the last memory bank, it wraps around to the first one.
//
//		The debugger would like to know how many redistributions can be done before a blocks-in-banks configuration is produced that has been seen before.
//
//		For example, imagine a scenario with only four memory banks:
//
//		The banks start with 0, 2, 7, and 0 blocks. The third bank has the most blocks, so it is chosen for redistribution.
//		Starting with the next bank (the fourth bank) and then continuing to the first bank, the second bank, and so on, the 7 blocks are spread out over the memory banks. The fourth, first, and second banks get two blocks each, and the third bank gets one back. The final result looks like this: 2 4 1 2.
//		Next, the second bank is chosen because it contains the most blocks (four). Because there are four memory banks, each gets one block. The result is: 3 1 2 3.
//		Now, there is a tie between the first and fourth memory banks, both of which have three blocks. The first bank wins the tie, and its three blocks are distributed evenly over the other three banks, leaving it with none: 0 2 3 4.
//		The fourth bank is chosen, and its four blocks are distributed such that each of the four banks receives one: 1 3 4 1.
//		The third bank is chosen, and the same thing happens: 2 4 1 2.
//		At this point, we've reached a state we've seen before: 2 4 1 2 was already seen. The infinite loop is detected after the fifth block redistribution cycle, and so the answer in this example is 5.
//
//		Given the initial block counts in your puzzle input, how many redistribution cycles must be completed before a configuration is produced that has been seen before?		System.out.println("Day 6 Part 1");
		System.out.println("Answer to array part 1 is " + printAnswerPartOne(getStandardInputDaySix()) + ".");

	}

	private static int printAnswerPartOne(Integer[] standardInputDaySix) {
		int cyclesToBeCompleted=0;
		Map<Integer[], Integer> AlreadySeen = new HashMap<Integer[], Integer>();
		Integer[] currentConfiguration = standardInputDaySix;
		int currentIndex=0;
		for (int i=0; i<currentConfiguration.length; i++){
			System.out.print(currentConfiguration[i]+",");
		}

		boolean notFoundDuplicate=true;
		while (notFoundDuplicate){
			AlreadySeen.put(currentConfiguration, 1);
			currentIndex = findCurrentIndex(currentConfiguration);
			Integer[] newArray = GeneralFunction.shallowCopyOfArray(shiftConfigurationAt(currentConfiguration, currentIndex));			
			cyclesToBeCompleted=cyclesToBeCompleted+1;
			notFoundDuplicate = AlreadySeen.containsKey(newArray);
		}
		for (int i=0; i<currentConfiguration.length; i++){
			System.out.print(currentConfiguration[i]+",");
		}
		System.out.println("");
		return cyclesToBeCompleted;
	}

	private static Integer[] shiftConfigurationAt(Integer[] currentConfiguration, int indexToRemoveFrom) {		
//		Integer[] arrayToReturn = currentConfiguration;
		Integer[] arrayToReturn = GeneralFunction.shallowCopyOfArray(currentConfiguration);
		int currentIndex = indexToRemoveFrom+1;
		if (currentIndex >= currentConfiguration.length){
			currentIndex = 0;
		}
//		if (currentIndex == indexToRemoveFrom){
//			Exception e = new Exception();
//			try {
//				throw e;
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
		int value = currentConfiguration[indexToRemoveFrom];
		while (value>0){
			arrayToReturn[indexToRemoveFrom] = currentConfiguration[indexToRemoveFrom]-1;
			arrayToReturn[currentIndex] = currentConfiguration[currentIndex]+1;
			currentIndex = incrementIndex(currentIndex, indexToRemoveFrom, currentConfiguration.length);
			value = value-1;
		}
//		System.out.println("currentConfiguration[indexToRemoveFrom] is "+ currentConfiguration[indexToRemoveFrom]+".");
		return arrayToReturn ;
	}

	private static int incrementIndex(int currentIndex, int indexToRemoveFrom, int length) {
		int intToReturn = currentIndex+1;
//		if (intToReturn == indexToRemoveFrom){
//			intToReturn = intToReturn+1;
//		}
		if (intToReturn >= length){
			intToReturn = 0;
		}
//		if (intToReturn == indexToRemoveFrom){
//			Exception e = new Exception();
//			try {
//				throw e;
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
		return intToReturn;
	}

	private static int findCurrentIndex(Integer[] currentConfiguration) {
		int currentMax = Integer.MIN_VALUE;
		int currentIndexToReturn = 0;
		for (int i=0;i < currentConfiguration.length; i++){
			if (currentConfiguration[i] > currentMax){
				currentMax = currentConfiguration[i];
				currentIndexToReturn = i;
			}
		}
		System.out.println("Current index is "+currentIndexToReturn+".");
		System.out.println("value is "+currentConfiguration[currentIndexToReturn]+".");
		return currentIndexToReturn;
	}

	private static Integer[] getStandardInputDaySix() {
		Integer[] array = 
			{0,2,7,0}

				//			{11,11,13,7,0,15,5,5,4,4,1,1,7,1,15,11}
				;

		return array;
	}

}

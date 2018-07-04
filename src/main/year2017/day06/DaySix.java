package main.year2017.day06;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.GeneralFunction;

public class DaySix {

	public static void executeStandardPart1() {
		// A debugger program here is having an issue: it is trying to repair a
		// memory reallocation routine, but it keeps getting stuck in an
		// infinite loop.
		//
		// In this area, there are sixteen memory banks; each memory bank can
		// hold any number of blocks. The goal of the reallocation routine is to
		// balance the blocks between the memory banks.
		//
		// The reallocation routine operates in cycles. In each cycle, it finds
		// the memory bank with the most blocks (ties won by the lowest-numbered
		// memory bank) and redistributes those blocks among the banks. To do
		// this, it removes all of the blocks from the selected bank, then moves
		// to the next (by index) memory bank and inserts one of the blocks. It
		// continues doing this until it runs out of blocks; if it reaches the
		// last memory bank, it wraps around to the first one.
		//
		// The debugger would like to know how many redistributions can be done
		// before a blocks-in-banks configuration is produced that has been seen
		// before.
		//
		// For example, imagine a scenario with only four memory banks:
		//
		// The banks start with 0, 2, 7, and 0 blocks. The third bank has the
		// most blocks, so it is chosen for redistribution.
		// Starting with the next bank (the fourth bank) and then continuing to
		// the first bank, the second bank, and so on, the 7 blocks are spread
		// out over the memory banks. The fourth, first, and second banks get
		// two blocks each, and the third bank gets one back. The final result
		// looks like this: 2 4 1 2.
		// Next, the second bank is chosen because it contains the most blocks
		// (four). Because there are four memory banks, each gets one block. The
		// result is: 3 1 2 3.
		// Now, there is a tie between the first and fourth memory banks, both
		// of which have three blocks. The first bank wins the tie, and its
		// three blocks are distributed evenly over the other three banks,
		// leaving it with none: 0 2 3 4.
		// The fourth bank is chosen, and its four blocks are distributed such
		// that each of the four banks receives one: 1 3 4 1.
		// The third bank is chosen, and the same thing happens: 2 4 1 2.
		// At this point, we've reached a state we've seen before: 2 4 1 2 was
		// already seen. The infinite loop is detected after the fifth block
		// redistribution cycle, and so the answer in this example is 5.
		//
		// Given the initial block counts in your puzzle input, how many
		// redistribution cycles must be completed before a configuration is
		// produced that has been seen before? System.out.println("Day 6 Part
		// 1");
		System.out.println("Day 6 Part 1");
        File file = new File("src/main/day06/input.txt");
        URI uri = file.toURI();
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfIntegersFromSingleLine(uri)) + ".");

	}
	
	public static void executeStandardPart2() {
//		--- Part Two ---
//		Out of curiosity, the debugger would also like to know the size of the loop: starting from a state that has already been seen, how many block redistribution cycles must be performed before that same state is seen again?
//
//		In the example above, 2 4 1 2 is seen again after four cycles, and so the answer in that example would be 4.
//
//		How many cycles are in the infinite loop that arises from the configuration in your puzzle input?
		System.out.println("Day 6 Part 2");
        File file = new File("src/main/day06/input.txt");
        URI uri = file.toURI();
		System.out.println("Answer to part 2 is " + getAnswerPartTwoImperative(GeneralFunction.getStandardInputListOfIntegersFromSingleLine(uri)) + ".");

	}
	
	
	//Imperative


	public static int getAnswerPartOneImperative(List<Integer> standardInputDaySix) {
		int cyclesToBeCompleted = 0;
		Set<List<Integer>> alreadySeen = new HashSet<>();
		List<Integer> initialConfiguration = GeneralFunction.deepCopyOfArrayList(standardInputDaySix);
		int currentIndex = 0;

		boolean notFoundDuplicate = true;
		List<Integer> newArray = new ArrayList<>();
		while (notFoundDuplicate) {
			if (!newArray.isEmpty()) {
				alreadySeen.add(newArray);
				currentIndex = findCurrentIndex(newArray);
				newArray = GeneralFunction.deepCopyOfArrayList(shiftConfigurationAt(newArray, currentIndex));
			} else {
				alreadySeen.add(initialConfiguration);
				currentIndex = findCurrentIndex(initialConfiguration);
				newArray = GeneralFunction
						.deepCopyOfArrayList(shiftConfigurationAt(initialConfiguration, currentIndex));
			}
			cyclesToBeCompleted = cyclesToBeCompleted + 1;

			notFoundDuplicate = !alreadySeen.contains(newArray);
		}

		return cyclesToBeCompleted;
	}

	public static int getAnswerPartTwoImperative(List<Integer> standardInputDaySix) {
		int cyclesToBeCompleted = 0;
		Set<List<Integer>> alreadySeen = new HashSet<>();
		List<Integer> initialConfiguration = GeneralFunction.deepCopyOfArrayList(standardInputDaySix);
		int currentIndex = 0;

		boolean notFoundDuplicate = true;
		List<Integer> newArray = new ArrayList<>();
		while (notFoundDuplicate) {
			if (!newArray.isEmpty()) {
				alreadySeen.add(newArray);
				currentIndex = findCurrentIndex(newArray);
				newArray = GeneralFunction.deepCopyOfArrayList(shiftConfigurationAt(newArray, currentIndex));
			} else {
				alreadySeen.add(initialConfiguration);
				currentIndex = findCurrentIndex(initialConfiguration);
				newArray = GeneralFunction
						.deepCopyOfArrayList(shiftConfigurationAt(initialConfiguration, currentIndex));
			}
			cyclesToBeCompleted = cyclesToBeCompleted + 1;

			notFoundDuplicate = !alreadySeen.contains(newArray);
		}

		int counterBeforeCycle = 0;
		List<Integer> fixedArray = GeneralFunction.deepCopyOfArrayList(newArray);
		currentIndex = findCurrentIndex(newArray);
		newArray = GeneralFunction.deepCopyOfArrayList(shiftConfigurationAt(newArray, currentIndex));
		while (!fixedArray.equals(newArray)) {
			counterBeforeCycle++;
			currentIndex = findCurrentIndex(newArray);
			newArray = GeneralFunction.deepCopyOfArrayList(shiftConfigurationAt(newArray, currentIndex));
		}
		counterBeforeCycle++;
		return counterBeforeCycle;
	}

	private static List<Integer> shiftConfigurationAt(List<Integer> currentConfiguration, int indexToRemoveFrom) {
		List<Integer> arrayToReturn = GeneralFunction.deepCopyOfArrayList(currentConfiguration);
		int currentIndex = indexToRemoveFrom + 1;
		if (currentIndex >= currentConfiguration.size()) {
			currentIndex = 0;
		}

		int value = currentConfiguration.get(indexToRemoveFrom);
		while (value > 0) {
			arrayToReturn.set(indexToRemoveFrom, arrayToReturn.get(indexToRemoveFrom) - 1);
			arrayToReturn.set(currentIndex, arrayToReturn.get(currentIndex) + 1);
			currentIndex = incrementIndex(currentIndex, indexToRemoveFrom, currentConfiguration.size());
			value = value - 1;
		}
		return arrayToReturn;
	}

	private static int incrementIndex(int currentIndex, int indexToRemoveFrom, int length) {
		int intToReturn = currentIndex + 1;

		if (intToReturn >= length) {
			intToReturn = 0;
		}

		return intToReturn;
	}

	private static int findCurrentIndex(List<Integer> currentConfiguration) {
		int currentMax = Integer.MIN_VALUE;
		int currentIndexToReturn = 0;
		for (int i = 0; i < currentConfiguration.size(); i++) {
			if (currentConfiguration.get(i) > currentMax) {
				currentMax = currentConfiguration.get(i);
				currentIndexToReturn = i;
			}
		}
		return currentIndexToReturn;
	}




	


}

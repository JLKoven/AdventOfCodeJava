package main.day11;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import main.GeneralFunction;
import main.TailCall;

public class DayEleven {

	public static void executeStandardPart1() {
		// --- Day 11: Hex Ed ---
		// Crossing the bridge, you've barely reached the other side of the
		// stream when a program comes up to you, clearly in distress. "It's my
		// child process," she says, "he's gotten lost in an infinite grid!"
		//
		// Fortunately for her, you have plenty of experience with infinite
		// grids.
		//
		// Unfortunately for you, it's a hex grid.
		//
		// The hexagons ("hexes") in this grid are aligned such that adjacent
		// hexes can be found to the north, northeast, southeast, south,
		// southwest, and northwest:
		//
		// \ n /
		// nw +--+ ne
		// / \
		// -+ +-
		// \ /
		// sw +--+ se
		// / s \
		// You have the path the child process took. Starting where he started,
		// you need to determine the fewest number of steps required to reach
		// him. (A "step" means to move from the hex you are in to any adjacent
		// hex.)
		//
		// For example:
		//
		// ne,ne,ne is 3 steps away.
		// ne,ne,sw,sw is 0 steps away (back where you started).
		// ne,ne,s,s is 2 steps away (se,se).
		// se,sw,se,sw,sw is 3 steps away (s,s,sw).
		System.out.println("Day 11 Part 1");
		File file = new File("src/main/day11/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getInputDelimiterCommaToListString(uri)) + ".");

	}

	public static Integer getAnswerPartOneImperative(List<String> inputDelimiterCommaToListString) {

		Integer northSouthCounter = 0;
		Integer northeastSouthwestCounter = 0;
		Integer northwestSoutheastCounter = 0;
		List<Integer> directionList = new ArrayList<>();
		directionList.add(northSouthCounter);
		directionList.add(northeastSouthwestCounter);
		directionList.add(northwestSoutheastCounter);

		// Stream<String> stringStream =
		// inputDelimiterCommaToListString.stream();
		// stringStream.filter(s->
		// (
		// "ne".equals(s)
		// ||
		// "sw".equals(s)
		// )
		// );

		for (String direction : inputDelimiterCommaToListString) {
			if ("n".equals(direction)) {
				northSouthCounter++;
			} else if ("s".equals(direction)) {
				northSouthCounter--;
			} else if ("ne".equals(direction)) {
				northeastSouthwestCounter++;
			} else if ("sw".equals(direction)) {
				northeastSouthwestCounter--;
			} else if ("nw".equals(direction)) {
				northwestSoutheastCounter++;
			} else if ("se".equals(direction)) {
				northwestSoutheastCounter--;
			} else {
				System.out.println("ERROR");
			}
		}

		System.out.println("n_s counter is " + northSouthCounter + ".");
		System.out.println("ne_sw counter is " + northeastSouthwestCounter + ".");
		System.out.println("nw_se counter is " + northwestSoutheastCounter + ".");

		/*
		 * n_s counter is -72. ne_sw counter is 375. nw_se counter is -330.
		 * 
		 * north and southeast are east, so, this is basically...
		 * 
		 * south 1 times northeast 3 times southeast 2 times 5 away:
		 * se+ne+se+ne+se
		 * 
		 * 0,0
		 * 
		 * 0,-1
		 * 
		 * 0,-2
		 * 
		 * 0,-3
		 * 
		 * 330 steps east 45 steps northeast 72 steps south
		 * 
		 * south+northeast = southeast, so, this is basically... 330 steps east
		 * 45 steps southeast 27 steps south 45+27+(330*2) =
		 */
		Integer value = 5;
		return value;
	}

	public static void executeStandardPart2() {
		// --- Part Two ---
		// How many steps away is the furthest he ever got from his starting
		// position?
		System.out.println("Day 11 Part 2");
		File file = new File("src/main/day11/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is "
				+ getAnswerPartTwoHybrid(GeneralFunction.getInputDelimiterCommaToListString(uri)) + ".");
	}

	// public static Integer getAnswerPartTwoImperative(List<String>
	// inputDelimiterCommaToListString) {
	// Integer value = 5;
	// // TODO Auto-generated method stub
	// return value;
	// }

	// public static Integer getAnswerPartTwoFunctional(List<String>
	// inputDelimiterCommaToListString) {
	// Integer value = 5;
	// // TODO Auto-generated method stub
	// return value;
	// }

	public static Integer getAnswerPartTwoHybrid(List<String> inputDelimiterCommaToListString) {
		return getMaxDistanceRecursiveAccumulator(0, 0, inputDelimiterCommaToListString, 0, 0, 0).obtain();
	}

	private static TailCall<Integer> getMaxDistanceRecursiveAccumulator(int maxDistance, int currentDistance,
			List<String> stringList, int nsCounter, int neswCounter, int nwseCounter) {
		if (stringList.isEmpty()) {
			return TailCall.done(maxDistance);
		} else {
			String direction = stringList.get(0);
			stringList.remove(0);//this is why it is a hybrid function
			if ("n".equals(direction)) {
				int newnsCounter = nsCounter + 1;
				int newneswCounter = neswCounter + 0;
				int newnwseCounter = neswCounter + 0;
				int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newneswCounter);
				if (newOptimalDistance<currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance,//not sure this does anythng MAKE SURE TO PROPAGATE THIS 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance>currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(
							maxDistance + 1, 
							newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance==currentDistance){
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance, 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else {
					System.out.println("ERROR ERROR ERROR DISTANCE COMPARISON");
					return null;
				}
			} else if ("s".equals(direction)) {
				int newnsCounter = nsCounter - 1;
				int newneswCounter = neswCounter + 0;
				int newnwseCounter = neswCounter + 0;
				int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newneswCounter);
				if (newOptimalDistance<currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance,//not sure this does anythng MAKE SURE TO PROPAGATE THIS 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance>currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(
							maxDistance + 1, 
							newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance==currentDistance){
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance, 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else {
					System.out.println("ERROR ERROR ERROR DISTANCE COMPARISON");
					return null;
				}
			} else if ("ne".equals(direction)) {
				int newnsCounter = nsCounter + 0;
				int newneswCounter = neswCounter + 1;
				int newnwseCounter = neswCounter + 0;
				int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newnwseCounter);
				if (newOptimalDistance<currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance,//not sure this does anythng MAKE SURE TO PROPAGATE THIS 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance>currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(
							maxDistance + 1, 
							newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance==currentDistance){
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance, 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else {
					System.out.println("ERROR ERROR ERROR DISTANCE COMPARISON");
					return null;
				}
			} else if ("sw".equals(direction)) {
				int newnsCounter = nsCounter + 0;
				int newneswCounter = neswCounter - 1;
				int newnwseCounter = neswCounter + 0;
				int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newnwseCounter);
				if (newOptimalDistance<currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance,//not sure this does anythng MAKE SURE TO PROPAGATE THIS 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance>currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(
							maxDistance + 1, 
							newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance==currentDistance){
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance, 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else {
					System.out.println("ERROR ERROR ERROR DISTANCE COMPARISON");
					return null;
				}
			} else if ("nw".equals(direction)) {
				int newnsCounter = nsCounter + 0;
				int newneswCounter = neswCounter + 0;
				int newnwseCounter = neswCounter + 1;
				int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newnwseCounter);
				if (newOptimalDistance<currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance,//not sure this does anythng MAKE SURE TO PROPAGATE THIS 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance>currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(
							maxDistance + 1, 
							newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance==currentDistance){
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance, 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else {
					System.out.println("ERROR ERROR ERROR DISTANCE COMPARISON");
					return null;
				}
			} else if ("se".equals(direction)) {
				int newnsCounter = nsCounter + 0;
				int newneswCounter = neswCounter + 0;
				int newnwseCounter = neswCounter - 1;
				int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newnwseCounter);
				if (newOptimalDistance<currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance,//not sure this does anythng MAKE SURE TO PROPAGATE THIS 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance>currentDistance) {
					return () -> getMaxDistanceRecursiveAccumulator(
							maxDistance + 1, 
							newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance==currentDistance){
					return () -> getMaxDistanceRecursiveAccumulator(maxDistance, 
							newOptimalDistance, 
							stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else {
					System.out.println("ERROR ERROR ERROR DISTANCE COMPARISON");
					return null;
				}
			} else {
				System.out.println("ERROR BAD DIRECTION COMPARISON");
				return null;
			}
		}
	}

	public static int getOptimalDistance(int nsCounter, int neswCounter, int nwseCounter) {
		
		//1, 2, -5
		Double overallNSCounterDouble = (double) ((nsCounter*2)+neswCounter+nwseCounter);//-1
		Double overallEWCounterDouble = (double) (neswCounter-nwseCounter);//7
		Double overallNSCounterHalf = overallNSCounterDouble * 0.5;//-0.5
		Double overallEWCounterHalf = overallEWCounterDouble * 0.5;//3.5
		//3 southeast motions mean now we're at (-1.5,3
		//3 steps east is 3 northeast, 3 southeast
		//so now we're at 0,3
		//1 southeast
		//6+1 = 7 
		return (6+1);
		
		
//		Double value = (double) (nsCounter+neswCounter+nwseCounter);
//		// TODO Auto-generated method stub
//		//find east or west or neither 
//		Double ewCounter = (double) (neswCounter-nwseCounter);
//		Double neswCounterAsDouble = (double) neswCounter;
//		Double nwseCounterAsDouble = (double) nwseCounter;
////		Double secondnsCounter 
//		
////		neswCounter > 0 = "east"
////		nwseCounter > 0 = "west"
//		
//		if (0 == neswCounter-nwseCounter) {
//			// neither (east or west)
//			return (Math.abs(nsCounter));
//
//		} else if (0 < neswCounter-nwseCounter) {
//			//east 
//			
//			Double nsTilt = (neswCounterAsDouble * 0.5) + (nwseCounterAsDouble * 0.5);
//			if (0==nsTilt){//east
//				Double result = (neswCounterAsDouble+nwseCounterAsDouble);
//				return result.intValue();
//			} else if (0>nsTilt){//southeast
//				Double result = (neswCounterAsDouble+nwseCounterAsDouble);
//				//2, 3, -10
//				//ns tilt is 1.5-5 = -3.5
//				//se movements = -0.5 so this would be 7 se movements
//				return result.intValue();
//			} else if (0<nsTilt){//northeast
//				Double result = (neswCounterAsDouble+nwseCounterAsDouble);
//				return result.intValue();
//			} else {
//				System.out.println("ERROR NORTH SOUTH TILT COMPARISON");
//				return (Integer) null;
//			}
//			
//			//check for NS tilt (*0.5) TODO 
////			if (nstilt is 0){
////				
////			} else if (positive){
////				
////			} else if (negative){
////				
////			} else {
////				//error
////			}
//
//		} else if (0 > neswCounter-nwseCounter) {
//			//west
//			
//			//check for NS tilt (*0.5) TODO 
////			if (nstilt is 0){
////				
////			} else if (positive){
////				
////			} else if (negative){
////				
////			} else {
////				//error
////			}
//			
//		} else {
//			System.out.println("ERROR EAST WEST COMPARISON");
//			ewCounter = null;
//			return (Integer) null;
//		}
//		
//		
//		
//		
//		return value.intValue();
	}

}

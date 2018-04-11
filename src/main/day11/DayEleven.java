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
		Integer value = getOptimalDistance(northSouthCounter, northeastSouthwestCounter, northwestSoutheastCounter);
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

	private static Integer getAnswerPartTwoImperative(List<String> inputDelimiterCommaToListString) {
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
		Integer maxDistance = 0;

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
			System.out.println("ns is "+northSouthCounter+".");
			System.out.println("nesw is "+northeastSouthwestCounter+".");
			System.out.println("nwse is "+northwestSoutheastCounter+".");
			maxDistance = (getOptimalDistance(northSouthCounter, northeastSouthwestCounter, northwestSoutheastCounter)>maxDistance) ? getOptimalDistance(northSouthCounter, northeastSouthwestCounter, northwestSoutheastCounter) : maxDistance;
			System.out.println(maxDistance);
			System.out.println();
		}
		return maxDistance;
	}




	





	public static Integer getAnswerPartTwoHybrid(List<String> inputDelimiterCommaToListString) {
		return getAnswerPartTwoImperative(inputDelimiterCommaToListString);//(0, 0, inputDelimiterCommaToListString, 0, 0, 0).obtain();

//		return getMaxDistanceRecursiveAccumulator(0, 0, inputDelimiterCommaToListString, 0, 0, 0).obtain();
				
				//problematicGetMaxDistanceRecursiveAccumulator(0, 0, inputDelimiterCommaToListString, 0, 0, 0).obtain();
	}

	private static TailCall<Integer> getMaxDistanceRecursiveAccumulator(int maxDistance, int currentDistance,
			List<String> stringList, int nsCounter, int neswCounter, int nwseCounter) {
		String direction = null;
		if (stringList.size()>0){
			direction = stringList.get(0);			
		} else {
			direction = "empty";
		}
		System.out.println(currentDistance+" "+direction+" ");
		if (stringList.isEmpty()) {
			return TailCall.done(maxDistance);
		} else {
//			String direction = stringList.get(0);
			stringList.remove(0);// this is why it is a hybrid function
			int newnsCounter = processDirectionNS(direction, nsCounter);
			int newneswCounter = processDirectionNESW(direction, neswCounter);
			int newnwseCounter = processDirectionNWSE(direction, nwseCounter);
			int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newneswCounter);
			return () -> getMaxDistanceRecursiveAccumulator(Math.max(maxDistance, newOptimalDistance), newOptimalDistance, stringList, newnsCounter, newneswCounter, newnwseCounter);
		}	
	}

	private static TailCall<Integer> problematicButBetterGetMaxDistanceRecursiveAccumulator(int maxDistance, int currentDistance,
			List<String> stringList, int nsCounter, int neswCounter, int nwseCounter) {
		String direction = stringList.get(0);
		System.out.println(currentDistance+" "+direction+" ");
		if (stringList.isEmpty()) {
			return TailCall.done(maxDistance);
		} else {
			stringList.remove(0);// this is why it is a hybrid function
			int newnsCounter = processDirectionNS(direction, nsCounter);
			int newneswCounter = processDirectionNESW(direction, neswCounter);
			int newnwseCounter = processDirectionNWSE(direction, nwseCounter);
			int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newneswCounter);
			if (newOptimalDistance > currentDistance){
				return () -> problematicButBetterGetMaxDistanceRecursiveAccumulator(maxDistance + 1, newOptimalDistance, stringList,
						newnsCounter, newneswCounter, newnwseCounter);
			} else {
				return () -> problematicButBetterGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, stringList,
						newnsCounter, newneswCounter, newnwseCounter);
			}
		}
	}

	private static int processDirectionNWSE(String direction, int nwseCounter) {
		Integer newValue = nwseCounter;
		if ("nw".equals(direction)){
			newValue = newValue+1;
		} else if ("se".equals(direction)){
			newValue = newValue-1;
		} else if ("ne".equals(direction)){
//			newValue = newValue;
		} else if ("n".equals(direction)){
//			newValue = newValue;
		} else if ("s".equals(direction)){
//			newValue = newValue;
		} else if ("sw".equals(direction)){
//			newValue = newValue;
		} else {
			System.out.println("ERROR DIRECTION PROBLEM, listed direction is "+direction+".");
		}
		return newValue;
	}

	private static int processDirectionNESW(String direction, int neswCounter) {
		Integer newValue = neswCounter;
		if ("ne".equals(direction)){
			newValue = newValue+1;
		} else if ("sw".equals(direction)){
			newValue = newValue-1;
		} else if ("n".equals(direction)){
//			newValue = newValue;
		} else if ("nw".equals(direction)){
//			newValue = newValue;
		} else if ("se".equals(direction)){
//			newValue = newValue;
		} else if ("s".equals(direction)){
//			newValue = newValue;
		} else {
			System.out.println("ERROR DIRECTION PROBLEM, listed direction is "+direction+".");
		}
		return newValue;
	}

	private static int processDirectionNS(String direction, int nsCounter) {
		Integer newValue = nsCounter;
		if ("n".equals(direction)){
			newValue = newValue+1;
		} else if ("s".equals(direction)){
			newValue = newValue-1;
		} else if ("ne".equals(direction)){
//			newValue = newValue;
		} else if ("nw".equals(direction)){
//			newValue = newValue;
		} else if ("se".equals(direction)){
//			newValue = newValue;
		} else if ("sw".equals(direction)){
//			newValue = newValue;
		} else {
			System.out.println("ERROR DIRECTION PROBLEM, listed direction is "+direction+".");
		}
		return newValue;
	}

	private static TailCall<Integer> problematicGetMaxDistanceRecursiveAccumulator(int maxDistance, int currentDistance,
			List<String> stringList, int nsCounter, int neswCounter, int nwseCounter) {
		if (stringList.isEmpty()) {
			return TailCall.done(maxDistance);
		} else {
			String direction = stringList.get(0);
			stringList.remove(0);// this is why it is a hybrid function
			if ("n".equals(direction)) {
				int newnsCounter = nsCounter + 1;
				int newneswCounter = neswCounter + 0;
				int newnwseCounter = neswCounter + 0;
				int newOptimalDistance = getOptimalDistance(newnsCounter, newneswCounter, newneswCounter);
				if (newOptimalDistance < currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, // not
																										// sure
																										// this
																										// does
																										// anythng
																										// MAKE
																										// SURE
																										// TO
																										// PROPAGATE
																										// THIS
							stringList, newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance > currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance + 1, newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance == currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, stringList,
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
				if (newOptimalDistance < currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, // not
																										// sure
																										// this
																										// does
																										// anythng
																										// MAKE
																										// SURE
																										// TO
																										// PROPAGATE
																										// THIS
							stringList, newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance > currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance + 1, newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance == currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, stringList,
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
				if (newOptimalDistance < currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, // not
																										// sure
																										// this
																										// does
																										// anythng
																										// MAKE
																										// SURE
																										// TO
																										// PROPAGATE
																										// THIS
							stringList, newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance > currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance + 1, newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance == currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, stringList,
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
				if (newOptimalDistance < currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, // not
																										// sure
																										// this
																										// does
																										// anythng
																										// MAKE
																										// SURE
																										// TO
																										// PROPAGATE
																										// THIS
							stringList, newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance > currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance + 1, newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance == currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, stringList,
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
				if (newOptimalDistance < currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, // not
																										// sure
																										// this
																										// does
																										// anythng
																										// MAKE
																										// SURE
																										// TO
																										// PROPAGATE
																										// THIS
							stringList, newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance > currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance + 1, newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance == currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, stringList,
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
				if (newOptimalDistance < currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, // not
																										// sure
																										// this
																										// does
																										// anythng
																										// MAKE
																										// SURE
																										// TO
																										// PROPAGATE
																										// THIS
							stringList, newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance > currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance + 1, newOptimalDistance, stringList,
							newnsCounter, newneswCounter, newnwseCounter);
				} else if (newOptimalDistance == currentDistance) {
					return () -> problematicGetMaxDistanceRecursiveAccumulator(maxDistance, newOptimalDistance, stringList,
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
		//returns 2913 from my input.txt
	}

	public static int getOptimalDistance(int nsCounter, int neswCounter, int nwseCounter) {

		
		//EX1:  1, 2, -5 = (SE+NW; SE+NW; SE+NW; SE) =>7
		//EX2:  -3, 0, -5 (S; S; S; SE; SE; SE; SE; SE) =>8
		//EX3:  -1, 1, -5 (SE; SE; SE; SE; SE; SE) => 6
		//EX4: -4, -5, -6 = (S; S; S; S; S; S; S; S; S; SE) => 10
		Integer overallNSCounter = (nsCounter * 2) + neswCounter + nwseCounter;
		//-1; -11; -6; -19
		Integer overallEWCounter = neswCounter - nwseCounter;
		// 7; 5; 6; 1

		Integer absoluteNS = Math.abs(overallNSCounter);
		//1; 11; 6; 19
		Integer absoluteEW = Math.abs(overallEWCounter);
		//7; 5; 6; 1

		//1, 7
		//11, 5 = (S; S; S; SE; SE; SE; SE; SE) =>8
		//6, 6
		//19, 1 = (S; S; S; S; S; S; S; S; S; SE) => 10
		
		//we're going to pretend something is in the southeast 
		if ((absoluteNS) < absoluteEW) {// more EW than NS
			//1, 7
			// every SE movement adds 1 step and generates 1 E movements and -1
			// N movement
			// every NE movement adds 1 step and generates 1 E movements and 1 N
			// movement
			// every NE+SE movement adds 2 steps and generates 2 E movements and
			// 0 N movement
			// every S movement adds 1 step and generates 0 E movement and 2 S
			// movements

			// SORRY DAN
			Integer stepCounter = 0;
			while (absoluteEW-2 > absoluteNS) {
				absoluteEW = absoluteEW - 2;
				stepCounter = stepCounter + 2;
			}
			while (absoluteEW > 0) {
				absoluteEW = absoluteEW - 1;
				absoluteNS = absoluteNS - 1;
				stepCounter = stepCounter + 1;
			}
			return stepCounter;

//			if (0 == absoluteNS % 2) {
//				// we'll just go southeast twice to finish things off
//				// ??
//				// TODO
//				return 3;//TODO
//			} else if (0 != absoluteNS % 2) {
//				// we'll be going east, then adjust southeast
//				// TODO
//				return 3;//TODO
//			} else {
//				System.out.println("ERROR ODD EVEN ISSUE");
//				return (Integer) null;
//			}

		} else if (((absoluteNS) > absoluteEW)){
			//11, 5 = (S; S; S; SE; SE; SE; SE; SE) =>8
			//19, 1 = (S; S; S; S; S; S; S; S; S; SE) => 10
			Integer stepCounter = 0;
			while (absoluteNS > absoluteEW) {
				absoluteNS = absoluteNS - 2;
				stepCounter = stepCounter + 1;
			}
			while (absoluteNS > 0) {
				absoluteEW = absoluteEW - 1;
				absoluteNS = absoluteNS - 1;
				stepCounter = stepCounter + 1;
			}
			return stepCounter;
		} else if (((absoluteNS).equals(absoluteEW))){
			//6, 6
			return absoluteNS;//or EW
		} else {
			System.out.println(absoluteNS);
			System.out.println(absoluteEW);
			System.out.println("ABSOLUTE DIRECTION EVEN ISSUE");
			return (Integer) null;
		}


	}

}

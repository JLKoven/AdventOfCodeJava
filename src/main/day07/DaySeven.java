package main.day07;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.GeneralFunction;

public class DaySeven {

	public static void executeStandardPart1() {
		// Wandering further through the circuits of the computer, you come upon
		// a tower of programs that have gotten themselves into a bit of
		// trouble. A recursive algorithm has gotten out of hand, and now
		// they're balanced precariously in a large tower.
		//
		// One program at the bottom supports the entire tower. It's holding a
		// large disc, and on the disc are balanced several more sub-towers. At
		// the bottom of these sub-towers, standing on the bottom disc, are
		// other programs, each holding their own disc, and so on. At the very
		// tops of these sub-sub-sub-...-towers, many programs stand simply
		// keeping the disc below them balanced but with no disc of their own.
		//
		// You offer to help, but first you need to understand the structure of
		// these towers. You ask each program to yell out their name, their
		// weight, and (if they're holding a disc) the names of the programs
		// immediately above them balancing on that disc. You write this
		// information down (your puzzle input). Unfortunately, in their panic,
		// they don't do this in an orderly fashion; by the time you're done,
		// you're not sure which program gave which information.
		//
		// For example, if your list is the following:
		//
		// pbga (66)
		// xhth (57)
		// ebii (61)
		// havc (66)
		// ktlj (57)
		// fwft (72) -> ktlj, cntj, xhth
		// qoyq (66)
		// padx (45) -> pbga, havc, qoyq
		// tknk (41) -> ugml, padx, fwft
		// jptl (61)
		// ugml (68) -> gyxo, ebii, jptl
		// gyxo (61)
		// cntj (57)
		// ...then you would be able to recreate the structure of the towers
		// that looks like this:
		//
		// gyxo
		// /
		// ugml - ebii
		// / \
		// | jptl
		// |
		// | pbga
		// / /
		// tknk --- padx - havc
		// \ \
		// | qoyq
		// |
		// | ktlj
		// \ /
		// fwft - cntj
		// \
		// xhth
		// In this example, tknk is at the bottom of the tower (the bottom
		// program), and is holding up ugml, padx, and fwft. Those programs are,
		// in turn, holding up other programs; in this example, none of those
		// programs are holding up any other programs, and are all the tops of
		// their own towers. (The actual tower balancing in front of you is much
		// larger.)
		//
		// Before you're ready to help them, you need to make sure your
		// information is correct. What is the name of the bottom program?
		System.out.println("Day 7 Part 1");
		File file = new File("src/main/day07/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(getStandardInputDaySeven(uri)) + ".");

	}

	public static void executeStandardPart2() {
		// --- Part Two ---
		// The programs explain the situation: they can't get down. Rather, they
		// could get down, if they weren't expending all of their energy trying
		// to keep the tower balanced. Apparently, one program has the wrong
		// weight, and until it's fixed, they're stuck here.
		//
		// For any program holding a disc, each program standing on that disc
		// forms a sub-tower. Each of those sub-towers are supposed to be the
		// same weight, or the disc itself isn't balanced. The weight of a tower
		// is the sum of the weights of the programs in that tower.
		//
		// In the example above, this means that for ugml's disc to be balanced,
		// gyxo, ebii, and jptl must all have the same weight, and they do: 61.
		//
		// However, for tknk to be balanced, each of the programs standing on
		// its disc and all programs above it must each match. This means that
		// the following sums must all be the same:
		//
		// ugml + (gyxo + ebii + jptl) = 68 + (61 + 61 + 61) = 251
		// padx + (pbga + havc + qoyq) = 45 + (66 + 66 + 66) = 243
		// fwft + (ktlj + cntj + xhth) = 72 + (57 + 57 + 57) = 243
		// As you can see, tknk's disc is unbalanced: ugml's stack is heavier
		// than the other two. Even though the nodes above ugml are balanced,
		// ugml itself is too heavy: it needs to be 8 units lighter for its
		// stack to weigh 243 and keep the towers balanced. If this change were
		// made, its weight would be 60.
		//
		// Given that exactly one program is the wrong weight, what would its
		// weight need to be to balance the entire tower?
		System.out.println("Day 7 Part 2");
		File file = new File("src/main/day07/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is " + getAnswerPartTwoImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}

	// Imperative

	public static String getAnswerPartOneImperative(List<DiscForTowerImperative> outputTower) {
		switchBase(outputTower);
		String stringToReturn = outputTower.get(0).getName();
		return stringToReturn ;
	}

	public static void switchBase(List<DiscForTowerImperative> tower) {

		Set<String> visited = new HashSet<>();
		int baseIndex = 0;
		for (int i = 0; i < tower.size(); i++) {
			if (!tower.get(i).getNamesOfDescendants().isEmpty()) {
				for (String name : tower.get(i).getNamesOfDescendants()) {
					visited.add(name);
				}
			}
		}
		for (int i = 0; i < tower.size(); i++) {
			if (!visited.contains(tower.get(i).getName())){
				baseIndex = i;
			}
		}
		if (baseIndex!=0){
			DiscForTowerImperative tempDisc = tower.get(0);
			tower.set(0, tower.get(baseIndex));
			tower.set(baseIndex, tempDisc);
		}


	}

	public static List<DiscForTowerImperative> generateListOfDiscsFromStringInput(List<String> stringInput) {
		List<DiscForTowerImperative> resultingTower = new ArrayList<DiscForTowerImperative>();
		for (int i = 0; i < stringInput.size(); i++) {
			String[] parts = stringInput.get(i).split("->");
			String source = parts[0];
			DiscForTowerImperative newDisc = new DiscForTowerImperative();
			String[] sourceParts = source.split(" ");
			newDisc.setName(sourceParts[0]);
			newDisc.setValue(Integer.parseInt(GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1])));
			if (parts.length > 1) {
				String results = parts[1];
				String[] resultsParts = results.split(", ");
				resultsParts[0] = GeneralFunction.removeWhitespace(resultsParts[0]);
				List<String> listOfNames = newDisc.getNamesOfDescendants();
				for (int v = 0; v < resultsParts.length; v++) {
					listOfNames.add(resultsParts[v]);
				}
				newDisc.setNamesOfDescendants(listOfNames);
			}
			resultingTower.add(newDisc);

		}

		Map<String, DiscForTowerImperative> dictionary = new HashMap<>();
		for (DiscForTowerImperative disc : resultingTower){
			dictionary.put(disc.getName(), disc);
		}
		
		for (DiscForTowerImperative disc : resultingTower) {
			List<DiscForTowerImperative> nodesToSet = new ArrayList<>();
			for (String name : disc.getNamesOfDescendants()) {
				nodesToSet.add(dictionary.get(name));
			}
			disc.setDescendants(nodesToSet);
		}

		return resultingTower;

	}

	public static Integer getAnswerPartTwoImperative(List<String> defaultInput) {
		Integer intToReturn = 0;

		List<DiscForTowerImperative> listForTower = generateListOfDiscsFromStringInput(defaultInput);

		for (DiscForTowerImperative disc : listForTower) {

			if (disc.isUnbalanced()) {
				intToReturn =

						(disc.getStandardValueOfChildren() > disc.getDiscrepantDisc().getSumValue())

								? disc.getDiscrepantDisc().getValue() + Math.abs(disc.getDiscrepancyValue())
								: disc.getDiscrepantDisc().getValue() - Math.abs(disc.getDiscrepancyValue());

				break;

			}

		}

		return intToReturn;
	}

	private static List<DiscForTowerImperative> getStandardInputDaySeven(URI filename) {

		List<String> defaultInput = GeneralFunction.getStandardInputListOfStrings(filename);

		List<DiscForTowerImperative> listForTower = generateListOfDiscsFromStringInput(defaultInput);


		return listForTower;
	}



}

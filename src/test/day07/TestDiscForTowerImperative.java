package test.day07;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.day07.DaySeven;
import main.day07.DiscForTowerImperative;

public class TestDiscForTowerImperative {
	
	@Test
	public void testDirectValueOfChildren() {
		List<String> stringInput = new ArrayList<>();
		stringInput.add("pbga (66)");
		stringInput.add("xhth (57)");
		stringInput.add("ebii (61)");
		stringInput.add("havc (66)");
		stringInput.add("ktlj (57)");
		stringInput.add("fwft (72) -> ktlj, cntj, xhth");
		stringInput.add("qoyq (66)");
		stringInput.add("padx (45) -> pbga, havc, qoyq");
		stringInput.add("tknk (41) -> ugml, padx, fwft");
		stringInput.add("jptl (61)");
		stringInput.add("ugml (68) -> gyxo, ebii, jptl");
		stringInput.add("gyxo (61)");
		stringInput.add("cntj (57)");
		List<DiscForTowerImperative> discTower = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(discTower);
		Map<String, DiscForTowerImperative> dictionary = new HashMap<>();
		for (DiscForTowerImperative disc : discTower){
			dictionary.put(disc.getName(), disc);
		}

		assertEquals(discTower.get(0).directValueOfChildren(dictionary)==185, true);
		System.out.println("Success on Day7.testDirectValueOfChildren!");
	}

	
	@Test
	public void testGetSumValue() {
		List<String> stringInput = new ArrayList<>();
		stringInput.add("pbga (66)");
		stringInput.add("xhth (57)");
		stringInput.add("ebii (61)");
		stringInput.add("havc (66)");
		stringInput.add("ktlj (57)");
		stringInput.add("fwft (72) -> ktlj, cntj, xhth");
		stringInput.add("qoyq (66)");
		stringInput.add("padx (45) -> pbga, havc, qoyq");
		stringInput.add("tknk (41) -> ugml, padx, fwft");
		stringInput.add("jptl (61)");
		stringInput.add("ugml (68) -> gyxo, ebii, jptl");
		stringInput.add("gyxo (61)");
		stringInput.add("cntj (57)");
		List<DiscForTowerImperative> discTower = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(discTower);


		assertEquals(discTower.get(0).getSumValue()==778, true);
		System.out.println("Success on Day7.testGetSumValue!");
	}

	
	@Test
	public void testSumValueOfChildren() {
		List<String> stringInput = new ArrayList<>();
		stringInput.add("pbga (66)");
		stringInput.add("xhth (57)");
		stringInput.add("ebii (61)");
		stringInput.add("havc (66)");
		stringInput.add("ktlj (57)");
		stringInput.add("fwft (72) -> ktlj, cntj, xhth");
		stringInput.add("qoyq (66)");
		stringInput.add("padx (45) -> pbga, havc, qoyq");
		stringInput.add("tknk (41) -> ugml, padx, fwft");
		stringInput.add("jptl (61)");
		stringInput.add("ugml (68) -> gyxo, ebii, jptl");
		stringInput.add("gyxo (61)");
		stringInput.add("cntj (57)");
		List<DiscForTowerImperative> discTower = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(discTower);

		assertEquals(discTower.get(0).sumValueOfChildren()==737, true);
		System.out.println("Success on Day7.testSumValueOfChildren!");
	}

	@Test
	public void testIsUnbalanced() {
		List<String> stringInput = new ArrayList<>();
		stringInput.add("pbga (66)");
		stringInput.add("xhth (57)");
		stringInput.add("ebii (61)");
		stringInput.add("havc (66)");
		stringInput.add("ktlj (57)");
		stringInput.add("fwft (72) -> ktlj, cntj, xhth");
		stringInput.add("qoyq (66)");
		stringInput.add("padx (45) -> pbga, havc, qoyq");
		stringInput.add("tknk (41) -> ugml, padx, fwft");
		stringInput.add("jptl (61)");
		stringInput.add("ugml (68) -> gyxo, ebii, jptl");
		stringInput.add("gyxo (61)");
		stringInput.add("cntj (57)");
		List<DiscForTowerImperative> discTower = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(discTower);

		assertEquals(discTower.get(0).isUnbalanced(), true);
		System.out.println("Success on Day7.testIsUnbalanced!");
	}

	
	@Test
	public void testGetDiscrepancyValue() {
		List<String> stringInput = new ArrayList<>();
		stringInput.add("pbga (66)");
		stringInput.add("xhth (57)");
		stringInput.add("ebii (61)");
		stringInput.add("havc (66)");
		stringInput.add("ktlj (57)");
		stringInput.add("fwft (72) -> ktlj, cntj, xhth");
		stringInput.add("qoyq (66)");
		stringInput.add("padx (45) -> pbga, havc, qoyq");
		stringInput.add("tknk (41) -> ugml, padx, fwft");
		stringInput.add("jptl (61)");
		stringInput.add("ugml (68) -> gyxo, ebii, jptl");
		stringInput.add("gyxo (61)");
		stringInput.add("cntj (57)");
		List<DiscForTowerImperative> discTower = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(discTower);

		assertEquals(discTower.get(0).getDiscrepancyValue() == 8, true);
		System.out.println("Success on Day7.testGetDiscrepancyValue!");
	}

	@Test
	public void testGetStandardValueOfChildren() {
		List<String> stringInput = new ArrayList<>();
		stringInput.add("pbga (66)");
		stringInput.add("xhth (57)");
		stringInput.add("ebii (61)");
		stringInput.add("havc (66)");
		stringInput.add("ktlj (57)");
		stringInput.add("fwft (72) -> ktlj, cntj, xhth");
		stringInput.add("qoyq (66)");
		stringInput.add("padx (45) -> pbga, havc, qoyq");
		stringInput.add("tknk (41) -> ugml, padx, fwft");
		stringInput.add("jptl (61)");
		stringInput.add("ugml (68) -> gyxo, ebii, jptl");
		stringInput.add("gyxo (61)");
		stringInput.add("cntj (57)");
		List<DiscForTowerImperative> discTower = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(discTower);

		assertEquals(discTower.get(0).getStandardValueOfChildren() == 243, true);
		System.out.println("Success on Day7.testGetStandardValueOfChildren()!");
	}

	
	@Test
	public void testGetDiscrepantDisc() {
		List<String> stringInput = new ArrayList<>();
		stringInput.add("pbga (66)");
		stringInput.add("xhth (57)");
		stringInput.add("ebii (61)");
		stringInput.add("havc (66)");
		stringInput.add("ktlj (57)");
		stringInput.add("fwft (72) -> ktlj, cntj, xhth");
		stringInput.add("qoyq (66)");
		stringInput.add("padx (45) -> pbga, havc, qoyq");
		stringInput.add("tknk (41) -> ugml, padx, fwft");
		stringInput.add("jptl (61)");
		stringInput.add("ugml (68) -> gyxo, ebii, jptl");
		stringInput.add("gyxo (61)");
		stringInput.add("cntj (57)");
		List<DiscForTowerImperative> discTower = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(discTower);

		assertEquals(discTower.get(0).getDiscrepantDisc().getName().equals("ugml"), true);
		System.out.println("Success on Day7.testGetDiscrepantDisc!");
	}




}

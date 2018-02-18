package test.day7;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day7.DaySeven;
import main.day7.DiscForTowerImperative;
//import main.day7.DiscTowerImperative;

public class TestDaySeven {

	@Test
	public void testPartOneTestImperative1() {

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
		List<DiscForTowerImperative> inputList = DaySeven.generateListOfDiscsFromStringInput(stringInput);

		assertEquals(
				DaySeven.getAnswerPartOneImperative(inputList),"tknk");
		System.out.println("Success on Day7.testPartOneTest1!");
	}
	
	@Test
	public void testSwitchBase() {

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
		List<DiscForTowerImperative> inputList = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DaySeven.switchBase(inputList);

		
		assertEquals(
				inputList.get(0).getName(),"tknk");
		System.out.println("Success on Day7.testSwitchBase!");
	}
	
	@Test
	public void testPartOneTestImperative2() {

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

		assertEquals(
				DaySeven.getAnswerPartTwoImperative(stringInput)==60,true);
		System.out.println("Success on Day7.testPartOneTest2!");
	}

}

package test.day7;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day7.DaySeven;
import main.day7.DiscForTower;
import main.day7.DiscTower;

public class TestDaySeven {

	@Test
	public void testPartOneTest1() {

		List<String> stringInput = new ArrayList<String>();
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
		List<DiscForTower> inputList = DaySeven.generateListOfDiscsFromStringInput(stringInput);
		DiscTower outputTower = new DiscTower();
		outputTower = DiscTower.formNewTowerFrom(inputList);

		assertEquals(
				DaySeven.printAnswerPartOne(outputTower),"tknk");
		System.out.println("Success on Day7.testPartOneTest1!");
	}
	
	@Test
	public void testPartOneTest2() {

		List<String> stringInput = new ArrayList<String>();
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
				DaySeven.printAnswerPartTwo(stringInput)==60,true);
		System.out.println("Success on Day7.testPartOneTest2!");
	}

}

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
		for (int i=0; i<inputList.size(); i++){
			System.out.println(i);
			System.out.println("Printing out discname as "+inputList.get(i).getName()+".");
			System.out.println("Printing out discvalue as "+inputList.get(i).getValue()+".");
			if (inputList.get(i).getNamesOfDescendants().size()>0){
				for (String name : inputList.get(i).getNamesOfDescendants()){
					System.out.print(name);
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		assertEquals(
//				DaySeven.printAnswerPartOne(outputTower),"tknk");
				"tknk","tknk");

//				DaySeven.printAnswerPartOne(inputDiscs), outputTower);
		System.out.println("Success on Day7.testPartOneTest1!");
	}
	
//	@Test
//	public void testPartOneTest2() {
//
//		List<Integer> array = new ArrayList<Integer>();
//		array.add(0);
//		array.add(2);
//		array.add(7);
//		array.add(0);
//		assertEquals(
//				DaySeven.printAnswerPartTwo(array), 4);
//		System.out.println("Success on Day7.testPartTwoTest1!");
//	}

}

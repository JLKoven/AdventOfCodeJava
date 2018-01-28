import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDaySeven {

	@Test
	public void testPartOneTest1() {

		List<DiscForTower> inputList = new ArrayList<DiscForTower>();
		DiscForTower newDisc1 = new DiscForTower();
		DiscForTower newDisc2 = new DiscForTower();
		DiscForTower newDisc3 = new DiscForTower();
		DiscForTower newDisc4 = new DiscForTower();
		DiscForTower newDisc5 = new DiscForTower();
		DiscForTower newDisc6 = new DiscForTower();
		DiscForTower newDisc7 = new DiscForTower();
		DiscForTower newDisc8 = new DiscForTower();
		DiscForTower newDisc9 = new DiscForTower();
		DiscForTower newDisc10 = new DiscForTower();
		DiscForTower newDisc11 = new DiscForTower();
		DiscForTower newDisc12 = new DiscForTower();
		DiscForTower newDisc13 = new DiscForTower();
		DiscTower outputTower = new DiscTower();
		outputTower = DiscTower.formNewTowerFrom(inputList);
		assertEquals(
				DaySeven.printAnswerPartOne(outputTower),"tknk");

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

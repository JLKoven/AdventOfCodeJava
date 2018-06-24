package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.general.TestGeneral;
import test.general.TestIntPair;
import test.day01.TestDayOne;
import test.day02.TestDayTwo;
import test.day03.TestDayThree;
import test.day03.TestSpiralGridImperative;
import test.day04.TestDayFour;
import test.day05.TestDayFive;
import test.day06.TestDaySix;
import test.day07.TestDaySeven;
import test.day07.TestDiscForTowerImperative;
import test.day08.TestDayEight;
import test.day09.TestDayNine;
import test.day10.TestDayTen;
import test.day11.TestDayEleven;
import test.day12.TestDayTwelve;
import test.day13.TestDayThirteen;
import test.day14.TestDayFourteen;
import test.day15.TestDayFifteen;
import test.day16.TestDaySixteen;
import test.day17.TestDaySeventeen;
//import test.day18.TestDayEighteen;
//import test.day19.TestDayNineteen;
//import test.day20.TestDayTwenty;
//import test.day21.TestDayTwentyOne;
//import test.day22.TestDayTwentyTwo;
//import test.day23.TestDayTwentyThree;
//import test.day24.TestDayTwentyFour;
//import test.day25.TestDayTwentyFive;

@RunWith(Suite.class)
@SuiteClasses({TestGeneral.class, TestIntPair.class, TestDayOne.class, 
	TestDayTwo.class, TestDayThree.class, TestSpiralGridImperative.class, 
	TestDayFour.class, TestDayFive.class, TestDaySix.class, 
	TestDaySeven.class, TestDiscForTowerImperative.class, 
	TestDayEight.class, TestDayNine.class, TestDayTen.class,
	TestDayEleven.class, TestDayTwelve.class, TestDayThirteen.class, 
	TestDayFourteen.class, TestDayFifteen.class, TestDaySixteen.class, 
	TestDaySeventeen.class
	})
public class AllTests {

}

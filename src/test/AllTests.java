package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.general.TestGeneralFunction;
import test.general.TestIntPair;
import test.general.TestMathFunction;
import test.year2017.day01.TestDayOne;
import test.year2017.day02.TestDayTwo;
import test.year2017.day03.TestDayThree;
import test.year2017.day03.TestSpiralGridImperative;
import test.year2017.day04.TestDayFour;
import test.year2017.day05.TestDayFive;
import test.year2017.day06.TestDaySix;
import test.year2017.day07.TestDaySeven;
import test.year2017.day07.TestDiscForTowerImperative;
import test.year2017.day08.TestDayEight;
import test.year2017.day09.TestDayNine;
import test.year2017.day10.TestDayTen;
import test.year2017.day11.TestDayEleven;
import test.year2017.day12.TestDayTwelve;
import test.year2017.day13.TestDayThirteen;
import test.year2017.day14.TestDayFourteen;
import test.year2017.day15.TestDayFifteen;
import test.year2017.day16.TestDaySixteen;
import test.year2017.day17.TestDaySeventeen;
import test.year2017.day18.TestDayEighteen;
import test.year2017.day19.TestDayNineteen;

@RunWith(Suite.class)
@SuiteClasses({TestGeneralFunction.class, TestIntPair.class, 
	TestMathFunction.class,
	TestDayOne.class, 
	TestDayTwo.class, TestDayThree.class, TestSpiralGridImperative.class, 
	TestDayFour.class, TestDayFive.class, TestDaySix.class, 
	TestDaySeven.class, TestDiscForTowerImperative.class, 
	TestDayEight.class, TestDayNine.class, TestDayTen.class,
	TestDayEleven.class, TestDayTwelve.class, TestDayThirteen.class, 
	TestDayFourteen.class, TestDayFifteen.class, TestDaySixteen.class, 
	TestDaySeventeen.class, TestDayEighteen.class, TestDayNineteen.class
	})
public class AllTests {

}

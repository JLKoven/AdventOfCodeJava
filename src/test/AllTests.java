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

@RunWith(Suite.class)
@SuiteClasses({TestGeneral.class, TestIntPair.class, TestDayOne.class, 
	TestDayTwo.class, TestDayThree.class, TestSpiralGridImperative.class, 
	TestDayFour.class, TestDayFive.class, TestDaySix.class, 
	TestDaySeven.class, TestDiscForTowerImperative.class, 
	TestDayEight.class, TestDayNine.class, TestDayTen.class,
	TestDayEleven.class, TestDayTwelve.class
	})
public class AllTests {

}

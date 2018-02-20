package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.general.TestGeneral;
import test.general.TestIntPair;
import test.day1.TestDayOne;
import test.day2.TestDayTwo;
import test.day3.TestDayThree;
import test.day3.TestSpiralGridImperative;
import test.day4.TestDayFour;
import test.day5.TestDayFive;
import test.day6.TestDaySix;
import test.day7.TestDaySeven;
import test.day7.TestDiscForTowerImperative;
import test.day8.TestDayEight;

@RunWith(Suite.class)
@SuiteClasses({TestGeneral.class, TestIntPair.class, TestDayOne.class, TestDayTwo.class, TestDayThree.class, TestSpiralGridImperative.class, TestDayFour.class, TestDayFive.class, TestDaySix.class, TestDaySeven.class, TestDiscForTowerImperative.class, TestDayEight.class})
public class AllTests {

}

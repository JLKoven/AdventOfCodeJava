package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.day1.TestDayOne;
import test.day2.TestDayTwo;
import test.day3.TestDayThree;
import test.day4.TestDayFour;
import test.day5.TestDayFive;
import test.day6.TestDaySix;
import test.day7.TestDaySeven;

@RunWith(Suite.class)
@SuiteClasses({TestDayOne.class, TestDayTwo.class, TestDayThree.class, TestDayFour.class, TestDayFive.class, TestDaySix.class, TestDaySeven.class})
public class AllTests {

}

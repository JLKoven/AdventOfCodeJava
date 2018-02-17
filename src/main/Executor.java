package main;

import main.day1.DayOne;
import main.day2.DayTwo;
import main.day3.DayThree;
import main.day4.DayFour;
import main.day5.DayFive;
import main.day6.DaySix;
import main.day7.DaySeven;

public class Executor {

	public static void main(String[] args) {

		DayOne.executeStandardPart1();
		DayOne.executeStandardPart2();

		DayTwo.executeStandardPart1();
		DayTwo.executeStandardPart2();

		DayThree.executeStandardPart1();//long runtime
		DayThree.executeStandardPart2();
		
		DayFour.executeStandardPart1();
		DayFour.executeStandardPart2();

		DayFive.executeStandardPart1();
		DayFive.executeStandardPart2();
		
		DaySix.executeStandardPart1();
		DaySix.executeStandardPart2();
		
		DaySeven.executeStandardPart1();
		DaySeven.executeStandardPart2();

	}
}

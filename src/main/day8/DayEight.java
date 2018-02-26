package main.day8;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.GeneralFunction;

public class DayEight {

	public static void executeStandardPart1() {
		// You receive a signal directly from the CPU. Because of your recent
		// assistance with jump instructions, it would like you to compute the
		// result of a series of unusual register instructions.
		//
		// Each instruction consists of several parts: the register to modify,
		// whether to increase or decrease that register's value, the amount by
		// which to increase or decrease it, and a condition. If the condition
		// fails, skip the instruction without modifying the register. The
		// registers all start at 0. The instructions look like this:
		//
		// b inc 5 if a > 1
		// a inc 1 if b < 5
		// c dec -10 if a >= 1
		// c inc -20 if c == 10
		// These instructions would be processed as follows:
		//
		// Because a starts at 0, it is not greater than 1, and so b is not
		// modified.
		// a is increased by 1 (to 1) because b is less than 5 (it is 0).
		// c is decreased by -10 (to 10) because a is now greater than or equal
		// to 1 (it is 1).
		// c is increased by -20 (to -10) because c is equal to 10.
		// After this process, the largest value in any register is 1.
		//
		// You might also encounter <= (less than or equal to) or != (not equal
		// to). However, the CPU doesn't have the bandwidth to tell you what all
		// the registers are named, and leaves that to you to determine.
		//
		// What is the largest value in any register after completing the
		// instructions in your puzzle input?
		System.out.println("Day 8 Part 1");
		File file = new File("src/main/day8/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}

	public static void executeStandardPart2() {
		// You receive a signal directly from the CPU. Because of your recent
		// assistance with jump instructions, it would like you to compute the
		// result of a series of unusual register instructions.
		//
		// Each instruction consists of several parts: the register to modify,
		// whether to increase or decrease that register's value, the amount by
		// which to increase or decrease it, and a condition. If the condition
		// fails, skip the instruction without modifying the register. The
		// registers all start at 0. The instructions look like this:
		//
		// b inc 5 if a > 1
		// a inc 1 if b < 5
		// c dec -10 if a >= 1
		// c inc -20 if c == 10
		// These instructions would be processed as follows:
		//
		// Because a starts at 0, it is not greater than 1, and so b is not
		// modified.
		// a is increased by 1 (to 1) because b is less than 5 (it is 0).
		// c is decreased by -10 (to 10) because a is now greater than or equal
		// to 1 (it is 1).
		// c is increased by -20 (to -10) because c is equal to 10.
		// After this process, the largest value in any register is 1.
		//
		// You might also encounter <= (less than or equal to) or != (not equal
		// to). However, the CPU doesn't have the bandwidth to tell you what all
		// the registers are named, and leaves that to you to determine.
		//
		// What is the largest value in any register after completing the
		// instructions in your puzzle input?
		System.out.println("Day 8 Part 2");
		File file = new File("src/main/day8/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is " + getAnswerPartTwoImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}

	// Imperative

	public static Integer getAnswerPartOneImperative(List<String> input) {
		Map<String, Integer> registers = new HashMap<>();
		initializeRegisters(registers, input);

		for (int i = 0; i < input.size(); i++) {
			String line = input.get(i);
			String[] parts = line.split("\\s+");
			String register = parts[0];
			String operation = parts[1];
			String value = parts[2];
			// String condition = parts[3];
			String conditionRegister = parts[4];
			String conditionBoolean = parts[5];
			String conditionValue = parts[6];
			if (conditionTrue(registers, conditionRegister, conditionBoolean, conditionValue)) {
				doOperation(registers, register, operation, value);
			}
		}

		Integer highestRegister = Integer.MIN_VALUE;
		for (Integer value : registers.values()) {
			if (value > highestRegister) {
				highestRegister = value;
			}
		}

		return highestRegister;
	}

	private static boolean conditionTrue(Map<String, Integer> registers, String conditionRegister,
			String conditionBoolean, String conditionValue) {
		boolean boolToReturn = false;
		if (">=".equals(conditionBoolean)) {
			if (registers.get(conditionRegister) >= Integer.parseInt(conditionValue)) {
				boolToReturn = true;
			}
		} else if (">".equals(conditionBoolean)) {
			if (registers.get(conditionRegister) > Integer.parseInt(conditionValue)) {
				boolToReturn = true;
			}
		} else if ("<=".equals(conditionBoolean)) {
			if (registers.get(conditionRegister) <= Integer.parseInt(conditionValue)) {
				boolToReturn = true;
			}
		} else if ("<".equals(conditionBoolean)) {
			if (registers.get(conditionRegister) < Integer.parseInt(conditionValue)) {
				boolToReturn = true;
			}
		} else if ("==".equals(conditionBoolean)) {
			if (registers.get(conditionRegister) == Integer.parseInt(conditionValue)) {
				boolToReturn = true;
			}
		} else if ("!=".equals(conditionBoolean)) {
			if (registers.get(conditionRegister) != Integer.parseInt(conditionValue)) {
				boolToReturn = true;
			}
		} else {
			System.out.println("whoa, new operand");
			System.out.println(conditionBoolean);
		}
		return boolToReturn;
	}

	private static void doOperation(Map<String, Integer> registers, String register, String operation, String value) {
		if ("inc".equals(operation)) {
			int oldValue = registers.get(register);
			int newValue = oldValue + Integer.parseInt(value);
			registers.put(register, newValue);
		} else if ("dec".equals(operation)) {
			int oldValue = registers.get(register);
			int newValue = oldValue - Integer.parseInt(value);
			registers.put(register, newValue);
		} else {
			System.out.println("whoa, new operation");
			System.out.println(operation);
		}
	}

	private static void initializeRegisters(Map<String, Integer> registers, List<String> input) {
		for (int i = 0; i < input.size(); i++) {
			String register = getFirstString(input.get(i));
			registers.put(register, 0);
		}

	}

	 public static Integer getAnswerPartTwoImperative(List<String>
	 input) {
			Map<String, Integer> registers = new HashMap<>();
			initializeRegisters(registers, input);

			Integer highestRegister = Integer.MIN_VALUE;

			for (int i = 0; i < input.size(); i++) {
				String line = input.get(i);
				String[] parts = line.split("\\s+");
				String register = parts[0];
				String operation = parts[1];
				String value = parts[2];
				// String condition = parts[3];
				String conditionRegister = parts[4];
				String conditionBoolean = parts[5];
				String conditionValue = parts[6];
				if (conditionTrue(registers, conditionRegister, conditionBoolean, conditionValue)) {
					highestRegister = doOperationUpdateRegister(registers, register, operation, value, highestRegister);
				}
			}

			return highestRegister;
	 }

	private static Integer doOperationUpdateRegister(Map<String, Integer> registers, String register, String operation,
			String value, Integer highestRegister) {
		Integer intToReturn = highestRegister;
		Integer newValue = 0;
		if ("inc".equals(operation)) {
			int oldValue = registers.get(register);
			newValue = oldValue + Integer.parseInt(value);
			registers.put(register, newValue);
		} else if ("dec".equals(operation)) {
			int oldValue = registers.get(register);
			newValue = oldValue - Integer.parseInt(value);
			registers.put(register, newValue);
		} else {
			System.out.println("whoa, new operation");
			System.out.println(operation);
			Exception error = new Exception();
			try {
				throw error;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (newValue > highestRegister){
			intToReturn = newValue;
		}
		return intToReturn;
	}

	private static String getFirstString(String line) {
		String[] parts = line.split("\\s+");
		String first = parts[0];
		// TODO Auto-generated method stub
		return first;
	}



}

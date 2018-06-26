package main.day18;

import java.io.File;
import java.math.BigInteger;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.GeneralFunction;

public class DayEighteen {

	public static void executeStandardPart1() {
//		--- Day 18: Duet ---
//		You discover a tablet containing some strange assembly code labeled simply "Duet". Rather than bother the sound card with it, you decide to run the code yourself. Unfortunately, you don't see any documentation, so you're left to figure out what the instructions mean on your own.
//
//		It seems like the assembly is meant to operate on a set of registers that are each named with a single letter and that can each hold a single integer. You suppose each register should start with a value of 0.
//
//		There aren't that many instructions, so it shouldn't be hard to figure out what they do. Here's what you determine:
//
//		snd X plays a sound with a frequency equal to the value of X.
//		set X Y sets register X to the value of Y.
//		add X Y increases register X by the value of Y.
//		mul X Y sets register X to the result of multiplying the value contained in register X by the value of Y.
//		mod X Y sets register X to the remainder of dividing the value contained in register X by the value of Y (that is, it sets X to the result of X modulo Y).
//		rcv X recovers the frequency of the last sound played, but only when the value of X is not zero. (If it is zero, the command does nothing.)
//		jgz X Y jumps with an offset of the value of Y, but only if the value of X is greater than zero. (An offset of 2 skips the next instruction, an offset of -1 jumps to the previous instruction, and so on.)
//		Many of the instructions can take either a register (a single letter) or a number. The value of a register is the integer it contains; the value of a number is that number.
//
//		After each jump instruction, the program continues with the instruction to which the jump jumped. After any other instruction, the program continues with the next instruction. Continuing (or jumping) off either end of the program terminates it.
//
//		For example:
//
//		set a 1
//		add a 2
//		mul a a
//		mod a 5
//		snd a
//		set a 0
//		rcv a
//		jgz a -1
//		set a 1
//		jgz a -2
//		The first four instructions set a to 1, add 2 to it, square it, and then set it to itself modulo 5, resulting in a value of 4.
//		Then, a sound with frequency 4 (the value of a) is played.
//		After that, a is set to 0, causing the subsequent rcv and jgz instructions to both be skipped (rcv because a is 0, and jgz because a is not greater than 0).
//		Finally, a is set to 1, causing the next jgz instruction to activate, jumping back two instructions to another jump, which jumps again to the rcv, which ultimately triggers the recover operation.
//		At the time the recover operation is executed, the frequency of the last sound played is 4.
//
//		What is the value of the recovered frequency (the value of the most recently played sound) the first time a rcv instruction is executed with a non-zero value?

		System.out.println("Day 18 Part 1");
		File file = new File("src/main/day18/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}

	public static BigInteger getAnswerPartOneImperative(List<String> tabletInstructions) {
		Map<Character, BigInteger> registerSound = new HashMap<>();
		registerSound = initializeInstructions(tabletInstructions);
		boolean terminated = false;
		int currentIndex = 0;
		BigInteger lastPlayedSound =  BigInteger.valueOf(0);
		while (!terminated) {
			/*
			currentIndex = processInstruction(tabletInstructions, registerSound, terminated, currentIndex);
			*/
			//get string to process
			String stringToProcess = tabletInstructions.get(currentIndex);
			//figure out what it wants to do 
			String[] processInstructions = stringToProcess.split("\\s+");			
			if ("snd".equals(processInstructions[0])){
				lastPlayedSound = registerSound.get(processInstructions[1].charAt(0));
				currentIndex++;
			} else if ("set".equals(processInstructions[0])){
				BigInteger value = BigInteger.valueOf(0);
				if (processInstructions[2].matches(".*[a-zA-Z]+.*")){
					value = registerSound.get(processInstructions[2].charAt(0));
				} else {
					value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
				}
				registerSound.put(processInstructions[1].charAt(0), value);
				currentIndex++;
			} else if ("add".equals(processInstructions[0])){
				BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
				BigInteger value = BigInteger.valueOf(0);
				if (processInstructions[2].matches(".*[a-zA-Z]+.*")){
					value = registerSound.get(processInstructions[2].charAt(0));
				} else {
					value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
				}
				BigInteger newValue = oldValue.add(value);
				registerSound.put(processInstructions[1].charAt(0), newValue );
				currentIndex++;
			} else if ("mul".equals(processInstructions[0])){
				BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
				BigInteger value = BigInteger.valueOf(0);
				if (processInstructions[2].matches(".*[a-zA-Z]+.*")){
					value = registerSound.get(processInstructions[2].charAt(0));
				} else {
					value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
				}
				BigInteger newValue = oldValue.multiply(value);
				registerSound.put(processInstructions[1].charAt(0), newValue );
				currentIndex++;
			} else if ("mod".equals(processInstructions[0])){
				BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
				BigInteger value = BigInteger.valueOf(0);
				if (processInstructions[2].matches(".*[a-zA-Z]+.*")){
					value = registerSound.get(processInstructions[2].charAt(0));
				} else {
					value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
				}
				BigInteger newValue = oldValue.mod(value);
				registerSound.put(processInstructions[1].charAt(0), newValue );
				currentIndex++;
			} else if ("rcv".equals(processInstructions[0])){
				if (!(BigInteger.valueOf(0).equals(registerSound.get(processInstructions[1].charAt(0))))){
					terminated = true;
				} else {
					currentIndex++;
				}
			} else if ("jgz".equals(processInstructions[0])){
				if (
						1 == registerSound.get(processInstructions[1].charAt(0)).compareTo(BigInteger.valueOf(0))
						){
					BigInteger value = BigInteger.valueOf(0);
					if (processInstructions[2].matches(".*[a-zA-Z]+.*")){
						value = registerSound.get(processInstructions[2].charAt(0));
					} else {
						value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
					}
					Integer jumpOffSet = value.intValueExact();//DANGEROUS
					if (jumpOffSet > 1){
						currentIndex = currentIndex + jumpOffSet - 1;
					} else {
						currentIndex = currentIndex + jumpOffSet;
					}
				} else {
					currentIndex++;
				}					
			} else {
				System.out.println("ERROR UNRECOGNIZED TABLET INSTRUCTION");
			}
			//do the stuff! 
			//where are we going now? 

		}

		return lastPlayedSound;

	}
	

	private static Map<Character, BigInteger> initializeInstructions(List<String> tabletInstructions) {
		Map<Character, BigInteger> registerSound = new HashMap<>();
		for (String instruction: tabletInstructions){
			String[] instructionSet = instruction.split("\\s+");			
			registerSound.put(instructionSet[1].charAt(0), BigInteger.valueOf(0));
		}
		return registerSound;
	}

//	private static void processInstruction(List<String> tabletInstructions, 
//			Map<Character, Integer> registerSound,
//			boolean terminated, int currentIndex) {
//		//get string to process
//		String stringToProcess = tabletInstructions.get(currentIndex);
//		//figure out what it wants to do 
//		//do the stuff! 
//		//where are we going now? 
//
//	}

}

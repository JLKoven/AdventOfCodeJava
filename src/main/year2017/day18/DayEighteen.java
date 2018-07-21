package main.year2017.day18;

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
		File file = new File("src/main/year2017/day18/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}
	
	public static void executeStandardPart2(){
//		--- Part Two ---
//		As you congratulate yourself for a job well done, you notice that the documentation has been on the back of the tablet this entire time. While you actually got most of the instructions correct, there are a few key differences. This assembly code isn't about sound at all - it's meant to be run twice at the same time.
//
//		Each running copy of the program has its own set of registers and follows the code independently - in fact, the programs don't even necessarily run at the same speed. To coordinate, they use the send (snd) and receive (rcv) instructions:
//
//		snd X sends the value of X to the other program. These values wait in a queue until that program is ready to receive them. Each program has its own message queue, so a program can never receive a message it sent.
//		rcv X receives the next value and stores it in register X. If no values are in the queue, the program waits for a value to be sent to it. Programs do not continue to the next instruction until they have received a value. Values are received in the order they are sent.
//		Each program also has its own program ID (one 0 and the other 1); the register p should begin with this value.
//
//		For example:
//
//		snd 1
//		snd 2
//		snd p
//		rcv a
//		rcv b
//		rcv c
//		rcv d
//		Both programs begin by sending three values to the other. Program 0 sends 1, 2, 0; program 1 sends 1, 2, 1. Then, each program receives a value (both 1) and stores it in a, receives another value (both 2) and stores it in b, and then each receives the program ID of the other program (program 0 receives 1; program 1 receives 0) and stores it in c. Each program now sees a different value in its own copy of register c.
//
//		Finally, both programs try to rcv a fourth time, but no data is waiting for either of them, and they reach a deadlock. When this happens, both programs terminate.
//
//		It should be noted that it would be equally valid for the programs to run at different speeds; for example, program 0 might have sent all three values and then stopped at the first rcv before program 1 executed even its first instruction.
//
//		Once both of your programs have terminated (regardless of what caused them to do so), how many times did program 1 send a value?
			
		
		System.out.println("Day 18 Part 2");
		File file = new File("src/main/year2017/day18/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is "
				+ getAnswerPartTwoImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");
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
	
	public static Integer getAnswerPartTwoImperative(List<String> tabletInstructions) {
		//doesn't work
//		boolean terminated = false;
		int currentIndex = 0;
//		BigInteger lastPlayedSound =  BigInteger.valueOf(0);
		Integer messagesSentByOne = 0;
		Integer instructionsSize = tabletInstructions.size();
		DuetProgram programZero = new DuetProgram();
		DuetProgram programOne = new DuetProgram();
		DuetProgram currentProgram = programZero;
		programOne.setDuetPartner(programZero);
		programZero.setDuetPartner(programOne);
//		Map<Character, BigInteger> registerSoundZero = initializeAZHashMap(BigInteger.valueOf(0));
//		Map<Character, BigInteger> registerSoundOne = initializeAZHashMap(BigInteger.valueOf(1));
		Map<Character, BigInteger> registerSoundZero = initializeInstructions(tabletInstructions, BigInteger.valueOf(0));
		Map<Character, BigInteger> registerSoundOne = initializeInstructions(tabletInstructions, BigInteger.valueOf(1));
		programZero.setRegisterSound(registerSoundZero);
		programOne.setRegisterSound(registerSoundOne);
		programZero.setTabletInstructions(tabletInstructions);
		programOne.setTabletInstructions(tabletInstructions);
		while (
				!((
						programZero.isDone()
						&&
						programOne.isDone()
				)||
						(programZero.isWaiting() && programOne.isWaiting())))
				
				{
			
			//program 0 processes instructions until it can't go further 
			//  (it hits a receive or its length equals the array of instructions) 
			// every time it hits a send, increase the queue of instructions for the other (1) by one 
			// check if it is done
			// mark it as waiting
			//switch to program 1 
			//program 1 processes instructions until it can't go any further 
			//  (it hits a receive or its length equals the array of instructions) 
			// every time it hits a send, increase the queue of instructions for the other (0) by one 
			// check if it is done
			// mark it as waiting
			
//			while (
//					(!(currentProgram.isWaiting()))
//				&&
//				(!currentProgram.isDone())
//			){
//				//process a step
//				currentProgram.processStep(tabletInstructions);
//			} 
//			
//			currentProgram = currentProgram.getDuetPartner();
			
			while (!programZero.isDone() && !programZero.isWaiting()){
//				programZero.processStep(tabletInstructions);
				programZero.processStep();
//				System.out.println("processing program zero");
			}
			
			while (!programOne.isDone() && !programOne.isWaiting()){
//				programOne.processStep(tabletInstructions);
				programOne.processStep();
//				System.out.println("processing program one");
			}
			
			
		}
		return programOne.getMessagesSent();
		
		//	    final DuetProgram programZero = new DuetProgram(tabletInstructions, 0);
//	    final DuetProgram programOne = new DuetProgram(tabletInstructions, 1);
//
//	    programZero.setDuetPartner(programOne);
//	    programOne.setDuetPartner(programZero);
//
//	    while(!((programZero.isDone() && programOne.isDone()) || 
//	    		(programZero.isWaiting() && programOne.isWaiting()))) {
//	        while(!programZero.isDone() && !programZero.isWaiting()) {
////	            programZero.processInstructions();
//	        }
//
//	        while(!programOne.isDone() && !programOne.isWaiting()) {
////	            programOne.processInstructions();
//	        }
//	    }
//
//	    return programOne.getMessagesSent();
	}
	   
	

	private static Map<Character, BigInteger> initializeInstructions(List<String> tabletInstructions,
			BigInteger valueOf) {
		Map<Character, BigInteger> registerSound = new HashMap<>();
		for (String instruction: tabletInstructions){
			String[] instructionSet = instruction.split("\\s+");			
			registerSound.put(instructionSet[1].charAt(0), valueOf);
		}
		return registerSound;	}

//	private static Map<Character, BigInteger> initializeAZHashMap(BigInteger valueOf) {
//		Map<Character, BigInteger> mapToReturn = new HashMap<>();
//		mapToReturn.put('a', valueOf);
//		mapToReturn.put('b', valueOf);
//		mapToReturn.put('c', valueOf);
//		mapToReturn.put('d', valueOf);
//		mapToReturn.put('e', valueOf);
//		mapToReturn.put('f', valueOf);
//		mapToReturn.put('g', valueOf);
//		mapToReturn.put('h', valueOf);
//		mapToReturn.put('i', valueOf);
//		mapToReturn.put('j', valueOf);
//		mapToReturn.put('k', valueOf);
//		mapToReturn.put('l', valueOf);
//		mapToReturn.put('m', valueOf);
//		mapToReturn.put('n', valueOf);
//		mapToReturn.put('o', valueOf);
//		mapToReturn.put('p', valueOf);
//		return mapToReturn;
//	}

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

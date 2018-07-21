package main.year2017.day18;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.concurrent.SynchronousQueue;

public class DuetProgram {

	private Map<Character, BigInteger> registerSound = new HashMap<>();
//	private boolean waiting = false;
//	private boolean done = false;
	private Integer stepsScanned = 0;
	private Integer currentIndex = 0;
	private Integer messagesSent = 0;
	private DuetProgram duetPartner = null;

	// private Queue<String> instructionQueue = new SynchronousQueue<>();
//	private Queue<String[]> instructionQueue = new PriorityQueue();
//	private List<String[]> instructionQueue = new ArrayList();
	private Deque<BigInteger> instructionQueue = new ArrayDeque<>();
	private List<String> tabletInstructions;

	// Private queue

	/*
	public DuetProgram(List<String> instructions, int id) {
	       this.tabletInstructions = instructions;
	        currentIndex = 0;
	        messagesSent = 0;
	        instructionQueue = new ArrayDeque<>();
*/
/*	        registers = new BigInteger[26];
	        for(int i = 0; i < registers.length; i++) {
	            registers[i] = BigInteger.ZERO;
	        }
	        registers['p' - 'a'] = BigInteger.valueOf(id);
	        */
//	}


	public List<String> getTabletInstructions() {
		return tabletInstructions;
	}

	public void setTabletInstructions(List<String> tabletInstructions) {
		this.tabletInstructions = tabletInstructions;
	}

	public Map<Character, BigInteger> getRegisterSound() {
		return registerSound;
	}

	public void setRegisterSound(Map<Character, BigInteger> registerSound) {
		this.registerSound = registerSound;
	}

	public boolean isWaiting() {
		return instructionQueue.isEmpty() && tabletInstructions.get(currentIndex).startsWith("rcv ");
		//return waiting;
	}

//	public void setWaiting(boolean waiting) {
//		this.waiting = waiting;
//	}

	public boolean isDone() {
		return currentIndex < 0 || currentIndex >= tabletInstructions.size();
//		return done;
	}

//	public void setDone(boolean done) {
//		this.done = done;
//	}

	public Integer getStepsScanned() {
		return stepsScanned;
	}

	public void setStepsScanned(Integer stepsScanned) {
		this.stepsScanned = stepsScanned;
	}

//	public List<String[]> getInstructionQueue() {
	public Deque<BigInteger> getInstructionQueue() {
		return instructionQueue;
	}

//	public void setInstructionQueue(List<String[]> instructionQueue) {
	public void setInstructionQueue(Deque<BigInteger> instructionQueue) {
		this.instructionQueue = instructionQueue;
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}

	public DuetProgram getDuetPartner() {
		return duetPartner;
	}

	public void setDuetPartner(DuetProgram duetPartner) {
		this.duetPartner = duetPartner;
	}
	
	public Integer getMessagesSent() {
		return messagesSent;
	}

	public void setMessagesSent(Integer messagesSent) {
		this.messagesSent = messagesSent;
	}
	
	private BigInteger getValue(final Character location, final Map<Character, BigInteger> registers) {
//	    if(isRegister(location)) {
	    return registers.get(location);
//	    } 
	    
	    /*else {
	        return new BigInteger(location);
	    }
	    */
	}

//
//	public void processStep(List<String> tabletInstructions) {
//
//		/*
//		 * currentIndex = processInstruction(tabletInstructions, registerSound,
//		 * terminated, currentIndex);
//		 */
//		// get string to process
//		String stringToProcess = "";
//		// if (getInstructionQueue().isEmpty()){
//		stringToProcess = tabletInstructions.get(currentIndex);
//
//		// figure out what it wants to do
//		String[] processInstructions = stringToProcess.split("\\s+");
//		if ("snd".equals(processInstructions[0])) {
//			// NEW FUNCTION
//			// lastPlayedSound =
//			// registerSound.get(processInstructions[1].charAt(0));
//
////			List<String[]> partnerQueue = getDuetPartner().getInstructionQueue();
////			partnerQueue.add(processInstructions);
////			getDuetPartner().setInstructionQueue(partnerQueue);
////			messagesSent++;
//			sendMessage(getValue(processInstructions[1].charAt(0), registerSound));
//			
//			currentIndex++;
//		} else if ("set".equals(processInstructions[0])) {
//			BigInteger value = BigInteger.valueOf(0);
//			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
//				value = registerSound.get(processInstructions[2].charAt(0));
//			} else {
//				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
//			}
//			registerSound.put(processInstructions[1].charAt(0), value);
//			currentIndex++;
//		} else if ("add".equals(processInstructions[0])) {
//			BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
//			BigInteger value = BigInteger.valueOf(0);
//			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
//				value = registerSound.get(processInstructions[2].charAt(0));
//			} else {
//				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
//			}
//			BigInteger newValue = oldValue.add(value);
//			registerSound.put(processInstructions[1].charAt(0), newValue);
//			currentIndex++;
//		} else if ("mul".equals(processInstructions[0])) {
//			BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
//			BigInteger value = BigInteger.valueOf(0);
//			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
//				value = registerSound.get(processInstructions[2].charAt(0));
//			} else {
//				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
//			}
//			BigInteger newValue = oldValue.multiply(value);
//			registerSound.put(processInstructions[1].charAt(0), newValue);
//			currentIndex++;
//		} else if ("mod".equals(processInstructions[0])) {
//			BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
//			BigInteger value = BigInteger.valueOf(0);
//			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
//				value = registerSound.get(processInstructions[2].charAt(0));
//			} else {
//				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
//			}
//			BigInteger newValue = oldValue.mod(value);
//			registerSound.put(processInstructions[1].charAt(0), newValue);
//			currentIndex++;
//		} else if ("rcv".equals(processInstructions[0])) {
//			BigInteger newValue = instructionQueue.pop();
//			registerSound.put(processInstructions[1].charAt(0), newValue);
////			if (instructionQueue.isEmpty()){
////				waiting = true;
////			} else {
////				String[] newInstructions = instructionQueue.get(0);
////				instructionQueue.remove(instructionQueue.get(0));
//////				String[] newInstructionsRemoved = Arrays.copyOfRange(newInstructions, 1, newInstructions.length);
////				BigInteger value = BigInteger.valueOf(0);
////				if (newInstructions[1].matches(".*[a-zA-Z]+.*")){
////					value = registerSound.get(newInstructions[1].charAt(0));
////				} else {
////					value = BigInteger.valueOf(Integer.parseInt(newInstructions[1]));
////				}
////				registerSound.put(processInstructions[1].charAt(0), value);
////			}
//			// NEW FUNCTION
//			// if
//			// (!(BigInteger.valueOf(0).equals(registerSound.get(processInstructions[1].charAt(0))))){
//			// terminated = true;
//			// } else {
//			// currentIndex++;
//			// }
//			currentIndex++;
//		} else if ("jgz".equals(processInstructions[0])) {
//			if (1 == registerSound.get(processInstructions[1].charAt(0)).compareTo(BigInteger.valueOf(0))) {
//				BigInteger value = BigInteger.valueOf(0);
//				if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
//					value = registerSound.get(processInstructions[2].charAt(0));
//				} else {
//					value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
//				}
//				Integer jumpOffSet = value.intValueExact();// DANGEROUS
//				if (jumpOffSet > 1) {
//					currentIndex = currentIndex + jumpOffSet - 1;
//				} else {
//					currentIndex = currentIndex + jumpOffSet;
//				}
//			} else {
//				currentIndex++;
//			}
//		} else {
//			System.out.println("ERROR UNRECOGNIZED TABLET INSTRUCTION");
//		}
//		
////		if ((currentIndex < 0)
////			||
////			(currentIndex >= tabletInstructions.size())){
////			done = true;
////		}
//		// do the stuff!
//		// where are we going now?
//
//		// } else {
//		// stringToProcess = instructionQueue.remove();//hacky, whatever
//		// }
//
//	}

	private void sendMessage(BigInteger value) {
        duetPartner.sendToQueue(value);
        messagesSent++;
		
	}

	private void sendToQueue(BigInteger value) {
        instructionQueue.addLast(value);
    }

	public void processStep() {

		/*
		 * currentIndex = processInstruction(tabletInstructions, registerSound,
		 * terminated, currentIndex);
		 */
		// get string to process
		String stringToProcess = "";
		// if (getInstructionQueue().isEmpty()){
		stringToProcess = tabletInstructions.get(currentIndex);

		// figure out what it wants to do
		String[] processInstructions = stringToProcess.split("\\s+");
		if ("snd".equals(processInstructions[0])) {
			// NEW FUNCTION
			// lastPlayedSound =
			// registerSound.get(processInstructions[1].charAt(0));

//			List<String[]> partnerQueue = getDuetPartner().getInstructionQueue();
//			partnerQueue.add(processInstructions);
//			getDuetPartner().setInstructionQueue(partnerQueue);
//			messagesSent++;
			sendMessage(getValue(processInstructions[1].charAt(0), registerSound));
			
			currentIndex++;
		} else if ("set".equals(processInstructions[0])) {
			BigInteger value = BigInteger.valueOf(0);
			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
				value = registerSound.get(processInstructions[2].charAt(0));
			} else {
				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
			}
			registerSound.put(processInstructions[1].charAt(0), value);
			currentIndex++;
		} else if ("add".equals(processInstructions[0])) {
			BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
			BigInteger value = BigInteger.valueOf(0);
			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
				value = registerSound.get(processInstructions[2].charAt(0));
			} else {
				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
			}
			BigInteger newValue = oldValue.add(value);
			registerSound.put(processInstructions[1].charAt(0), newValue);
			currentIndex++;
		} else if ("mul".equals(processInstructions[0])) {
			BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
			BigInteger value = BigInteger.valueOf(0);
			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
				value = registerSound.get(processInstructions[2].charAt(0));
			} else {
				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
			}
			BigInteger newValue = oldValue.multiply(value);
			registerSound.put(processInstructions[1].charAt(0), newValue);
			currentIndex++;
		} else if ("mod".equals(processInstructions[0])) {
			BigInteger oldValue = registerSound.get(processInstructions[1].charAt(0));
			BigInteger value = BigInteger.valueOf(0);
			if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
				value = registerSound.get(processInstructions[2].charAt(0));
			} else {
				value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
			}
			BigInteger newValue = oldValue.mod(value);
			registerSound.put(processInstructions[1].charAt(0), newValue);
			currentIndex++;
		} else if ("rcv".equals(processInstructions[0])) {
			BigInteger newValue = instructionQueue.pop();
			registerSound.put(processInstructions[1].charAt(0), newValue);
//			if (instructionQueue.isEmpty()){
//				waiting = true;
//			} else {
//				String[] newInstructions = instructionQueue.get(0);
//				instructionQueue.remove(instructionQueue.get(0));
////				String[] newInstructionsRemoved = Arrays.copyOfRange(newInstructions, 1, newInstructions.length);
//				BigInteger value = BigInteger.valueOf(0);
//				if (newInstructions[1].matches(".*[a-zA-Z]+.*")){
//					value = registerSound.get(newInstructions[1].charAt(0));
//				} else {
//					value = BigInteger.valueOf(Integer.parseInt(newInstructions[1]));
//				}
//				registerSound.put(processInstructions[1].charAt(0), value);
//			}
			// NEW FUNCTION
			// if
			// (!(BigInteger.valueOf(0).equals(registerSound.get(processInstructions[1].charAt(0))))){
			// terminated = true;
			// } else {
			// currentIndex++;
			// }
			currentIndex++;
		} else if ("jgz".equals(processInstructions[0])) {
			if (1 == registerSound.get(processInstructions[1].charAt(0)).compareTo(BigInteger.valueOf(0))) {
				BigInteger value = BigInteger.valueOf(0);
				if (processInstructions[2].matches(".*[a-zA-Z]+.*")) {
					value = registerSound.get(processInstructions[2].charAt(0));
				} else {
					value = BigInteger.valueOf(Integer.parseInt(processInstructions[2]));
				}
				Integer jumpOffSet = value.intValueExact();// DANGEROUS
//				if (jumpOffSet > 1) {
//					currentIndex = currentIndex + jumpOffSet - 1;
//				} else {
//					currentIndex = currentIndex + jumpOffSet;
//				}
				currentIndex = currentIndex + jumpOffSet - 0;
			} else {
				currentIndex++;
			}
		} else {
			System.out.println("ERROR UNRECOGNIZED TABLET INSTRUCTION");
		}
		
//		if ((currentIndex < 0)
//			||
//			(currentIndex >= tabletInstructions.size())){
//			done = true;
//		}
		// do the stuff!
		// where are we going now?

		// } else {
		// stringToProcess = instructionQueue.remove();//hacky, whatever
		// }

	}

	

}

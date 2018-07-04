package main.year2017.day18;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.concurrent.SynchronousQueue;

public class DuetProgram {

	private Map<Character, BigInteger> registerSound = new HashMap<>();
	private boolean waiting = false;
	private boolean done = false;
	private Integer stepsScanned = 0;
	private Integer currentIndex = 0;
	private Integer messagesSent = 0;
	private DuetProgram duetPartner = null;

	// private Queue<String> instructionQueue = new SynchronousQueue<>();
	private Queue<String[]> instructionQueue = new PriorityQueue();
	// Private queue

	public Map<Character, BigInteger> getRegisterSound() {
		return registerSound;
	}

	public void setRegisterSound(Map<Character, BigInteger> registerSound) {
		this.registerSound = registerSound;
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Integer getStepsScanned() {
		return stepsScanned;
	}

	public void setStepsScanned(Integer stepsScanned) {
		this.stepsScanned = stepsScanned;
	}

	public Queue<String[]> getInstructionQueue() {
		return instructionQueue;
	}

	public void setInstructionQueue(Queue<String[]> instructionQueue) {
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


	public void processStep(List<String> tabletInstructions) {

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
			Queue<String[]> partnerQueue = getDuetPartner().getInstructionQueue();
			partnerQueue.add(processInstructions);
			messagesSent++;
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
			if (instructionQueue.isEmpty()){
				waiting = true;
			} else {
				String[] newInstructions = instructionQueue.remove();
				BigInteger value = BigInteger.valueOf(0);
				if (newInstructions[1].matches(".*[a-zA-Z]+.*")){
					value = registerSound.get(newInstructions[1].charAt(0));
				} else {
					value = BigInteger.valueOf(Integer.parseInt(newInstructions[1]));
				}
				registerSound.put(processInstructions[1].charAt(0), value);
			}
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
				if (jumpOffSet > 1) {
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
		
		if ((currentIndex < 0)
			||
			(currentIndex >= tabletInstructions.size())){
			done = true;
		}
		// do the stuff!
		// where are we going now?

		// } else {
		// stringToProcess = instructionQueue.remove();//hacky, whatever
		// }

	}

}

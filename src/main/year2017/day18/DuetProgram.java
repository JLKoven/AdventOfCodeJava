package main.year2017.day18;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DuetProgram {


	private Map<Character, BigInteger> registerSound = new HashMap<>();

	private Integer stepsScanned = 0;
	private Integer currentIndex = 0;
	private Integer messagesSent = 0;
	private DuetProgram duetPartner = null;


	private Deque<BigInteger> instructionQueue = new ArrayDeque<>();
	private List<String> tabletInstructions;



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

	}



	public boolean isDone() {
		return currentIndex < 0 || currentIndex >= tabletInstructions.size();

	}



	public Integer getStepsScanned() {
		return stepsScanned;
	}

	public void setStepsScanned(Integer stepsScanned) {
		this.stepsScanned = stepsScanned;
	}


	public Deque<BigInteger> getInstructionQueue() {
		return instructionQueue;
	}


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


	private BigInteger getValue(final String location, final Map<Character, BigInteger> registers) {
		BigInteger value = BigInteger.valueOf(0);
		if (location.matches(".*[a-zA-Z]+.*")){
			value = registers.get(location.charAt(0));
		} else {
			value = BigInteger.valueOf(Integer.parseInt(location));
		}
		return value;
	}


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
		System.out.println("instruction is "+stringToProcess+".");
		String[] processInstructions = stringToProcess.split("\\s+");
		if ("snd".equals(processInstructions[0])) {
			sendMessage(getValue(processInstructions[1], registerSound));
		} else if ("set".equals(processInstructions[0])) {
			registerSound.put(
					processInstructions[1].charAt(0), 
					getValue(processInstructions[2], registerSound));
		} else if ("add".equals(processInstructions[0])) {
			registerSound.put(
					processInstructions[1].charAt(0), 
					getValue(processInstructions[1], registerSound).add(getValue(processInstructions[2], registerSound)));
		} else if ("mul".equals(processInstructions[0])) {
			registerSound.put(
					processInstructions[1].charAt(0), 
					getValue(processInstructions[1], registerSound).multiply(getValue(processInstructions[2], registerSound)));
		} else if ("mod".equals(processInstructions[0])) {
			registerSound.put(
					processInstructions[1].charAt(0), 
					getValue(processInstructions[1], registerSound).mod(getValue(processInstructions[2], registerSound)));
		} else if ("rcv".equals(processInstructions[0])) {
			registerSound.put(
					processInstructions[1].charAt(0), 
					instructionQueue.pop());
		} else if ("jgz".equals(processInstructions[0])) {
			if (getValue(processInstructions[1], registerSound).compareTo(BigInteger.ZERO) > 0) {
				currentIndex += getValue(processInstructions[2], registerSound).intValue();
				return;
			}
		} else {
			throw new RuntimeException(tabletInstructions.get(currentIndex));
		}

		currentIndex++;

	}

}

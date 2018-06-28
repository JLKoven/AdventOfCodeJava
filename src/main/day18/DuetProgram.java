package main.day18;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.concurrent.SynchronousQueue;

public class DuetProgram {
	
	private Map<Character, BigInteger> registerSound = new HashMap<>();
	private boolean waiting = false;
	private boolean done = false;
	private Integer stepsScanned = 0;
//	private Queue<String> instructionQueue = new SynchronousQueue<>();
	private Queue<String> instructionQueue = new PriorityQueue();
//	Private queue 

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


}

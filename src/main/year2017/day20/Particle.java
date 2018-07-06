package main.year2017.day20;

import java.math.BigInteger;

public class Particle {
	
	BigInteger currentXCoordPosition = BigInteger.valueOf(0);
	BigInteger currentYCoordPosition = BigInteger.valueOf(0);
	BigInteger currentZCoordPosition = BigInteger.valueOf(0);
	BigInteger currentXCoordVelocity = BigInteger.valueOf(0);
	BigInteger currentYCoordVelocity = BigInteger.valueOf(0);
	BigInteger currentZCoordVelocity = BigInteger.valueOf(0);
	BigInteger currentXCoordAcceleration = BigInteger.valueOf(0);
	BigInteger currentYCoordAcceleration = BigInteger.valueOf(0);
	BigInteger currentZCoordAcceleration = BigInteger.valueOf(0);
	
	public BigInteger getCurrentXCoordPosition() {
		return currentXCoordPosition;
	}
	public void setCurrentXCoordPosition(BigInteger currentXCoordPosition) {
		this.currentXCoordPosition = currentXCoordPosition;
	}
	public BigInteger getCurrentYCoordPosition() {
		return currentYCoordPosition;
	}
	public void setCurrentYCoordPosition(BigInteger currentYCoordPosition) {
		this.currentYCoordPosition = currentYCoordPosition;
	}
	public BigInteger getCurrentZCoordPosition() {
		return currentZCoordPosition;
	}
	public void setCurrentZCoordPosition(BigInteger currentZCoordPosition) {
		this.currentZCoordPosition = currentZCoordPosition;
	}
	public BigInteger getCurrentXCoordVelocity() {
		return currentXCoordVelocity;
	}
	public void setCurrentXCoordVelocity(BigInteger currentXCoordVelocity) {
		this.currentXCoordVelocity = currentXCoordVelocity;
	}
	public BigInteger getCurrentYCoordVelocity() {
		return currentYCoordVelocity;
	}
	public void setCurrentYCoordVelocity(BigInteger currentYCoordVelocity) {
		this.currentYCoordVelocity = currentYCoordVelocity;
	}
	public BigInteger getCurrentZCoordVelocity() {
		return currentZCoordVelocity;
	}
	public void setCurrentZCoordVelocity(BigInteger currentZCoordVelocity) {
		this.currentZCoordVelocity = currentZCoordVelocity;
	}
	public BigInteger getCurrentXCoordAcceleration() {
		return currentXCoordAcceleration;
	}
	public void setCurrentXCoordAcceleration(BigInteger currentXCoordAcceleration) {
		this.currentXCoordAcceleration = currentXCoordAcceleration;
	}
	public BigInteger getCurrentYCoordAcceleration() {
		return currentYCoordAcceleration;
	}
	public void setCurrentYCoordAcceleration(BigInteger currentYCoordAcceleration) {
		this.currentYCoordAcceleration = currentYCoordAcceleration;
	}
	public BigInteger getCurrentZCoordAcceleration() {
		return currentZCoordAcceleration;
	}
	public void setCurrentZCoordAcceleration(BigInteger currentZCoordAcceleration) {
		this.currentZCoordAcceleration = currentZCoordAcceleration;
	}
	
	
	public BigInteger getManhattanDistanceFromOrigin() {
		return (getCurrentXCoordPosition().abs()).add(
				(
						(getCurrentYCoordPosition().abs()).add(
								(getCurrentZCoordPosition().abs())
								)
						)
				);
				//BigInteger.valueOf(1)+;
	}
	
	public BigInteger getManhattanAccelerationFromOrigin() {
		return (getCurrentXCoordAcceleration().abs()).add(
				(
						(getCurrentYCoordAcceleration().abs()).add(
								(getCurrentZCoordAcceleration().abs())
								)
						)
				);
				//BigInteger.valueOf(1)+;
	}

	
//	int currentXCoordPosition = 0;
//	int currentYCoordPosition = 0;
//	int currentZCoordPosition = 0;
//	int currentXCoordVelocity = 0;
//	int currentYCoordVelocity = 0;
//	int currentZCoordVelocity = 0;
//	int currentXCoordAcceleration = 0;
//	int currentYCoordAcceleration = 0;
//	int currentZCoordAcceleration = 0;
//	
//	public int getCurrentXCoordPosition() {
//		return currentXCoordPosition;
//	}
//	public void setCurrentXCoordPosition(int currentXCoordPosition) {
//		this.currentXCoordPosition = currentXCoordPosition;
//	}
//	public int getCurrentYCoordPosition() {
//		return currentYCoordPosition;
//	}
//	public void setCurrentYCoordPosition(int currentYCoordPosition) {
//		this.currentYCoordPosition = currentYCoordPosition;
//	}
//	public int getCurrentZCoordPosition() {
//		return currentZCoordPosition;
//	}
//	public void setCurrentZCoordPosition(int currentZCoordPosition) {
//		this.currentZCoordPosition = currentZCoordPosition;
//	}
//	public int getCurrentXCoordVelocity() {
//		return currentXCoordVelocity;
//	}
//	public void setCurrentXCoordVelocity(int currentXCoordVelocity) {
//		this.currentXCoordVelocity = currentXCoordVelocity;
//	}
//	public int getCurrentYCoordVelocity() {
//		return currentYCoordVelocity;
//	}
//	public void setCurrentYCoordVelocity(int currentYCoordVelocity) {
//		this.currentYCoordVelocity = currentYCoordVelocity;
//	}
//	public int getCurrentZCoordVelocity() {
//		return currentZCoordVelocity;
//	}
//	public void setCurrentZCoordVelocity(int currentZCoordVelocity) {
//		this.currentZCoordVelocity = currentZCoordVelocity;
//	}
//	public int getCurrentXCoordAcceleration() {
//		return currentXCoordAcceleration;
//	}
//	public void setCurrentXCoordAcceleration(int currentXCoordAcceleration) {
//		this.currentXCoordAcceleration = currentXCoordAcceleration;
//	}
//	public int getCurrentYCoordAcceleration() {
//		return currentYCoordAcceleration;
//	}
//	public void setCurrentYCoordAcceleration(int currentYCoordAcceleration) {
//		this.currentYCoordAcceleration = currentYCoordAcceleration;
//	}
//	public int getCurrentZCoordAcceleration() {
//		return currentZCoordAcceleration;
//	}
//	public void setCurrentZCoordAcceleration(int currentZCoordAcceleration) {
//		this.currentZCoordAcceleration = currentZCoordAcceleration;
//	}


}

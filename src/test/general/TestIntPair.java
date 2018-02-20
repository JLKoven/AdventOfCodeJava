package test.general;

import static org.junit.Assert.*;


import org.junit.Test;

import main.IntPair;


public class TestIntPair {
	
	
	
	@Test
	public void testIntPairEquals() {
		IntPair one = new IntPair();
		IntPair alsoOne = new IntPair();
		one.setXCoord(4);
		one.setYCoord(5);
		alsoOne.setXCoord(4);
		alsoOne.setYCoord(5);
		IntPair two = new IntPair();
		two.setXCoord(2);
		two.setYCoord(5);
		assertEquals(
				one.equals(alsoOne)
				&&
				alsoOne.equals(one)
				&&
				!(one.equals(two))
				, true);
		System.out.println("Success on IntPair.testIntPairEquals!");
	}
	
	@Test
	public void testIntPairHashCode() {
		IntPair one = new IntPair();
		IntPair alsoOne = new IntPair();
		one.setXCoord(4);
		one.setYCoord(5);
		alsoOne.setXCoord(4);
		alsoOne.setYCoord(5);
		IntPair two = new IntPair();
		two.setXCoord(2);
		two.setYCoord(5);
		assertEquals(
				one.hashCode() == alsoOne.hashCode()
				&&
				!(one.hashCode() == two.hashCode())
				, true);
		System.out.println("Success on IntPair.testIntPairHashCode!");
	}

}

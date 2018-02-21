package test.general;

import static org.junit.Assert.*;

import org.junit.Test;

import main.IntPair;

public class TestIntPair {

	@Test
	public void testIntPairEqualsPositive() {
		IntPair one = new IntPair();
		IntPair alsoOne = new IntPair();
		one.setXCoord(4);
		one.setYCoord(5);
		alsoOne.setXCoord(4);
		alsoOne.setYCoord(5);
		IntPair two = new IntPair();
		two.setXCoord(2);
		two.setYCoord(5);
		assertEquals(one.equals(alsoOne) && alsoOne.equals(one), true);
		System.out.println("Success on IntPair.testIntPairEqualsPositive!");
	}

	@Test
	public void testIntPairEqualsNegative() {
		IntPair one = new IntPair();
		IntPair alsoOne = new IntPair();
		one.setXCoord(4);
		one.setYCoord(5);
		alsoOne.setXCoord(4);
		alsoOne.setYCoord(5);
		IntPair two = new IntPair();
		two.setXCoord(2);
		two.setYCoord(5);
		assertEquals(!(one.equals(two)), true);
		System.out.println("Success on IntPair.testIntPairEqualsNegative!");
	}

	@Test
	public void testIntPairHashCodePositive() {
		IntPair one = new IntPair();
		IntPair alsoOne = new IntPair();
		one.setXCoord(4);
		one.setYCoord(5);
		alsoOne.setXCoord(4);
		alsoOne.setYCoord(5);
		IntPair two = new IntPair();
		two.setXCoord(2);
		two.setYCoord(5);
		assertEquals(one.hashCode() == alsoOne.hashCode(), true);
		System.out.println("Success on IntPair.testIntPairHashCodePositive!");
	}

	@Test
	public void testIntPairHashCodeNegative1() {
		IntPair one = new IntPair();
		IntPair alsoOne = new IntPair();
		one.setXCoord(4);
		one.setYCoord(5);
		alsoOne.setXCoord(4);
		alsoOne.setYCoord(5);
		IntPair two = new IntPair();
		two.setXCoord(2);
		two.setYCoord(5);
		assertEquals(!(one.hashCode() == two.hashCode()), true);
		System.out.println("Success on IntPair.testIntPairHashCodeNegative1!");
	}
	
	@Test
	public void testIntPairHashCodeNegative2() {
		IntPair one = new IntPair();
		IntPair three = new IntPair();
		one.setXCoord(4);
		one.setYCoord(5);
		three.setXCoord(5);
		three.setYCoord(4);
		assertEquals(!(one.hashCode() == three.hashCode()), true);
		System.out.println("Success on IntPair.testIntPairHashCodeNegative2!");
	}

}

package test.general;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.MathFunction;


public class TestMathFunction {
	
	@Test
	public void testFactorial() {
		Integer result = MathFunction.factorial(5, 4).obtain();
		assertEquals(result.equals(120), true);
		System.out.println("Success on MathFunction.testFactorial!");
	}

	
	@Test
	public void testAdd() {
		Integer result = MathFunction.add().apply(3,3);
		assertEquals(result.equals(6), true);
		System.out.println("Success on MathFunction.testAdd!");
	}
	
	@Test
	public void testMul() {
		Integer result = MathFunction.mul().apply(3,3);
		assertEquals(result.equals(9), true);
		System.out.println("Success on MathFunction.testMul!");
	}
	
	@Test
	public void testExp() {
		Integer result = MathFunction.exp().apply(3,3);
		assertEquals(result.equals(27), true);
		System.out.println("Success on MathFunction.testExp!");
	}

}

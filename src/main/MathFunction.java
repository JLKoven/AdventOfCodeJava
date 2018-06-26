package main;

public class MathFunction {

	/*
	 * public static TailCall<Integer> integralify( TailCall<Integer> prior,
	 * TailCall<Integer> baseCase, Integer x, Integer y) { if (y <= 0) { return
	 * TailCall.done(baseCase); } else { return () -> integralify(prior * x,
	 * baseCase, x, y - 1); } }
	 */

	/*
	 * public static Integer add(Integer x, Integer y){ return x+y; }
	 * 
	 * public static Integer mul(Integer x, Integer y){ if (y == 0){ return 0; }
	 * else { //why second base case return add(x, mul(x, y-1)); } }
	 * 
	 * public static Integer exp(Integer x, Integer y){ if (y == 0){ return 1; }
	 * else { //why second base case return mul(x, exp(x, y-1)); } }
	 */



//	public static BinaryOperatorInteger mul() {
//		return (Integer x, Integer y) -> {
//			if (y == 0) {
//				return 0;
//			}
//			return add().apply(x, mul().apply(x, y - 1));
//		};
//		/*
//		 * add().apply( x ,y);
//		 */
//	}

	public static BinaryOperatorInteger add() {
		return (Integer x, Integer y) -> x + y;
	}
	
	public static BinaryOperatorInteger mul() {
		return (Integer x, Integer y) -> integralify(add(), 0, x, y);
	}
	
	public static BinaryOperatorInteger exp() {
		return (Integer x, Integer y) -> integralify(mul(), 1, x, y);
	}

	public static Integer integralify(BinaryOperatorInteger prior, Integer baseCase, Integer x, Integer y) {
		if (y == 0) {
			return baseCase;
		} else {
			// why second base case
			return prior.apply(x, integralify(prior, baseCase, x, y - 1));
		}
	}

	// exp(3,3) <-> mult(mult(3,3),3);
	// exp(3,3) <-> mult(add(add(3,3),3),3);
	// exp(3,3) <->
	// add(add(add(add(add(add(add(add(add(3,3),3),3),3),3),3),3),3);

	// Add(3,3) is Integralify(?WHAT, BaseCase, 3, 0)
	// Mult(3,3) is Integralify(?1, ?2, ?3, 1)
	// Exp(3,3) is Integralify(?4, ?5, ?6, 2)
	// What are the first six variables?
	// Let me look at mult.
	// I think ?1 is add(3, ?7, ?8, 0)
	// I think ?4 is mult(3, ?9, ?10, 1)

	public static TailCall<Integer> factorial(int fact, int n) {
		if (n == 1) {
			return TailCall.done(fact);
		}

		return () -> factorial(fact * n, n - 1);
	}
}

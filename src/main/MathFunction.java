package main;

public class MathFunction {

//	public static TailCall<Integer> integralify(Integer prior, Integer baseCase, Integer x, Integer y) {
//		if (y > 0) {
//			return () -> integralify(prior * x, baseCase, x, y - 1);
//		} else {
//			return TailCall.done(baseCase);
//		}
//	}

	public static TailCall<Integer> factorial(int fact, int n) {
		if (n == 1) {
			return TailCall.done(fact);
		}

		return () -> factorial(fact * n, n - 1);
	}
}

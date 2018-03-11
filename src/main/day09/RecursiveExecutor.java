package main.day09;

import main.TailCall;
import main.TailCalls;

public class RecursiveExecutor {

	public static void main(String[] args) {
		System.out.println(factorial(1, 5).get());
//		System.out.println(factorial(1, 5).result());
//		System.out.println("Factorial 4,0 is "+factorial(4,0).get()+".");
		System.out.println("Factorial 1,4 is "+factorial(1,4).get()+".");
		System.out.println("Factorial 4,2 is "+factorial(4,2).get()+".");
		System.out.println("Factorial 4,3 is "+factorial(4,3).get()+".");

	}
	public static TailCall<Integer> factorial(int fact, int n) {
		
		
	    if (n == 1) {
	        return TailCalls.done(fact);
	    }

	    return () -> factorial(fact * n, n-1);
	}
}

package main;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {
    TailCall<T> apply();
    //if we are implementing TailCall with a lambda, that'll go here 


    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new Error("not implemented");
    }

    default T obtain() {
        return Stream.iterate(this, 
        		TailCall::apply)//I need this otherwise I gotta write way too many kinds of Stream.iterate()s 
        		.filter(TailCall::isComplete)//also takes a function as an argument!! 
        		.findFirst()
        		.get()
        		.result();
        //iterate is like integralify(prior,baseCase,x,y);
    }


	static <T> TailCall<T> done(final T value) {
		return new TailCall<T>() {
			@Override
			public boolean isComplete() {
				return true;
			}

			@Override
			public T result() {
				return value;
			}

			@Override
			public TailCall<T> apply() {
				throw new Error("not implemented.");
			}
		};
	}




//	static TailCall<T> done(int currentScore) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
/*
public static TailCall<Integer> factorial(int fact, int n) {
if (n == 1) {
    return TailCalls.done(fact);
}

return () -> factorial(fact * n, n-1);
}*/
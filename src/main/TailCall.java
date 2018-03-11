package main;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {
    TailCall<T> apply();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new Error("not implemented");
    }

    default T get() {
        return Stream.iterate(this, TailCall::apply).filter(TailCall::isComplete)
                                                .findFirst().get().result();
    }
}
/*
public static TailCall<Integer> factorial(int fact, int n) {
if (n == 1) {
    return TailCalls.done(fact);
}

return () -> factorial(fact * n, n-1);
}*/
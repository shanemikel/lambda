package com.jnape.palatable.lambda.functions.builtin.dyadic;

import com.jnape.palatable.lambda.functions.DyadicFunction;
import com.jnape.palatable.lambda.functions.MonadicFunction;

/**
 * Eagerly apply a predicate to each element in an <code>Iterable</code>, returning <code>true</code> if any element
 * satisfies the predicate, and <code>false</code> otherwise. This method short-circuits on the first <code>true</code>
 * evaluation.
 *
 * @param <A> The input Iterable element type
 * @see All
 */
public final class Any<A> implements DyadicFunction<MonadicFunction<? super A, Boolean>, Iterable<A>, Boolean> {

    private Any() {
    }

    @Override
    public final Boolean apply(MonadicFunction<? super A, Boolean> predicate, Iterable<A> as) {
        for (A a : as)
            if (predicate.apply(a))
                return true;

        return false;
    }

    public static <A> Any<A> any() {
        return new Any<>();
    }

    public static <A> MonadicFunction<Iterable<A>, Boolean> any(MonadicFunction<? super A, Boolean> predicate) {
        return Any.<A>any().apply(predicate);
    }

    public static <A> Boolean any(MonadicFunction<? super A, Boolean> predicate, Iterable<A> as) {
        return Any.<A>any(predicate).apply(as);
    }
}

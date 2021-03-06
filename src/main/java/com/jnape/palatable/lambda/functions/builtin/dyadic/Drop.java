package com.jnape.palatable.lambda.functions.builtin.dyadic;

import com.jnape.palatable.lambda.functions.DyadicFunction;
import com.jnape.palatable.lambda.functions.MonadicFunction;
import com.jnape.palatable.lambda.iterators.DroppingIterator;

/**
 * Lazily skip the first <code>n</code> elements from an <code>Iterable</code> by returning an <code>Iterable</code>
 * that begins iteration after the <code>nth</code> element. If <code>n</code> is greater than or equal to the length of
 * the <code>Iterable</code>, an empty <code>Iterable</code> is returned.
 *
 * @param <A> The Iterable element type
 * @see DropWhile
 * @see Take
 */
public final class Drop<A> implements DyadicFunction<Integer, Iterable<A>, Iterable<A>> {

    private Drop() {
    }

    @Override
    public final Iterable<A> apply(final Integer n, final Iterable<A> as) {
        return () -> new DroppingIterator<>(n, as.iterator());
    }

    public static <A> Drop<A> drop() {
        return new Drop<>();
    }

    public static <A> MonadicFunction<Iterable<A>, Iterable<A>> drop(int n) {
        return Drop.<A>drop().apply(n);
    }

    public static <A> Iterable<A> drop(int n, Iterable<A> as) {
        return Drop.<A>drop(n).apply(as);
    }
}

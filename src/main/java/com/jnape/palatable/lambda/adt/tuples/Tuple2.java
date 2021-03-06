package com.jnape.palatable.lambda.adt.tuples;

import com.jnape.palatable.lambda.applicative.BiFunctor;
import com.jnape.palatable.lambda.functions.MonadicFunction;

import java.util.Objects;

import static java.lang.String.format;

public class Tuple2<_1, _2> implements BiFunctor<_1, _2> {

    public final _1 _1;
    public final _2 _2;

    public Tuple2(_1 _1, _2 _2) {
        this._1 = _1;
        this._2 = _2;
    }

    @Override
    public <_2A> Tuple2<_1, _2A> fmap(MonadicFunction<? super _2, ? extends _2A> fn) {
        return (Tuple2<_1, _2A>) BiFunctor.super.fmap(fn);
    }

    @Override
    public <_1A, _2A> Tuple2<_1A, _2A> biMap(MonadicFunction<? super _1, ? extends _1A> f1,
                                             MonadicFunction<? super _2, ? extends _2A> f2) {
        return tuple(f1.apply(_1), f2.apply(_2));
    }

    @Override
    public <_1A> Tuple2<_1A, _2> biMapL(MonadicFunction<? super _1, ? extends _1A> fn) {
        return (Tuple2<_1A, _2>) BiFunctor.super.biMapL(fn);
    }

    @Override
    public <_2A> Tuple2<_1, _2A> biMapR(MonadicFunction<? super _2, ? extends _2A> fn) {
        return (Tuple2<_1, _2A>) BiFunctor.super.biMapR(fn);
    }

    @Override
    public String toString() {
        return format("(%s, %s)", _1, _2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(_1, tuple2._1) &&
                Objects.equals(_2, tuple2._2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2);
    }

    public static <_1, _2> Tuple2<_1, _2> tuple(_1 _1, _2 _2) {
        return new Tuple2<>(_1, _2);
    }
}

package testsupport.applicatives;

import com.jnape.palatable.lambda.applicative.ProFunctor;
import com.jnape.palatable.lambda.functions.MonadicFunction;

import java.util.concurrent.atomic.AtomicReference;

public final class InvocationRecordingProFunctor<A, B> implements ProFunctor<A, B> {
    private final AtomicReference<MonadicFunction> leftFn;
    private final AtomicReference<MonadicFunction> rightFn;

    public InvocationRecordingProFunctor(AtomicReference<MonadicFunction> leftFn,
                                         AtomicReference<MonadicFunction> rightFn) {
        this.leftFn = leftFn;
        this.rightFn = rightFn;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <C, D> ProFunctor<C, D> diMap(MonadicFunction<? super C, ? extends A> f1,
                                         MonadicFunction<? super B, ? extends D> f2) {
        leftFn.set(f1);
        rightFn.set(f2);
        return (ProFunctor<C, D>) this;
    }
}

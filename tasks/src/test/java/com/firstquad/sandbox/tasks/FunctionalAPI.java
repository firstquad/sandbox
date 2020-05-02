package com.firstquad.sandbox.tasks;

import org.junit.Test;

import java.util.function.*;
import java.util.stream.Stream;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class FunctionalAPI {
//    function    (a) -> b
//    biFunction  (a, b) -> c
//    operator    (a) -> a
//    supplier    () -> a
//    consumer    (a) -> void
//    predicate   (a) -> true


    @Test
    public void identity() throws Exception {
        Function.identity();
    }

    class FunctionImpl implements Function<Object, Object> {
        @Override
        public Object apply(Object o) {
            return "123";
        }
    }

    @Test
    public void function() throws Exception {
        new FunctionImpl()
                .compose(s -> s)
                .andThen(s -> s)
                .apply(new Object());
    }

    class SupplierImpl implements Supplier {

        @Override
        public Object get() {
            return null;
        }
    }

    @Test
    public void supplier() throws Exception {
        Stream.generate(() -> "123");
        Stream.generate(new SupplierImpl());
    }

    class PredicateImpl implements Predicate {

        @Override
        public boolean test(Object o) {
            return false;
        }
    }

    @Test
    public void predicate() throws Exception {
        Stream.of()
                .filter(new PredicateImpl())
                .count();
    }

    class ConsumerImpl implements Consumer {

        @Override
        public void accept(Object o) {

        }
    }

    @Test
    public void consumer() throws Exception {
        Stream.of()
                .peek(s -> s.toString());

        new ConsumerImpl().andThen(s -> s.toString());
    }

    class BinaryOperatorImpl implements BinaryOperator {
        @Override
        public Object apply(Object o, Object o2) {
            return null;
        }
    }

    @Test
    public void binaryOperator() throws Exception {
        Stream.of().reduce(new BinaryOperatorImpl());

        final String s = "";
        Stream.of()
                .reduce((s1, s2) -> s)
                .orElse("");

        new BinaryOperatorImpl().andThen(t -> "");
    }

}

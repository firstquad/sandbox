package com.firstquad.sandbox.tasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by DVFirstov
 */
public class StreamAPI {
    //Spliterator characteristics
    public static final int ORDERED = 0x00000010;
    public static final int DISTINCT = 0x00000001;
    public static final int SORTED = 0x00000004;
    public static final int SIZED = 0x00000040;
    public static final int NONNULL = 0x00000100;
    public static final int IMMUTABLE = 0x00000400;
    public static final int CONCURRENT = 0x00001000;
    public static final int SUBSIZED = 0x00004000;

    private Stream<String> s = Stream.of("1", "2", "3");

    @Test
    public void filter() throws Exception {
        s
                .filter(s -> s.isEmpty())
                .count();
    }

    @Test
    public void map() throws Exception {
        s
                .map(s -> "s=" + s)
                .count();
    }

    @Test
    public void mapToInt() throws Exception {
        s
                .mapToInt(Integer::valueOf)
                .count();
    }

    @Test
    public void mapToLong() throws Exception {
        s
                .mapToLong(Long::valueOf)
                .count();
    }

    @Test
    public void mapToDouble() throws Exception {
        s
                .mapToDouble(Double::valueOf)
                .count();
    }

    @Test
    public void flatMap() throws Exception {
        s
                .flatMap(s -> Stream.of(s, s, s))
                .peek(s -> System.out.println(s))
                .count();


        Stream.of("1", "2", "3")
                .flatMap(s -> Stream.of(s))
                .peek(s -> System.out.println(s))
                .count();

        Stream.of("1", "2", "3")
                .flatMap(s -> Stream.empty())
                .peek(System.out::println)
                .count();
    }

    @Test
    public void flatMapToInt() throws Exception {
        s
                .flatMapToInt(s -> IntStream.of(7, 7, 7))
                .peek(System.out::println)
                .count();
    }

    @Test
    public void flatMapToDouble() throws Exception {
        s
                .flatMapToDouble(s -> DoubleStream.of(8, 8, 8))
                .peek(System.out::println)
                .count();
    }

    @Test
    public void distinct() throws Exception {
        s.sequential()
                .distinct()
                .count();
    }

    @Test
    public void parallel() throws Exception {
        // if function tiny and count above 10_000
        s
                .parallel()
                .peek(System.out::println)
                .count();
    }

    @Test
    public void sorted() throws Exception {
        Stream.of("5", "2", "3")
                .sorted((s1, s2) -> s1.compareTo(s2))
                .peek(System.out::println)
                .count();
    }

    @Test
    public void limit() throws Exception {
        s
                .limit(1)
                .peek(System.out::println)
                .count();
    }

    @Test
    public void skip() throws Exception {
        s
                .skip(1)
                .peek(System.out::println)
                .count();
    }

    @Test
    public void forEach() throws Exception {
        s
                .forEach(System.out::println);
    }

    @Test
    public void forEachOrdered() throws Exception {
        s
                .forEachOrdered(System.out::println);
    }

    @Test
    public void toArray() throws Exception {
        s
                .toArray();
    }

    @Test
    public void toArrayGen() throws Exception {
        System.out.println(Arrays.toString(s
                .toArray(String[]::new)));
    }

    @Test
    public void reduce() throws Exception {
        s
                .reduce((s1, s2) -> s1 + "=" + s2)
                .ifPresent(System.out::println);
    }

    @Test
    public void reduceCombine() throws Exception {
        System.out.println(s
                .reduce("out: ", (s1, s2) -> s1 + "=" + s2));
    }

    @Test
    public void reduceCombine2() throws Exception {
        System.out.println(Stream.of(1, 2, 3)
                .reduce(10, (identity, s) -> identity + s, (s1, s2) -> s1 + s2));
    }

    @Test
    public void name() throws Exception {
        ArrayList<Object> collect = s
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);

        System.out.println(collect);
    }

    @Test
    public void minMax() throws Exception {
        System.out.println(s
                .min(Comparator.naturalOrder()));
    }

    @Test
    public void anyMatch() throws Exception {
        s
                .anyMatch(s -> s != null);

        Stream.of("1", "2", "3")
                .allMatch(s -> s != null);

        Stream.of("1", "2", "3")
                .noneMatch(s -> s != null);
    }

    @Test
    public void findFirst() throws Exception {
        System.out.println(s
                .findFirst());
        System.out.println(Stream.of("1", "2", "3")
                .findAny());
    }

    @Test
    public void builder() throws Exception {
        Stream.Builder<String> builder = Stream.builder();
        builder.add("1");
        builder.add("2");
        Stream<String> build = builder.build();
    }

    @Test
    public void iterate() throws Exception {
        Stream
                .iterate("out", (s) -> s + "=")
                .limit(5)
                .peek(System.out::println)
                .count();
    }

    @Test
    public void generate() throws Exception {
        Stream
                .generate(() -> System.currentTimeMillis())
                .limit(5)
                .peek(System.out::println)
                .count();
    }

    @Test
    public void concat() throws Exception {
        Stream
                .concat(s, Stream.of("1", "2", "3"))
                .peek(System.out::println)
                .count();
    }

    @Test
    public void arrays() throws Exception {
        Arrays.stream(new String[]{}).count();
    }

}

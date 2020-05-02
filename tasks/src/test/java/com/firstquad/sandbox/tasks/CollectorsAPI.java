package com.firstquad.sandbox.tasks;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class CollectorsAPI {
    private Stream s = Stream.of("a", "b", "c");

    @Test
    public void to() throws Exception {
        Collectors.toCollection(ArrayList::new);
        Collectors.toList();
        toSet();
        toMap(a -> a, b -> b);
        toMap(a -> a, b -> b, (a, b) -> a == b);
        toMap(a -> a, b -> b, (c1, c2) -> c1, HashMap::new);
        Collectors.toConcurrentMap(a -> a, b -> b);
    }

    @Test
    public void joining() throws Exception {
        String joined = Stream.of("a", "b").collect(Collectors.joining());
        System.out.println(joined);
        String s2 = Stream.of("a", "b", "c").collect(Collectors.joining(" :delimiter: "));
        System.out.println(s2);
        String s3 = Stream.of("a", "b", "c").collect(Collectors.joining(" :delimiter: ", "prefix-", "-suffix"));
        System.out.println(s3);
    }

    @Test
    public void mapping() throws Exception {
        Set<String> set = Stream.of("a", "b", "b", "c")
                .collect(Collectors.mapping(s -> s.toUpperCase(), toSet()));
        System.out.println(set);
    }

    @Test
    public void collectingAndThen() throws Exception {
        Collectors.collectingAndThen(toSet(), Collections::unmodifiableSet);
    }

    @Test
    public void counting() throws Exception {
        Object collect = s.collect(Collectors.counting());
        System.out.println(collect);
    }

    @Test
    public void minMaxBy() throws Exception {
        s
                .collect(Collectors.minBy((s1, s2) -> 0));
    }

    @Test
    public void summaryStatistics() throws Exception {
        System.out.println(IntStream.of(1, 2, 3).summaryStatistics());
    }

    @Test
    public void summingInt() throws Exception {
        Collector<Object, ?, Integer> summingInt = Collectors
                .summingInt(s -> Integer.valueOf(s.toString()));
    }

    @Test
    public void averagingInt() throws Exception {
        Collector<Object, ?, Double> averagingInt = Collectors.averagingInt(s -> 1);
    }

    @Test
    public void reducing() throws Exception {
        Collectors.reducing((s1, s2) -> s1);
    }

    @Test
    public void groupingBy() throws Exception {
        Collector<Object, ?, Map<String, List<Object>>> groupingBy = Collectors
                .groupingBy(s -> s.toString());

        Collector<Object, ?, Map<String, Map<String, String>>> mapCollector = Collectors.groupingBy(s -> s.toString(),
                Collectors.mapping(s -> s.toString(), Collectors.toMap(s -> s.toString(), s -> s.toUpperCase())));
    }

    @Test
    public void partitioningBy() throws Exception {
        Collector<Object, ?, Map<Boolean, List<Object>>> partitioningBy = Collectors
                .partitioningBy(s -> s != null);

        Collector<Object, ?, Map<Boolean, Set<Object>>> mapCollector = Collectors
                .partitioningBy(s -> s != null, toSet());
    }

    @Test
    public void summarizingInt() throws Exception {
        Collector<Object, ?, IntSummaryStatistics> summaryStatisticsCollector = Collectors
                .summarizingInt(s -> 1);
    }
}

package com.gunny.util.stream;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Stolen from https://stackoverflow.com/questions/2041778/how-to-initialize-hashset-values-by-construction/37406054#37406054
 */
public class ImmutableCollector {
    public static void main(String[] args) {
        Set<String> strSet1 = Stream.of("A", "B", "C", "D")
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println(strSet1);

        Set<String> strSet2 = Stream.of("A", "B", "C", "D")
                .collect(toImmutableSet());

        System.out.println(strSet2);

        Set<String> strSet3 = Stream.of("A", "B", "C", "D")
                .collect(Collectors.toSet());

        System.out.println(strSet3);

    }

    public static <T> Collector<T, Set<T>, Set<T>> toImmutableSet() {
        return Collector.of(
                HashSet::new, // the seed function for the type to collect into, may be called more than once if collection done in parallel
                Set::add, // how to process each element of this stream
                ImmutableCollector::setCombiner, // how to combine results of parallel operations
                Collections::unmodifiableSet // any final operation on the return value
        );
    }

    public static <T> Set<T> setCombiner(Set<T> a, Set<T> b) {
        a.addAll(b);
        return a;
    }
}
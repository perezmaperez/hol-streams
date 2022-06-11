package com.speedment.example.solution;

import com.speedment.example.unit.Unit3Terminal;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public final class Unit3MyTerminal implements Unit3Terminal {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        stream.forEach(set::add);
    }

    @Override
    public void addToListInOrder(Stream<String> stream, List<String> list) {
        stream.forEach(list::add);
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String collectJoining(Stream<String> stream) {
        return String.join("->",stream.collect(Collectors.toList()));
    }

    @Override
    public String[] toArray(Stream<String> stream) {
        return stream.toArray(String[]::new);
    }

    @Override
    public Map<String, Integer> collectToMap(Stream<String> stream) {
        return stream
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(),
                        s -> (int) s.chars().count()
                ));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return stream.mapToInt(String::length).sum();
    }

    @Override
    public int maxWordLen(Stream<String> stream) {
        return stream.mapToInt(String::length).max().orElse(0);
    }

    @Override
    public IntSummaryStatistics statistics(Stream<String> stream) {
        return stream.mapToInt(String::length).summaryStatistics();
    }

    @Override
    public Optional<String> findLongestString(Stream<String> stream) {
        return stream.reduce((a,b) -> a.length() >= b.length() ? a : b);
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return stream
                .collect(groupingBy(String::length));
    }

    @Override
    public Map<Integer, Long> wordsGroupedByLengthCounted(Stream<String> stream) {
        return stream
                .collect(groupingBy(String::length, counting()));
    }

}

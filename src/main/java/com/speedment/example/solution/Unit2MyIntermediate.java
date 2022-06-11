package com.speedment.example.solution;

import com.speedment.example.unit.Unit2Intermediate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Unit2MyIntermediate implements Unit2Intermediate {

    @Override
    public Stream<String> wordsLongerThanThreeChars(Stream<String> stream) {
        return stream.filter(s-> s.length() > 3);
    }

    @Override
    public Stream<String> firstTwoWordsLongerThanThreeChars(Stream<String> stream) {
        return stream.filter(s -> s.length() > 3).limit(2);
    }

    @Override
    public Stream<String> firstDistinctTwoWordsLongerThanThreeCharsInAlphabeticOrder(Stream<String> stream) {
        return stream.filter(s -> s.length() > 3).distinct().limit(2).sorted();
    }

    @Override
    public IntStream lengthOfWords(Stream<String> stream) {
        return stream.mapToInt(String::length);
    }

    @Override
    public IntStream increasingSawtooth() {
        final long limit = 15;
        return IntStream.range(0, Integer.MAX_VALUE).flatMap(i -> IntStream.range(0, i)).limit(limit);
    }

    @Override
    public Stream<String> strings(Stream<Object> stream) {
        return stream.filter(String.class::isInstance).map(String.class::cast);
    }
}

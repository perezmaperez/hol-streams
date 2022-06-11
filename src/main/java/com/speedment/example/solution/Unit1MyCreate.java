package com.speedment.example.solution;

import com.speedment.example.unit.Unit1Create;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Unit1MyCreate implements Unit1Create {

    @Override
    public Stream<String> newStreamOfAToC() {
        List<String> aToCList = Arrays.asList("A","B","C");
        return aToCList.stream();
    }

    @Override
    public IntStream newIntStreamOfOneToSeven() {
        return IntStream.of(1,2,3,4,5,6,7);
    }

    @Override
    public Stream<String> from(String[] array) {
        String[] texts = {"Alpha", "Bravo", "Charlie"};
        return Stream.of(texts);
    }

    @Override
    public Stream<String> from(Collection<String> collection) {
        return collection.stream();
    }

    @Override
    public IntStream from(String s) {
        return s.chars();
    }

    @Override
    public IntStream infiniteAlternating() {
        final long limit = 19;
        return IntStream.iterate(1, i -> -1 * i).limit(limit);
    }

    @Override
    public IntStream infiniteRandomInts(Random rnd) {
        final int seed = 42;
        final long limit = 19;

        return new Random(seed).ints().limit(limit);
    }

    @Override
    public Stream<String> linesFromPoemTxtFile() throws IOException {
        return Files.lines(Paths.get("poem.txt"));
    }
}

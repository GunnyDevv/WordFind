package com.gunny.words;

import java.util.stream.Stream;

public class InputWordReaderHardCoded implements InputWordReader {
    @Override
    public Stream<String> stream() {
        return Stream.of("are", "ear", "era", "hemi", "tree", "leaves", "red", "blue", "house");
    }
}

package com.gunny.words;

import java.io.BufferedReader;
import java.util.stream.Stream;

public class InputWordReaderFileReader implements InputWordReader {
    BufferedReader source;
    public InputWordReaderFileReader(BufferedReader input) {
        source = input;
    }
    @Override
    public Stream<String> stream() {
        return source.lines();
    }
}

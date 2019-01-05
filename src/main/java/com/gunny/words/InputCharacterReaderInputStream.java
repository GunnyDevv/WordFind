package com.gunny.words;

import java.io.BufferedReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//new InputCharacterReaderInputStream(new BufferedReader(new InputStreamReader(System.in)));

public class InputCharacterReaderInputStream implements InputCharacterReader {
    BufferedReader source;
    public InputCharacterReaderInputStream(BufferedReader input) {
        source = input;
    }

    @Override
    public Stream<String> stream() {
        return source.lines().collect(Collectors.toSet()).parallelStream();

    }

}

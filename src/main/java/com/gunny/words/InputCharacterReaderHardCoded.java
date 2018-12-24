package com.gunny.words;

import java.util.stream.Stream;

public class InputCharacterReaderHardCoded implements InputCharacterReader {
    @Override
    public Stream<String> stream() {
        return Stream.of("are", "redte");
    }
}

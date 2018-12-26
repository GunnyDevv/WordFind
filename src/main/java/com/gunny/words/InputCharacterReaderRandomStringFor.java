package com.gunny.words;

import java.util.Random;
import java.util.stream.Stream;

public class InputCharacterReaderRandomStringFor implements InputCharacterReader {
    public String randomString() {
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();
        int charLength = 6;
        String alpha = "bcdfghjklmnpqrstvwxyz";
        String alphaVow = "aeiou";
        builder.append(alphaVow.charAt(rand.nextInt(5)));
        builder.append(alphaVow.charAt(rand.nextInt(5)));
        for (int randomString = 0; randomString < charLength-2; randomString++) {
            int randS = rand.nextInt(alpha.length());
            builder.append(alpha.charAt(randS));
        }
        String result = builder.toString();
        System.out.println(result);
        return result;

    }

    @Override
    public Stream<String> stream() {
        return Stream.of(randomString());

    }
}

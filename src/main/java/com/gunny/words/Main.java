package com.gunny.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        InputCharacterReader inputCharacterReader = new InputCharacterReaderInputStream(new BufferedReader(new InputStreamReader(System.in)));
        InputWordReader inputWordReader = new InputWordReaderFileReader(new BufferedReader(new FileReader("google-10000-english.txt")));
        List<String> inputWords = inputWordReader.stream().collect(Collectors.toList());
        AllWordsFromCharacters allWordsFromCharacters = new AllWordsFromCharactersForStrategy();
        Function<List<Character>, List<String>> charactersToMatchingWords = l -> allWordsFromCharacters.execute(inputWords, l);
        inputCharacterReader.stream()
                .map(WordUtils::split)
                .map(charactersToMatchingWords)
                .forEach(words -> System.out.println(words));



    }
}

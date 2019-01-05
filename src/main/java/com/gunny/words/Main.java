package com.gunny.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        InputCharacterReader inputCharacterReader = new InputCharacterReaderInputStream(new BufferedReader(new FileReader("5000-MostPopularEnglishWords.txt")));
        InputWordReader inputWordReader = new InputWordReaderFileReader(new BufferedReader(new FileReader("5000-MostPopularEnglishWords.txt")));
        List<String> inputWords = inputWordReader.stream().collect(Collectors.toList());
        AllWordsFromCharacters allWordsFromCharacters = new AllWordsFromCharactersForStrategy();
        Function<List<Character>, Set<String>> charactersToMatchingWords = l -> allWordsFromCharacters.execute(inputWords, l);
        inputCharacterReader.stream()
                .filter(s -> s.length() >= 3)
                .map(WordUtils::split)
                .map(charactersToMatchingWords)
                .map(strings -> strings.stream().filter(s -> s.length() >= 3).collect(Collectors.toSet()))
                .filter(strings -> strings.size() >= 3)
                .forEach(words -> System.out.println(words));



    }
}

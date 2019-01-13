package com.gunny.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Get a List of input words to use as the seed for matching
         */
        InputWordReader inputWordReader = new InputWordReaderFileReader(new BufferedReader(new FileReader("5000-MostPopularEnglishWords.txt")));
        Set<String> inputWords = inputWordReader.stream().collect(Collectors.toSet());

        /*
        Get a lambda that can convert a List<Character> into a Set of matching strings
        This could be better by making a class that holds the WordSet and is always ready to act on it
        First refactor the existing class to take the wordSet as a constructor parameter
         */
        AllWordsFromCharacters allWordsFromCharacters = new AllWordsFromCharactersForStrategy(inputWords);
        Function<List<Character>, Set<String>> charactersToMatchingWords = l -> allWordsFromCharacters.execute(l);

//        InputCharacterReader inputCharacterReader = new InputCharacterReaderInputStream(new BufferedReader(new FileReader("5000-MostPopularEnglishWords.txt")));
        inputWords.parallelStream()
                .filter(s -> s.length() >= 3)// length of string is > 3
                .map(WordUtils::split)// map every string into a List<Characters>
                .map(charactersToMatchingWords)// map every List<Characters> into Set<String> of matching words
                .map(strings -> strings.stream().filter(s -> s.length() >= 3).collect(Collectors.toSet()))// check each String in the set and drop anything that is less than 3 characters
                .filter(strings -> strings.size() >= 3) // drop all lists that are less than three elements
                .forEach(words -> System.out.println(words)); // print result
    }

}

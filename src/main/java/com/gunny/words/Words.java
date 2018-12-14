package com.gunny.words;

import java.util.*;

public class Words {

    public static List<List<Character>> Pick(List<Character> list, int numberWanted) {
        List<List<Character>> output = new ArrayList<>();

        if(numberWanted == 1) {
            for(int x = 0; x < list.size(); x++) {
                List<Character> one = Arrays.asList(list.get(x));
                output.add(one);
            }
        }
        if(numberWanted == 2) {
            for(int x = 0; x < ) {

            }

        }
        if(numberWanted == 3) {

        }
        if(numberWanted == 4) {

        }
        if(numberWanted == 5) {

        }
        if(numberWanted == 6) {

        }

        return output;
    }

    public static Collection<Character> Split(String word) {
        Collection<Character> list = new ArrayList();
        for(int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }
        return list;

    }
    static public List<String> wordsThatMatch(List<String> inputWords, List<Character> inputCharacters) {
        // you need to find all words that are made up of only inputCharacters
        String firstone = inputWords.get(0);
        List<Character> characters = new ArrayList<>();
        firstone.charAt(0);


        for(int i = 0; i < firstone.length(); i++) {
            characters.add(firstone.charAt(i));
        }
        List<String> answerWords = new ArrayList<>();
        for(int x = 0; x < inputWords.size(); x++) {
            Collection<Character> wordLetters = Split(inputWords.get(x));
            wordLetters.removeAll(inputCharacters);
            if(wordLetters.isEmpty()) {
                answerWords.add(inputWords.get(x));
            }

        }

        return answerWords;
    }
}

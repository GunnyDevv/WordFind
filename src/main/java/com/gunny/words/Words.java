package com.gunny.words;

import java.util.*;

public class Words {

    public static List<List<Character>> pick(List<Character> list, int numberWanted) {
        List<List<Character>> output = new ArrayList<>();
        if(numberWanted == 0) {
            output.add(new ArrayList<>(1));
            return output;
        }
        int lockedIndex = 0;
        while(lockedIndex <= list.size()-numberWanted) {
            Character lockedChar = list.get(lockedIndex++);
            List<List<Character>> subListPick = pick(list.subList(lockedIndex, list.size()), numberWanted - 1);
            for (int subListIndex = 0; subListIndex < subListPick.size(); subListIndex++) {
                List<Character> onePick = subListPick.get(subListIndex);
                onePick.add(0, lockedChar);
            }
            output.addAll(subListPick);
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

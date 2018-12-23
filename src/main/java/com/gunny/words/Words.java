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

    public static List<Character> split(String word) {
        List<Character> list = new ArrayList();
        for(int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }
        return list;

    }
    static public List<String> wordsThatMatch(List<String> inputWords, List<Character> inputCharacters) {
        List<String> answerWords = new ArrayList<>();
        for(int targetWordLength = 1; targetWordLength <= inputCharacters.size(); targetWordLength++) {
            List<List<Character>> potentialWordCharacters = pick(inputCharacters, targetWordLength);
            for (int potentialWordCharacterIndex = 0; potentialWordCharacterIndex < potentialWordCharacters.size(); potentialWordCharacterIndex++) {
                List<Character> current = potentialWordCharacters.get(potentialWordCharacterIndex);
                for (int x = 0; x < inputWords.size(); x++) {
                    List<Character> wordLetters = split(inputWords.get(x));
                    if(wordLetters.size() == current.size()) {
                        for (int inputCharacterIndex = 0; inputCharacterIndex < current.size(); inputCharacterIndex++) {
                            for (int wordLetterIndex = 0; wordLetterIndex < wordLetters.size(); wordLetterIndex++) {
                                if(current.get(inputCharacterIndex) == wordLetters.get(wordLetterIndex)) {
                                    wordLetters.remove(wordLetterIndex);
                                    break;
                                }
                            }
                        }
                        if (wordLetters.isEmpty()) {
                            answerWords.add(inputWords.get(x));
                        }
                    }
                }
            }
        }

        return answerWords;
    }
}

package com.gunny.words;

import java.util.ArrayList;
import java.util.List;
import static com.gunny.words.WordUtils.*;

public class AllWordsFromCharactersForStrategy implements AllWordsFromCharacters {
    @Override
    public List<String> execute(List<String> inputWords, List<Character> inputCharacters) {
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

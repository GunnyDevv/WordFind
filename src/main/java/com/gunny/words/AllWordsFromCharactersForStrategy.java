package com.gunny.words;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.gunny.words.WordUtils.*;

public class  AllWordsFromCharactersForStrategy implements AllWordsFromCharacters {
    Set<String> wordSet;
    int minWordLength;

    public AllWordsFromCharactersForStrategy(Set<String> wordSet) {
        this.wordSet = wordSet;
        minWordLength = wordSet.stream().mapToInt(s -> s.length()).min().getAsInt();
    }

    @Override
    public Set<String> execute(List<Character> inputCharacters) {
        /*
         another approach is
         Intstream(minWordLength -> inputCharacters.size())
           .flatMap(n->pick(inputChars,n) // this mapper should be pluggable (maps an Stream<Integer> to Stream<List<List<Character>> and then flatMap turns it into Stream<List<Character>>
           .flatMap(charList->findAllWordsFrom(charList)) // this mapper should be pluggable, maps Stream<List<Character>> to a Stream<Set<String>> and flatMap turns it into a Stream<String>
           .collect(toSet()) // then collect all the Strings into Set

          The above code can be moved to a higher layer and this class could just provide the charList->findAllWordsFrom mapping
        */
        Set<String> answerWords = new HashSet<>();
        for(int targetWordLength = minWordLength; targetWordLength <= inputCharacters.size(); targetWordLength++) { // This loop controls the length of the word we attempting to match to.  We can match from 1 to the full length of inputCharacters (using all the input characters)
            List<List<Character>> potentialWordCharacters = pick(inputCharacters, targetWordLength); // pick all combinations of the desired length
            for (int potentialWordCharacterIndex = 0; potentialWordCharacterIndex < potentialWordCharacters.size(); potentialWordCharacterIndex++) { // for each combination of letters
                List<Character> current = potentialWordCharacters.get(potentialWordCharacterIndex);
                for (String potentialWord: wordSet) {  // brute force search over the inputWords list
                    if(potentialWord.length() == current.size()) { // if the sizes of the two lists are the same it could possibly match
                        List<Character> wordLetters = split(potentialWord); // get a word which is a potential match and split into characters
                        for (int inputCharacterIndex = 0; inputCharacterIndex < current.size(); inputCharacterIndex++) {  // brute force match the two lists
                            for (int wordLetterIndex = 0; wordLetterIndex < wordLetters.size(); wordLetterIndex++) {
                                if(current.get(inputCharacterIndex) == wordLetters.get(wordLetterIndex)) {
                                    wordLetters.remove(wordLetterIndex);
                                    break;
                                }
                            }
                        }
                        if (wordLetters.isEmpty()) {
                            answerWords.add(potentialWord);
                        }
                    }
                }
            }
        }

        return answerWords;
    }
}

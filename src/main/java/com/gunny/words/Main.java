package com.gunny.words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().findAllWordSets();
    }

    private void findAllWordSets() throws FileNotFoundException {
        Set<String> inputWords = get5000MostPopularWords(s -> s.length() >= 3);
        AllWordsFromCharacters allWordsFromCharacters = new AllWordsFromCharactersForStrategy(inputWords);

        long totalFound =
        inputWords // use inputWords to drive search for matching sets, note that inputWords is also used at the data to match against
                .parallelStream() // Yes!
                .map(WordUtils::split)// map every string into a List<Characters>
                .map(allWordsFromCharacters::execute)// map every List<Characters> into Set<String> of matching words
                .filter(stringSet -> stringSet.size() >= 3) // drop all lists that are less than three elements, can't make a crossword otherwise
                .count();
                //.forEach(words -> System.out.println(words)); // print result

        System.out.println(totalFound);
    }

    /**
     * Reads about 5000 words from a text file that was produced from some kind of google project.
     * There are duplicates which are removed on conversion to a Set.
     *
     * @return a Set of Strings of these words, < 5000 due to duplicates
     * @throws FileNotFoundException
     */
    private Set<String> get5000MostPopularWords(Predicate<String> stringFilter) throws FileNotFoundException {
        InputStream wordIS = this.getClass().getResourceAsStream("5000-MostPopularEnglishWords.txt"); // not the best file since it has dups and words that are one and two characters
        BufferedReader reader = new BufferedReader(new InputStreamReader(wordIS));

        return reader.lines()
                     .filter(stringFilter)
                     .collect(Collectors.toSet());
    }
}

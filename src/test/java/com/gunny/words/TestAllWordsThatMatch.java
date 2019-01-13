package com.gunny.words;

import com.gunny.util.stream.ImmutableCollector;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class TestAllWordsThatMatch {
    AllWordsFromCharactersForStrategy matcher;
    List<Character> matchableCharacters;

    @Test
    public void testNoMatch_OnWordThatIsRightLength_ButWrongLetters() {
        withWords("ear", "are", "era", "arc").
        andLetters('e', 'a', 'r').
        assertMatchesAre("ear", "are", "era");
    }

    @Test
    public void testMatchRepeatedLetter() {
        withWords("bee").
        andLetters('b', 'e', 'e').
        assertMatchesAre("bee");
    }

    @Test
    public void testNoMatchRepeatedLetterSameLength() {
        withWords("beer").
        andLetters('b', 'e', 'r', 'r').
        assertNoMatches();

    }
    @Test
    public void testMatchDifferentLength() {
        withWords("a", "ace", "fear", "bear", "piggy").
        andLetters('a', 'b', 'c', 'e', 'r').
        assertMatchesAre("a", "ace", "bear");
    }

    @Test
    public void testNoDuplicates() {
        withWords("no", "on").
        andLetters('e','o','n','c','j','c').
        assertMatchesAre("no", "on");
    }

    TestAllWordsThatMatch withWords(String... words) {
        matcher = new AllWordsFromCharactersForStrategy(asSet(words));
        return this;
    }

    TestAllWordsThatMatch andLetters(Character... letters) {
        matchableCharacters = asList(letters);
        return this;
    }

    void assertMatchesAre(String... matches) {
        assertThat(matcher.execute(matchableCharacters), is(asSet(matches)));
    }

    void assertNoMatches() {
        assertTrue(matcher.execute(matchableCharacters).isEmpty());
    }

    static <T> Set<T> asSet(T... values) {
        return Stream.of(values).collect(ImmutableCollector.toImmutableSet());
    }


}


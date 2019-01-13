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
    @Test
    public void testNoMatch_OnWordThatIsRightLength_ButWrongLetters() {

        Set<String> words = asSet("ear", "are", "era", "arc");
        List<Character> letters = asList('e', 'a', 'r');
        Set<String> answer = asSet("ear", "are", "era");

        assertThat(new AllWordsFromCharactersForStrategy(words).execute(letters), is(answer));

    }
    @Test
    public void testMatchRepeatedLetter() {
        Set<String> words = asSet("bee");
        List<Character> letters = asList('b', 'e', 'e');
        Set<String> answer = asSet("bee");
        assertThat(new AllWordsFromCharactersForStrategy(words).execute(letters), is(answer));

    }
    @Test
    public void testNoMatchRepeatedLetterSameLength() {
        Set<String> words = asSet("beer");
        List<Character> letters = asList('b', 'e', 'r', 'r');
        assertTrue(new AllWordsFromCharactersForStrategy(words).execute(letters).isEmpty());

    }
    @Test
    public void testMatchDifferentLength() {
        List<Character> letters = asList('a', 'b', 'c', 'e', 'r');
        Set<String> words = asSet("a", "ace", "fear", "bear", "piggy");
        Set<String> answer = asSet("a", "ace", "bear");
        assertThat(new AllWordsFromCharactersForStrategy(words).execute(letters), is(answer));
    }

    @Test
    public void testNoDuplicates() {
        List<Character> letters = asList('e','o','n','c','j','c');
        Set<String> words = asSet("no", "on");
        Set<String> answer = asSet("no", "on");
        assertThat(new AllWordsFromCharactersForStrategy(words).execute(letters), is(answer));
    }

    static <T> Set<T> asSet(T... values) {
        return Stream.of(values).collect(ImmutableCollector.toImmutableSet());
    }


}


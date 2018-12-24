package com.gunny.words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class TestAllWordsThatMatch {
    AllWordsFromCharacters obj;

    @BeforeEach
    public void setup() {
        obj = new AllWordsFromCharactersForStrategy();
    }

    @Test
    public void testNoMatch_OnWordThatIsRightLength_ButWrongLetters() {
        List<String> words = asList("ear", "are", "era", "arc");
        List<Character> letters = asList('e', 'a', 'r');
        List<String> answer = asList("ear", "are", "era");

        assertThat(obj.execute(words, letters), is(answer));

    }
    @Test
    public void testMatchRepeatedLetter() {
        List<String> words = asList("bee");
        List<Character> letters = asList('b', 'e', 'e');
        List<String> answer = asList("bee");
        assertThat(obj.execute(words, letters), is(answer));

    }
    @Test
    public void testNoMatchRepeatedLetterSameLength() {
        List<String> words = asList("beer");
        List<Character> letters = asList('b', 'e', 'r', 'r');
        assertTrue(obj.execute(words, letters).isEmpty());

    }
    @Test
    public void testMatchDifferentLength() {
        List<Character> letters = asList('a', 'b', 'c', 'e', 'r');
        List<String> words = asList("a", "ace", "fear", "bear", "piggy");
        List<String> answer = asList("a", "ace", "bear");
        assertThat(obj.execute(words, letters), is(answer));
    }
}


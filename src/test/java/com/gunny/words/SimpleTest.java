package com.gunny.words;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SimpleTest {

    @Test
    public void testSimple() {
        List<String> words = Arrays.asList("ear", "are", "era", "arc");
        List<Character> letters = Arrays.asList('e', 'a', 'r');
        List<String> answer = Arrays.asList("ear", "are", "era");
        assertThat(Words.wordsThatMatch(words, letters), is(answer));

    }
    @Test
    public void testWordSplit() {
        String input = "hemi";
        Collection<Character> hemiLetters = Words.Split(input);
        Collection<Character> answer = Arrays.asList('h', 'e', 'm', 'i');
        assertThat(hemiLetters, is (answer));
    }
    @Test
    public void testLegth() {
        List<String> words = Arrays.asList("ear", "are", "era", "bear");
        List<Character> letters = Arrays.asList('e', 'a', 'r');
        List<String> answer = Arrays.asList("ear", "are", "era");
        assertThat(Words.wordsThatMatch(words, letters), is(answer));

    }
    @Test
    public void onePickOne() {
        List<Character> input = Arrays.asList('a');
        int numberWanted = 1;
        List<List<Character>> answer = Arrays.asList(Arrays.asList('a'));
        List<List<Character>> actual = Words.Pick(input, numberWanted);
        assertThat(actual, is(answer));
    }
    @Test
    public void twoPickOne() {
        List<Character> input = Arrays.asList('a', 'b');
        int numberWanted = 1;
        List<List<Character>> answer = Arrays.asList(Arrays.asList('a'), Arrays.asList('b'));
        List<List<Character>> actual = Words.Pick(input, numberWanted);
        assertThat(actual, is(answer));
    }
    @Test
    public void ThreePickOne() {
        List<Character> input = Arrays.asList('a', 'b', 'c');
        int numberWanted = 1;
        List<List<Character>> answer = Arrays.asList(Arrays.asList('a'), Arrays.asList('b'), Arrays.asList('c'));
        List<List<Character>> actual = Words.Pick(input, numberWanted);
        assertThat(actual, is(answer));
    }
    @Test
    public void ThreePickTwo() {
        List<Character> input = Arrays.asList('a', 'b', 'c');
        int numberWanted = 2;
        List<List<Character>> answer = Arrays.asList(Arrays.asList('a', 'b'), Arrays.asList('a', 'c'), Arrays.asList('b', 'c'));
        List<List<Character>> actual = Words.Pick(input, numberWanted);
        assertThat(actual, is(answer));
    }
}

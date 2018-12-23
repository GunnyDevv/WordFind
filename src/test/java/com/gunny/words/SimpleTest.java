package com.gunny.words;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimpleTest {

    @Test
    public void testSimple() {
        List<String> words = asList("ear", "are", "era", "arc");
        List<Character> letters = asList('e', 'a', 'r');
        List<String> answer = asList("ear", "are", "era");
        assertThat(Words.wordsThatMatch(words, letters), is(answer));

    }
    @Test
    public void testDoubleLetter() {
        List<String> words = asList("bee");
        List<Character> letters = asList('b', 'e', 'e');
        List<String> answer = asList("bee");
        assertThat(Words.wordsThatMatch(words, letters), is(answer));

    }
    @Test
    public void testDoubleLetterSameLength() {
        List<String> words = asList("beer");
        List<Character> letters = asList('b', 'e', 'r', 'r');
        assertTrue(Words.wordsThatMatch(words, letters).isEmpty());

    }
    @Test
    public void testWordSplit() {
        String input = "hemi";
        Collection<Character> hemiLetters = Words.split(input);
        Collection<Character> answer = asList('h', 'e', 'm', 'i');
        assertThat(hemiLetters, is (answer));
    }
    @Test
    public void testLength() {
        List<String> words = asList("ear", "are", "era", "bear");
        List<Character> letters = asList('e', 'a', 'r');
        List<String> answer = asList("ear", "are", "era");
        assertThat(Words.wordsThatMatch(words, letters), is(answer));

    }
    @Test
    public void testMatchDifferentLength() {
        List<Character> letters = asList('a', 'b', 'c', 'e', 'r');
        List<String> words = asList("a", "ace", "fear", "bear", "piggy");
        List<String> answer = asList("a", "ace", "bear");
        assertThat(Words.wordsThatMatch(words, letters), is(answer));
    }
    @Test
    public void onePickOne() {
        List<Character> input = asList('a');
        int numberWanted = 1;
        Character [][] answer = {
                {'a'},
        };
        assertPick(input, numberWanted, arrayToList(answer));
    }
    @Test
    public void twoPickOne() {
        List<Character> input = asList('a', 'b');
        int numberWanted = 1;
        List<List<Character>> answer = asList(asList('a'), asList('b'));
        assertPick(input, numberWanted, answer);
    }
    @Test
    public void ThreePickOne() {
        List<Character> input = asList('a', 'b', 'c');
        int numberWanted = 1;
        Character [][] answer = {
                {'a'},
                {'b'},
                {'c'},
        };
        assertPick(input, numberWanted, arrayToList(answer));
    }
    @Test
    public void ThreePickTwo() {
        List<Character> input = asList('a', 'b', 'c');
        int numberWanted = 2;
        Character [][] answer = {
                {'a', 'b'},
                {'a', 'c'},
                {'b', 'c'},
        };
        assertPick(input, numberWanted, arrayToList(answer));
    }
    @Test
    public void FourPickTwo() {
        List<Character> input = asList('a', 'b', 'c', 'd');
        int numberWanted = 2;
        Character [][] answer = {
                {'a', 'b'},
                {'a', 'c'},
                {'a', 'd'},
                {'b', 'c'},
                {'b', 'd'},
                {'c', 'd'},
        };
        assertPick(input, numberWanted, arrayToList(answer));
    }

    @Test
    public void FivePickThree() {
        List<Character> input = asList('a', 'b', 'c', 'd', 'e');
        int numberWanted = 3;
        Character [][] answer = {
                {'a', 'b', 'c'},
                {'a', 'b', 'd'},
                {'a', 'b', 'e'},
                {'a', 'c', 'd'},
                {'a', 'c', 'e'},
                {'a', 'd', 'e'},
                {'b', 'c', 'd'},
                {'b', 'c', 'e'},
                {'b', 'd', 'e'},
                {'c', 'd', 'e'},

        };
        assertPick(input, numberWanted, arrayToList(answer));
    }

    private void assertPick(List<Character> input, int numberWanted, List<List<Character>> lists) {
        List<List<Character>> actual = Words.pick(input, numberWanted);
        assertThat(actual, is(lists));
    }

    private List<List<Character>> arrayToList(Character [][] array) {
        List<List<Character>> answer = new ArrayList<>(array.length);
        for(int arrayIdx = 0; arrayIdx < array.length; arrayIdx++) {
            answer.add(asList(array[arrayIdx]));
        }
        return answer;
    }
}

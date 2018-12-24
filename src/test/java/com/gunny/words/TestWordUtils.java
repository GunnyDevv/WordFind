package com.gunny.words;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestWordUtils {

    @Test
    public void testWordSplit() {
        String input = "hemi";
        Collection<Character> hemiLetters = WordUtils.split(input);
        Collection<Character> answer = asList('h', 'e', 'm', 'i');
        assertThat(hemiLetters, is (answer));
    }
    @Test
    public void testOnePickOne() {
        List<Character> input = asList('a');
        int numberWanted = 1;
        Character [][] answer = {
                {'a'},
        };
        assertPick(input, numberWanted, arrayToList(answer));
    }
    @Test
    public void testTwoPickOne() {
        List<Character> input = asList('a', 'b');
        int numberWanted = 1;
        List<List<Character>> answer = asList(asList('a'), asList('b'));
        assertPick(input, numberWanted, answer);
    }
    @Test
    public void testThreePickOne() {
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
    public void testThreePickTwo() {
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
    public void testFourPickTwo() {
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
    public void testFivePickThree() {
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
        List<List<Character>> actual = WordUtils.pick(input, numberWanted);
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

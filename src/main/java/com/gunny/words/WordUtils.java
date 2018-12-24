package com.gunny.words;

import java.util.*;

public class WordUtils {


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

}

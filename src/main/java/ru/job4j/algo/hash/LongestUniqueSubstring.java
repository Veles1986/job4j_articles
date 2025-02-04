package ru.job4j.algo.hash;

import java.util.HashSet;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        String result = "";
        HashSet<Character> charSet = new HashSet<>();
        char[] strToChar = str.toCharArray();
        int i, j = 0;
        for (i = 0; i < strToChar.length; i++) {
            if (!charSet.add(strToChar[i])) {
                if (result.length() < charSet.size()) {
                    result = str.substring(j, i);
                }
                i = ++j - 1;
                charSet.clear();
            }
        }
        if (result.isEmpty()) {
            result = str;
        }
        if (result.length() < charSet.size()) {
            result = str.substring(j, i);
        }
        return result;
    }
}
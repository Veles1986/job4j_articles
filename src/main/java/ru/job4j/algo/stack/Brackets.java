package ru.job4j.algo.stack;

import java.util.*;

class Brackets {
    private static final Map<Character, Character> brackets = new HashMap<>(Map.of('(', ')', '[', ']', '{', '}'));

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();
        for (char symbol : input) {
            if (brackets.containsKey(symbol)) {
                stack.push(symbol);
            } else if (brackets.containsValue(symbol)) {
                if (stack.empty() || !brackets.get(stack.pop()).equals(symbol)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}

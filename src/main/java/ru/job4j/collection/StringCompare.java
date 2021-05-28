package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
        @Override
        public int compare(String left, String right) {
            int word = Math.min(left.length(), right.length());
            for (int i = 0; i < word; i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    return Integer.compare(left.charAt(i), right.charAt(i));
                }
            }
            return Integer.compare(left.length(), right.length());
        }
    }


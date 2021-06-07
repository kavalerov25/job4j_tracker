package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> mapLeft = new HashMap<>();
        for (Character chr : left.toCharArray()) {
            if (mapLeft.containsKey(chr)) {
                mapLeft.put(chr, mapLeft.get(chr) + 1);
            } else {
                mapLeft.put(chr, 1);
            }
        }
        for (Character chr : right.toCharArray()) {
            if (mapLeft.containsKey(chr)) {
                int value = mapLeft.get(chr) - 1;
                mapLeft.put(chr, value);
                if (value == 0) {
                    mapLeft.remove(chr);
                }
            }
        }
        return mapLeft.isEmpty();
    }
}
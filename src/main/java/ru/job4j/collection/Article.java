package ru.job4j.collection;

import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originText = origin.split("[,.;!?\\s]");
        String[] text = line.split("[,.;!?\\s]");
        HashSet<String> check = new HashSet<>();
        for (String word : originText) {
            check.add(word.toLowerCase());
        }
        for (String articles : text) {
            if (!check.contains(articles.toLowerCase())) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}


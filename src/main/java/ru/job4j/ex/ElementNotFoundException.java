package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        /* for-each */
        int index = 0;
        for (String el : value) {
            if (el.equals(key)) {
                rsl = index;
                break;
            }
            index++;
        }
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"abc", "def", "gfh"};
        try {
            System.out.println(indexOf(array, "word"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

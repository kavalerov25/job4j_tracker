package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };

        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Comparator<String> cmpSize = (left, right) -> left.length() - right.length();
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();
        Arrays.sort(atts, comparator);
        for (Attachment a : atts) {
            System.out.println(a);
        }
    }
}
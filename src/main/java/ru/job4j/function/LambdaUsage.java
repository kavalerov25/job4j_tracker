package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] strings = {"один", "два", "тройка", "четыре", "пять" };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(strings, cmpDescSize);
        System.out.println(Arrays.asList(strings));
    }
}

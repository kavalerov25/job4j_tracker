package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-5, -3, -1, 0, 1, 3, 5));
        List<Integer> list = arrayList.stream().filter(x -> x >= 0).collect(Collectors.toList());
        System.out.println(list);
    }
}

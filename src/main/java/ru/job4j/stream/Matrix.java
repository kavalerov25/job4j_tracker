package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public List<Integer> convert(Integer[][] args) {
        return Arrays.stream(args)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}

package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MatrixTest {
    @Test
    public void whenConvert() {
        Integer[][] args = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix matrix = new Matrix();
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> rsl = matrix.convert(args);
        Assert.assertEquals(expect, rsl);
    }
}


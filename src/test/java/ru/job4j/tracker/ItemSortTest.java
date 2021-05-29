package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSortTest {

    @Test
    public void whenSortByName() {
        List<Item> input = Arrays.asList(
                new Item("D"),
                new Item("C"),
                new Item("B"),
                new Item("A")
        );
        List<Item> expect = Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C"),
                new Item("D")
        );
        input.sort(new ItemSortByName());
        assertThat(input, is(expect));
    }
}

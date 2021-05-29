package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
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

    /*Test
    public void whenSortByNameRes() {
        List<Item> input = Arrays.asList(
        new Item("D"),
        new Item("C"),
        new Item("B"),
        new Item("A"),
        new Item("E")
        );
        List<Item> expect = Arrays.asList(
                new Item("E"),
                new Item("D"),
                new Item("C"),
                new Item("B"),
                new Item("A")
        );
        input.sort(new ItemSortByNameResOrder());
        assertThat(input, is(expect));

     */
    }

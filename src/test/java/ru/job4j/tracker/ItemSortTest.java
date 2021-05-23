package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSortTest {

    @Test
    public void whenSortIncreaseId() {
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item(5,"A"));
        listItem.add(new Item(1,"V"));
        listItem.add(new Item(0,"O"));
        List<Item> listExpected = new ArrayList<>();
        listExpected.add(new Item(0,"O"));
        listExpected.add(new Item(1,"V"));
        listExpected.add(new Item(5,"A"));
        Collections.sort(listItem);
        assertThat(listItem, is(listExpected));
    }

    @Test
    public void whenSortDecreaseId() {
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item(5,"A"));
        listItem.add(new Item(1,"V"));
        listItem.add(new Item(0,"O"));
        List<Item> listExpected = new ArrayList<>();
        listExpected.add(new Item(5,"A"));
        listExpected.add(new Item(1,"V"));
        listExpected.add(new Item(0,"O"));
        Collections.sort(listItem, Collections.reverseOrder());
        assertThat(listItem, is(listExpected));
    }
}
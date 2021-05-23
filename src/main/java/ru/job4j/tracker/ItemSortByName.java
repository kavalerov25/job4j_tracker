package ru.job4j.tracker;

import java.util.ArrayList;
import  java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ItemSortByName implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}

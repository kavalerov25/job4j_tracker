package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        Item object = new Item();
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            object = items[index];
            if (object != null) {
                itemsWithoutNull[size] = object;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] ItemsNames = new Item[this.items.length];
        int count = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getName().equals(key)) {
                        ItemsNames[count] = this.items[i];
                        count++;
                    }
            }
        }
            ItemsNames = Arrays.copyOf(ItemsNames, count);
            return ItemsNames;
        }

        public Item findById(int id) {
            Item rsl = null;
            for (int index = 0; index < size; index++) {
                Item item = items[index];
                if (item.getId() == id) {
                    rsl = item;
                    break;
                }
            }
            return rsl;
        }
    }

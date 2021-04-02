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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsNames = new Item[this.items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (this.items[i].getName().equals(key)) {
                itemsNames[count] = this.items[i];
                count++;
            }
        }
        itemsNames = Arrays.copyOf(itemsNames, count);
        return itemsNames;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        if (indexOf(id) >= 0) {
            int index = indexOf(id);
            item.setId(id);
            items[index] = item;
            return true;
        } else {
            return false;
        }
    }
}

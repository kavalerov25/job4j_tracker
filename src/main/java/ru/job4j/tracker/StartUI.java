package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Путь");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(timeFormatter));
        Tracker way = new Tracker();
        way.add(item);
        System.out.println(way.findById(1).getName());
    }
}
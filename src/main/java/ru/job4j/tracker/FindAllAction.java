package ru.job4j.tracker;

import java.util.ArrayList;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Show all items");
        ArrayList<Item> array = tracker.findAll();
        for (int i = 0; i < array.size(); i++) {
            out.println(array.get(i));
        }
        return true;
    }
}



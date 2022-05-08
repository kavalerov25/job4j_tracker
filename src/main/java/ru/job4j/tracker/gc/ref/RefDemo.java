package ru.job4j.tracker.gc.ref;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RefDemo {
    public static void main(String[] args) {
        List<WeakReference<Object>> weakReferences = new ArrayList<>();
        weakReferences.add(new WeakReference<>("1 example"));
        weakReferences.add(new WeakReference<>("2 example"));
        weakReferences.add(new WeakReference<>("3 example"));
        for (WeakReference<Object> ref : weakReferences) {
            Object strong = ref.get();
            if (strong != null) {
                System.out.println(strong);
            }
        }
    }
}

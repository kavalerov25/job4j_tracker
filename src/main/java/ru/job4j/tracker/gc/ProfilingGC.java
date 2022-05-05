package ru.job4j.tracker.gc;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ProfilingGC {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) throws InterruptedException {
        info();
        MemTracker memTracker = new MemTracker();
        double start = System.currentTimeMillis();
        for (int i = 1; i < 1000000; i++) {
            Item item = new Item("item #" + i);
            item.setId(i);
            memTracker.add(item);
        }
        for (int i = 0; i < 1000000; i++) {
            memTracker.delete(i);
        }
        double finish = System.currentTimeMillis();
        System.out.printf("%nApp running time: %f%n%n", (finish - start) / 1000);
        info();
        Thread.sleep(100000);
    }
}
package ru.job4j.tracker;

public class GCDemo {
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

    public static void main(String[] args) {
        info();
        MemTracker memTracker = new MemTracker();
        double start = System.currentTimeMillis();
        for (int i = 1; i < 100_000; i++) {
            memTracker.add(new Item("item" + i));
        }
        double finish = System.currentTimeMillis();
        System.out.printf("%nApp running time: %f%n%n", (finish - start) / 1000);
        info();
    }
}

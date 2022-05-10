package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    private final DirFileCache dirFileCache;

    public Emulator(String directoryCache) {
        dirFileCache = new DirFileCache(directoryCache);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите директорию с файлами");
        String directoryName = scanner.next();
        DirFileCache cache = new DirFileCache(directoryName);
        boolean run = true;
        while (run) {
            System.out.println("Укажите имя файла");
            String fileName = scanner.next();
            System.out.println("Нажмите 1 для загрузки содержимого в кэш" + System.lineSeparator()
                               + "Нажмите 2 для получения содержимого из кэша");
            int task = scanner.nextInt();
            if (task == 1) {
                cache.put(fileName, cache.load(fileName));
            } else if (task == 2) {
                System.out.println(cache.get(fileName));
            }
            System.out.println("Нажмите 3 для выхода");
            int escape = scanner.nextInt();
            if (escape == 3) {
                run = false;
            }
        }
    }
}

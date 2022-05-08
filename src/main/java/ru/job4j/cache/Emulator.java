package ru.job4j.cache;

import java.util.concurrent.TimeUnit;

    public class Emulator {

        private final DirFileCache dirFileCache;

        public Emulator(String directoryCache) {
            dirFileCache = new DirFileCache(directoryCache);
        }

        public String getFileFromCache(String fileName) {
            return dirFileCache.get(fileName);
        }

        public String loadFileToCache(String fileName) {
            return dirFileCache.load(fileName);
        }

        public static void main(String[] args) throws InterruptedException {
            Emulator emulator = new Emulator("src/main/java/ru/job4j/cache");
            emulator.loadFileToCache("cities.txt");
            emulator.loadFileToCache("names.txt");
            System.gc();
            TimeUnit.SECONDS.sleep(3);

            String names = emulator.getFileFromCache("names.txt");
            if (names != null) {
                System.out.println(names);
            }
        }
    }
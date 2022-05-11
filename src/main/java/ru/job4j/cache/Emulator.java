package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Укажите директорию с файлами");
        String directoryName = SCANNER.nextLine();
        DirFileCache dirFileCache = new DirFileCache(directoryName);
        System.out.println("Введите название файла ");
        String fileName = SCANNER.nextLine();
        System.out.println("Введите что вы хотите: ");
        System.out.println("Нажмите 1 для загрузки содержимого в кэш" + System.lineSeparator()
                           + "Нажмите 2 для получения содержимого из кэша" + System.lineSeparator()
                           + "Нажмите 3 для выхода");
        int task = SCANNER.nextInt();
        switch (task) {
            case 1 -> {
                dirFileCache.put(fileName, dirFileCache.load(fileName));
                break;
            }
            case 2 -> {
                System.out.println(dirFileCache.get(fileName));
                break;
            }
            case 3 -> {
                break;
            }
            default -> System.out.println("Введите заново");
        }
    }
}

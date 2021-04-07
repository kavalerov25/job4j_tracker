package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        int count = 11;
        boolean turn = true;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 0 && matches <= 3) {
                turn = !turn;
                count -= matches;
                System.out.println("Осталось спичек на столе: " + count);
            } else {
                System.out.println("Вы ввели недопустимое число. Попробуйте еще раз");
            }
        }
        if (!turn) {
                System.out.println("Выиграл первый игрок");
            } else {
                System.out.println("Выиграл второй игрок");
            }
        }
    }


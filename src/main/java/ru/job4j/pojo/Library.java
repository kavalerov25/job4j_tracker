package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("1984");
        Book two = new Book("Animal Farm");
        Book three = new Book("dragonfly catcher");
        Book four = new Book("Clean code");
        Book[] knigi = new Book[4];
        knigi[0] = one;
        knigi[1] = two;
        knigi[2] = three;
        knigi[3] = four;
        for (int i = 0; i < knigi.length; i++) {
            System.out.println(knigi[i].getName());
        }
        System.out.println();
        System.out.println("Replace index 0 and 3");
        Book tmp =  new Book();
        tmp = knigi[0];
        knigi[0] = knigi[3];
        knigi[3] = tmp;
        for (int i = 0; i < knigi.length; i++) {
            System.out.println(knigi[i].getName());
        }
        System.out.println();
        for (int i = 0; i < knigi.length; i++) {
            if (knigi[i].getName().equals("Clean code")) {
                System.out.println(knigi[i].getName());
            }
        }
    }
}

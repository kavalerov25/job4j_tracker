package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        var bird = new BirdData();
        bird.setColor("white");
        bird.setAge(1);
        bird.setWingspan(12);
        System.out.println(bird);
    }
}

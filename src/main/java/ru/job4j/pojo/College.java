package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student kirill = new Student();
        kirill.setFullName("kirill kavalerov");
        kirill.setGroup("1271");
        kirill.setData(LocalDateTime.now());
        System.out.println(kirill.getFullName() + " learn in " + kirill.getGroup()
                           + " begins " + kirill.getData());
    }
}

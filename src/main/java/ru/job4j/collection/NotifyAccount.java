package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account account : accounts) {
                rsl.add(account);
            System.out.println("HashSet: " + rsl);
            System.out.println("The size of the set is: " + rsl.size());
        }

        return rsl;
    }
}
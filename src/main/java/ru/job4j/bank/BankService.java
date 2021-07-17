package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает действия с объектами User и Account.
 * Класс имеет поле users, которое хранит
 * в себе данные о пользователях(User) и их счетах(Account).
 *
 * @author kirill kavalerov
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить объект класса User в поле users,
     * класса BankService
     *
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить объект класса Account
     * по отношению к конкретному User.
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод проверяет наличие пользователя в системе по его паспорту
     *
     * @param passport
     * @return возвращает пользователя или null если такого пользователя нет
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам счета и паспорту пользователя
     *
     * @param passport
     * @param requisite
     * @return возвращает счет пользователя или null если такого счета нет
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> userByRequisite = findByPassport(passport);
        return userByRequisite.flatMap(user -> users.get(user)
                .stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод позволяет осуществить перевод денежных средств
     * с одного объекта класса Account к другому.
     *
     * @param srcPassport   - паспорт User от которого будет осуществляться перевод
     * @param srcRequisite  - реквизиты конкретного объекта класса Account.
     *                      Счет откуда будут списываться деньги
     * @param destPassport  - паспорт User которому будет осуществляться перевод
     * @param destRequisite - реквизиты конкретного объекта класса Account.
     *                      Счет на который будут зачисляться деньги
     * @param amount        - сумма которую необходимо перевести.
     * @return boolean - в случае успешного перевода,
     * метод возвращает true. В случае неудачного перевода
     * метод вернет false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> firstAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> secondAccount = findByRequisite(destPassport, destRequisite);
        if (firstAccount.isPresent() && secondAccount.isPresent() && firstAccount.get().getBalance() >= amount) {
            firstAccount.get().setBalance(firstAccount.get().getBalance() - amount);
            secondAccount.get().setBalance(secondAccount.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}


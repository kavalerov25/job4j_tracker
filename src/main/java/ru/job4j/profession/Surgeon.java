
package ru.job4j.profession;

public class Surgeon extends Doctor {
    private int quantityOperations;

    public Surgeon(String name, String surname,
                   String education, String birthday,
                   int quantityOperations) {
        super(name, surname, education, birthday);
        this.quantityOperations = quantityOperations;
    }

    public int getQuantityOperations() {
        return quantityOperations;
    }
}
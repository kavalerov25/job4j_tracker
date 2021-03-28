package ru.job4j.profession;

public class Builder extends Engineer {
    private String department;

    public Builder(String name, String surname, String education,
                   String birthday,
                   String department) {
        super(name, surname, education, birthday);
        this.department = department;
    }

    public void buildHouse(Client client) {

    }
}


package ru.job4j.profession;

public class Programmer extends Engineer {
    private String department;

    public Programmer(String name, String surname, String education,
                      String birthday, String department) {
        super(name, surname, education, birthday);
        this.department = department;
    }

    public void writeCod(Client client) {

    }
}
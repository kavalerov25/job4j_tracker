package ru.job4j.profession;

public class Engineer extends Profession {
    private String specialty;

    public Engineer(String name, String surname,
                    String education, String birthday,
                    String specialty) {
        super(name, surname, education, birthday);
        this.specialty = specialty;

    }

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getSpecialty() {
        return specialty;
    }
}
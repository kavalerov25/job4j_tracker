package ru.job4j.profession;

public class Dentist extends Doctor {
    private int experience;

    public Dentist(String name, String surname, String education, String birthday, int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}
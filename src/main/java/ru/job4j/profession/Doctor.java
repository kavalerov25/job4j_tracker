package ru.job4j.profession;

public class Doctor extends Profession {
    private String areaJob;

    public Doctor(String name, String surname,
                  String education,
                  String birthday,
                  String areaJob
                  ) {
        super(name, surname, education, birthday);
        this.areaJob = areaJob;
    }

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getAreaJob() {
        return areaJob;
    }
}
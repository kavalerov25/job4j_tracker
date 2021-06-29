package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void convert() {
        List<Student> studentList = List.of(
                new Student(50, "ivan"),
                new Student(30, "alex"),
                new Student(90, "kirill"),
                new Student(50, "ivan"),
                new Student(30, "alex")
        );
        ListToMap listToMap = new ListToMap();
        Map<String, Student> rsl = listToMap.convert(studentList);
        Map<String, Student> expected = Map.of(
                "ivan", new Student(50, "ivan"),
                "alex", new Student(30, "alex"),
                "kirill", new Student(90, "kirill")
        );
        assertThat(rsl, is(expected));
    }
}
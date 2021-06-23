package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProfilesTest {

    @Test
    public void whenCollectSuccessful() {
        Profiles pro = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Barmalei", 8, 88)),
                new Profile(new Address("SPB", "Borovay", 35, 13))
        );
        List<Address> expected = List.of(
                new Address("Moscow", "Barmalei", 8, 88),
                new Address("SPB", "Borovay", 35, 13)
        );
        List<Address> rsl = pro.collect(profiles);
        Assert.assertEquals(rsl, expected);
    }
}
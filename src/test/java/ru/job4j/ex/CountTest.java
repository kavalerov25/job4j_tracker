package ru.job4j.ex;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        Count.add(10, 2);
    }
    @Test
    public void when0to2then3() {
        int rsl = Count.add(0, 3);
        Assert.assertThat(rsl, Matchers.is(3));
    }
}
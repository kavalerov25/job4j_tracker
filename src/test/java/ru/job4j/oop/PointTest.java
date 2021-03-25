package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;


public class PointTest {
    @Test
    public void whenThreeCoordinatesThanGotDistance() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(3, 4, 5);
        double expected = 3.46;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when1to1And1then8() {
        double expected = 8.48;
        Point a = new Point(2, 2, 0);
        Point b = new Point(0, 0, 8);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}


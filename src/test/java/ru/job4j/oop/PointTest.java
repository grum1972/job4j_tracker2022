package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class PointTest {

    @Test
    public void distance() {
        Point point = new Point(3, 3);
        double dist = point.distance(new Point(4, 4));
        assertThat(dist, closeTo(1.41, 0.01));
    }

    @Test
    public void distance1() {
        Point point = new Point(0, 0, 0);
        double dist = point.distance3d(new Point(2, 2, 2));
        assertThat(dist, closeTo(3.464, 0.001));
    }
}
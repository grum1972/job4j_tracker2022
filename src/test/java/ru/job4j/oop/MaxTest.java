package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaxTest {

    @Test
    void max() {
        int rsl = new Max().max(2, 4);
        assertThat(rsl).isEqualTo(4);
    }

    @Test
    void testMax() {
        int rsl = new Max().max(2, 4, 3);
        assertThat(rsl).isEqualTo(4);
    }

    @Test
    void testMax1() {
        int rsl = new Max().max(2, 6, 1, 5);
        assertThat(rsl).isEqualTo(6);
    }
}
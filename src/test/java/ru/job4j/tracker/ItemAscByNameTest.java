package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void whenListItemAscByName() {
        Item first = new Item("AAA");
        Item second = new Item("BBB");
        Item third = new Item("CCC");
        List<Item> test = new ArrayList<>();
        test.add(first);
        test.add(third);
        test.add(second);
        List<Item> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        result.add(third);
        Collections.sort(test, new ItemAscByName());
        assertThat(test).isEqualTo(result);
    }

    @Test
    public void whenListItemDescByName() {
        Item first = new Item("AAA");
        Item second = new Item("BBB");
        Item third = new Item("CCC");
        List<Item> test = new ArrayList<>();
        test.add(first);
        test.add(third);
        test.add(second);
        List<Item> result = new ArrayList<>();
        result.add(third);
        result.add(second);
        result.add(first);
        Collections.sort(test, new ItemDescByName());
        assertThat(test).isEqualTo(result);
    }
}
package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {
    @Test
    void whenSortedThenOkFirst(){
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSortedThenOkSecond(){
        int[] array = {12, 14, 4, 7, 15, 0, -20};
        assertThat(Merge.mergesort(array)).containsExactly(-20, 0, 4, 7, 12, 14, 15);
    }
}
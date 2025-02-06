package ru.job4j.algo.sort;

import java.util.Arrays;

public class Merge {

    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int[] result = new int[left.length + right.length];
        for (int i = 0; i < result.length; i++) {
            if (leftIndex == left.length) {
                for (int j = rightIndex; j < right.length; j++) {
                    result[i] = right[j];
                    i++;
                }
                break;
            }
            if (rightIndex == right.length) {
                for (int j = leftIndex; j < left.length; j++) {
                    result[i] = left[j];
                    i++;
                }
                break;
            }
            if (left[leftIndex] <= right[rightIndex]) {
                result[i] = left[leftIndex];
                leftIndex++;
            } else {
                result[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return result;
    }
}
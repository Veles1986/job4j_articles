package ru.job4j.algo.interval;

public class IntervalMerge {
    public int[][] merge(int[][] intervals) {
        sortMatrix(intervals);
        int help = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                help = i;
            }
        }
        return trimArray(intervals, help);
    }

    private void sortMatrix(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 1; j < intervals.length; j++) {
                if (intervals[j][0] < intervals[j - 1][0]) {
                    int[] help = intervals[j];
                    intervals[j] = intervals[j - 1];
                    intervals[j - 1] = help;
                }
            }
        }
    }

    private int[][] trimArray(int[][] intervals, int index) {
        int[][] result = new int[intervals.length - index][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = intervals[index][0];
            result[i][1] = intervals[index][1];
            index++;
        }
        return result;
    }
}

package ru.job4j.algo.slidingwindow;

import java.util.*;

public class Main {

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[] {-1, -1};
        }

        intervals.sort(Comparator.comparingInt(Interval::getStart));

        var activeIntervals = new PriorityQueue<>(Comparator.comparingInt(Interval::getEnd));

        int maxOverLap = 0;

        int maxStart = -1;
        int maxEnd = -1;
        for (int i = 0; i < intervals.size(); i++) {
            while (!activeIntervals.isEmpty() && activeIntervals.peek().getEnd() < intervals.get(i).getStart()) {
                activeIntervals.poll();
            }
            activeIntervals.add(intervals.get(i));
            if (activeIntervals.size() > maxOverLap) {
                maxOverLap = activeIntervals.size();
                if (intervals.get(i).getStart() == activeIntervals.peek().getEnd()) {
                    maxStart = intervals.get(i - 1).getStart();
                    Interval last = activeIntervals.poll();
                    maxEnd = activeIntervals.peek().getEnd();
                    activeIntervals.add(last);
                } else {
                    maxStart = intervals.get(i).getStart();
                    maxEnd = activeIntervals.peek().getEnd();
                }
            }
        }
        return new int[] {
                maxStart, maxEnd
        };
    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}

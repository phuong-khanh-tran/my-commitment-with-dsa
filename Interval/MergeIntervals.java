package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            } else if (intervals[i - 1][1] < intervals[i][0]) {
                res.add(intervals[i - 1]);
            }
        }

        res.add(intervals[intervals.length - 1]);
        return res.toArray(new int[res.size()][]);
    }
}

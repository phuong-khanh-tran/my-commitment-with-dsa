package Interval;

import java.util.PriorityQueue;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int[] interval : intervals) {
            queue.offer(interval);
        }

        int[] prev = queue.poll();
        int count = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (prev[1] > curr[0]) {
                count++;
            } else {
                prev = curr;
            }
        }

        return count;
    }
}

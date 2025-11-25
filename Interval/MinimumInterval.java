package Interval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumInterval {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] sortQ = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortQ);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, Integer> map = new HashMap<>();

        int j = 0;
        for (int i = 0; i < sortQ.length; i++) {
            while (j < intervals.length && intervals[j][0] <= sortQ[i]) {
                queue.offer(new int[] { intervals[j][1], intervals[j][1] - intervals[j][0] + 1 });
                j++;
            }

            while (!queue.isEmpty() && queue.peek()[0] < sortQ[i]) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                map.put(sortQ[i], queue.peek()[1]);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (map.containsKey(queries[i])) {
                res[i] = map.get(queries[i]);
            } else {
                res[i] = -1;
            }
        }

        return res;
    }
}

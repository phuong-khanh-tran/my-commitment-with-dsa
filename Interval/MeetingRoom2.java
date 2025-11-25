package Interval;

import java.util.Arrays;
import java.util.List;

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRoom2 {
    public int minMeetingRooms(List<Interval> intervals) {
        int len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];

        for (int i = 0; i < len; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int count = 0;
        int res = 0;

        int s = 0;
        int e = 0;
        while (s < len) {
            if (starts[s] < ends[e]) {
                count++;
                s++;
            } else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}

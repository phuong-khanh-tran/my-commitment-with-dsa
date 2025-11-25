package Interval;

import java.util.List;

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRoom {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return true;
        }

        intervals.sort((a, b) -> a.start - b.start);

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (prev.end > intervals.get(i).start) {
                return false;
            }
            prev = intervals.get(i);

        }
        return true;
    }
}

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.add(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r + 1) >= k) {
                res[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}

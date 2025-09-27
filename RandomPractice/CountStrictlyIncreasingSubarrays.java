package RandomPractice;

public class CountStrictlyIncreasingSubarrays {
    public int countSub(int[] nums) {
        int prev = Integer.MAX_VALUE;
        int total = 0;
        int streak = 0;

        for (int num : nums) {
            if (num > prev) {
                streak += 1;
            } else {
                streak = 1;
            }
            total += streak;
            prev = num;

        }
        return total;
    }
}

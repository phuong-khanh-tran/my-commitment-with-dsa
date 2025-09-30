package RandomPractice;

public class CountStrictlyIncreasingSubarrays {
    public int countSub(int[] nums) {
        if (nums.length == 0)
            return 0;

        int streak = 1;
        int total = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                streak++;
            } else {
                streak = 1;
            }
            total += streak;
        }
        return total;
    }
}

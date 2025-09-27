package RandomPractice;

public class LongestMonotonicSubarray {
    public int longestMonotonicSubArray(int[] nums) {
        int currentLong = 1;
        int res = 1;
        int increasing = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (increasing > 0) {
                    currentLong++;
                } else {
                    currentLong = 2;
                    increasing = 1;
                }
            } else if (nums[i - 1] > nums[i]) {
                if (increasing < 0) {
                    currentLong++;
                } else {
                    currentLong = 2;
                    increasing = -1;
                }
            } else {
                currentLong = 1;
                increasing = 0;
            }
            res = Math.max(res, currentLong);
        }
        return res;
    }
}

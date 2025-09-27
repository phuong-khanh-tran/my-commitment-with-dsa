package RandomPractice;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumDistinctSubarraysWithLenK {
    public long maxSum(int[] nums, int k) {
        long res = 0;
        long currentSum = 0;
        Map<Integer, Integer> counts = new HashMap<>();

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            counts.put(nums[r], counts.getOrDefault(nums[r], 0) + 1);
            currentSum += nums[r];

            if (r - l + 1 > k) {
                counts.put(nums[l], counts.get(nums[l]) - 1);
                if (counts.get(nums[l]) == 0) {
                    counts.remove(nums[l]);
                }
                currentSum -= nums[l];
                l++;
            }

            if (counts.size() == k && r - l + 1 == k) {
                res = Math.max(res, currentSum);
            }
        }
        return res;
    }
}

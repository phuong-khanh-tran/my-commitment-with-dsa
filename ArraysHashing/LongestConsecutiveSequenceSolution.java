import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceSolution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniques = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            uniques.add(nums[i]);
        }

        int longest = 0;

        for (int num : uniques) {
            if (!uniques.contains(num - 1)) {
                int currStreak = 1;
                while (uniques.contains(num + currStreak)) {
                    currStreak++;
                }
                longest = Math.max(longest, currStreak);
            }
        }

        return longest;
    }
}

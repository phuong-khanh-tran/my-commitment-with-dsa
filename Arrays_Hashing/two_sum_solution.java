import java.util.HashMap;
import java.util.Map;

public class two_sum_solution {
    public int[] two_sum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int substraction = target - nums[i];
            if (!numMap.containsKey(substraction)) {
                numMap.put(nums[i], i);
            } else {
                return new int[] { numMap.get(substraction), i };
            }
        }

        return new int[] {};
    }

    public static void main(String[] arg) {
        two_sum_solution sol = new two_sum_solution();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = sol.two_sum(nums, target);
        System.out.println(res[0] + ", " + res[1]);
    }
}

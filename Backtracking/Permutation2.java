package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        res.add(subset);
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            subset.add(nums[j]);
            res.add(new ArrayList<>(subset));
            dfs(nums, j + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}

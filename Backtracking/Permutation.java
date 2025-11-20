package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, subset, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!subset.contains(nums[j])) {
                subset.add(nums[j]);
                dfs(nums, subset, res);
                subset.remove(subset.size() - 1);
            }
        }
    }
}

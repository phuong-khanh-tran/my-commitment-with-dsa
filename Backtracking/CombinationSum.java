package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, 0, 0, target, subset, res);
        return res;
    }

    private void dfs(int[] candidates, int i, int curr, int target, List<Integer> subset, List<List<Integer>> res) {
        if (curr >= target) {
            if (curr == target) {
                res.add(new ArrayList<>(subset));
            }
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            subset.add(candidates[j]);
            dfs(candidates, j, curr + candidates[j], target, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            subset.add(candidates[j]);
            dfs(candidates, j + 1, curr + candidates[j], target, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}

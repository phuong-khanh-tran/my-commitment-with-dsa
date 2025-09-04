import java.util.HashSet;
import java.util.Set;

public class contains_duplicate_solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        contains_duplicate_solution sol = new contains_duplicate_solution();
        int[] testArray = { 1, 2, 3, 4, 2 };

        System.out.println(sol.hasDuplicate(testArray));
    }

}

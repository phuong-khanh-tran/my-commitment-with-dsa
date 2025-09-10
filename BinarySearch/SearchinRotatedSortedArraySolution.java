public class SearchinRotatedSortedArraySolution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArraySolution sol = new SearchinRotatedSortedArraySolution();
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(sol.search(nums, target));

    }
}

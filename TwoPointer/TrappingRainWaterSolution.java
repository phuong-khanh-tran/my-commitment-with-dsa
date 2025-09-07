public class TrappingRainWaterSolution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int res = 0;

        prefix[0] = height[0];
        suffix[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            res += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int res = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                res += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                res += maxRight - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWaterSolution sol = new TrappingRainWaterSolution();
        int[] height = new int[] { 5, 4, 3, 2, 1 };
        int res = sol.trap(height);
        System.out.println(res);
    }
}

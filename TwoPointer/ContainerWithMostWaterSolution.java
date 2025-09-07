public class ContainerWithMostWaterSolution {
    public int maxArea(int[] heights) {
        if (heights.length < 2)
            return 0;
        int maxArea = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

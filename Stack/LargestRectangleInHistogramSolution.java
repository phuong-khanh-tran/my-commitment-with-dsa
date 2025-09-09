import java.util.Stack;

public class LargestRectangleInHistogramSolution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        Stack<int[]> stack = new Stack<>(); // pair: (index, height)
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                start = top[0];
                int area = (i - top[0]) * top[1];
                maxArea = Math.max(maxArea, area);
            }

            stack.push(new int[] { start, heights[i] });
        }

        int len = heights.length;
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int area = (len - top[0]) * top[1];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}

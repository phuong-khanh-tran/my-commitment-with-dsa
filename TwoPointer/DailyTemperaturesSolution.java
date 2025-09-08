import java.util.Stack;

public class DailyTemperaturesSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> monotonicStack = new Stack<>(); // store pair [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!monotonicStack.isEmpty() && temp > monotonicStack.peek()[0]) {
                int[] pair = monotonicStack.pop();
                res[pair[1]] = i - pair[1];
            }
            monotonicStack.add(new int[] { temp, i });
        }

        return res;

    }
}

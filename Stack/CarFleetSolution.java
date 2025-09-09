import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// A car fleet forms when a car behind catches up to a car ahead before reaching the target.
// Once it catches up, it slows down and adopts the arrival time of the car ahead.
// Key insight: If a car cannot catch up to the car ahead, it forms its own fleet.

// How can we can know when a fleet forms? 
// Ans: If timeBehind ≤ timeAhead → fleet forms

public class CarFleetSolution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> pairs = new ArrayList<>();
        Stack<Double> stack = new Stack<>(); // fleet count

        for (int i = 0; i < position.length; i++) {
            pairs.add(new int[] { position[i], speed[i] });
        }
        pairs.sort((a, b) -> b[0] - a[0]);

        for (int[] pair : pairs) {
            Double time = (double) (target - pair[0]) / pair[1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.add(time);
            }
        }

        return stack.size();
    }
}

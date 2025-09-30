package RandomPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OffsetArrays {

    private static Map<String, Map<Integer, Integer>> arrays = new HashMap<>();

    private static int evaluate(String expr) {
        expr = expr.trim();
        if (!expr.contains("[")) {
            return Integer.parseInt(expr);
        }

        int open = expr.indexOf("[");
        int close = expr.lastIndexOf("]");
        String name = expr.substring(0, open);
        String child = expr.substring(open + 1, close);
        int idx = evaluate(child);

        return arrays.get(name).get(idx);
    }

    private static void run() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] halves = line.split("=");
            String left = halves[0].trim();
            String right = halves[1].trim();
            String[] values = right.split("\\.\\.");

            int open = left.indexOf("[");
            int close = left.indexOf("]");

            String name = left.substring(0, open);
            String[] range = left.substring(open + 1, close).split("\\.\\.");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);

            Map<Integer, Integer> valMap = new HashMap<>();
            for (int j = 0; j <= end; j++) {
                valMap.put(start + j, Integer.parseInt(values[j]));
            }

            arrays.put(name, valMap);
        }

        // Query
        String query = in.nextLine().trim();
        int res = evaluate(query);

        System.out.println(res);
        in.close();
    }

    public static void main(String[] args) {
        OffsetArrays.run();
    }

}
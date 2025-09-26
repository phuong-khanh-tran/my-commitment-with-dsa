package RandomPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OffsetArrays {

    private static Map<String, Map<Integer, Integer>> arrays = new HashMap<>();

    private static int evaluate(String expr) {
        // Base
        expr = expr.trim();
        if (!expr.contains("[")) {
            return Integer.parseInt(expr);
        }

        String name = expr.substring(0, expr.indexOf("["));
        int open = expr.indexOf("[") + 1;
        int close = expr.lastIndexOf(']');
        String child = expr.substring(open, close);

        int index = evaluate(child);

        return arrays.get(name).get(index);
    }

    private static void run() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();

            String[] parts = line.split("=");
            String left = parts[0].trim();
            String right = parts[1].trim();

            String arrName = left.substring(0, left.indexOf('['));
            String inside = left.substring(left.indexOf('[') + 1, left.indexOf(']'));
            String[] range = inside.split("\\.\\.");
            int first = Integer.parseInt(range[0]);

            String[] values = right.split(" ");

            // Build a map
            Map<Integer, Integer> indexes = new HashMap<>();
            for (int j = 0; j < values.length; j++) {
                indexes.put(first + j, Integer.parseInt(values[j]));
            }

            arrays.put(arrName, indexes);
        }

        // Recursion
        String query = in.nextLine().trim();

        int res = evaluate(query);
        System.out.println(res);

        in.close();
    }

    public static void main(String[] args) {
        OffsetArrays.run();
    }

}
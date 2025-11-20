package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> paints = new HashMap<>();
        int[] res = new int[n];

        // Initialize all gardens
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build graph
        for (int[] p : paths) {
            int a = p[0], b = p[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // Paint each garden
        for (int garden = 1; garden <= n; garden++) {
            List<Integer> used = new ArrayList<>();
            for (int adj : graph.get(garden)) {
                Integer color = paints.get(adj);
                if (color != null)
                    used.add(color);
            }

            for (int c = 1; c <= 4; c++) {
                if (!used.contains(c)) {
                    paints.put(garden, c);
                    break;
                }
            }
        }

        // Build final array
        for (int i = 0; i < n; i++) {
            res[i] = paints.get(i + 1);
        }

        return res;
    }
}

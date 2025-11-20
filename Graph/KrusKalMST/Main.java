package Graph.KrusKalMST;

import java.util.Arrays;

public class Main {
    // Kruskal = always pick the cheapest edge, but only if it doesn’t form a cycle.

    int[][] res;
    int[][] edges;
    int[] set; // track parent
    int[] included; // used to check if checked
    int n;
    int e;

    Main(int n, int e) {
        this.n = n;
        this.e = e;

        edges = new int[][] {
                { 1, 1, 2, 2, 3, 4, 4, 5, 5 }, // u
                { 2, 6, 3, 7, 4, 5, 7, 6, 7 }, // v
                { 25, 5, 12, 10, 8, 16, 14, 20, 18 } // weight
        };

        set = new int[n + 1];
        Arrays.fill(set, -1);

        included = new int[e];
        res = new int[2][n - 1]; // spanning tree
    }

    private void union(int u, int v) {
        if (set[u] < set[v]) {
            set[u] += set[v];
            set[v] = u;
        } else {
            set[v] += set[u];
            set[u] = v;
        }
    }

    private int findParent(int u) {
        int x = u;
        while (set[x] > 0) {
            x = set[x];
        }
        while (u != x) {
            int temp = set[u];
            set[u] = x;
            u = temp;
        }
        return x;
    }

    public void findMST() {
        int i = 0;
        while (i < n - 1) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            int u = 0;
            int v = 0;

            // track minimum edge
            for (int j = 0; j < e; j++) {
                if (included[j] == 0 && edges[2][j] < min) {
                    min = edges[2][j];
                    k = j;
                    u = edges[0][j];
                    v = edges[1][j];
                }
            }

            int ru = findParent(u);
            int rv = findParent(v);
            // union if no cycle
            if (ru != rv) {
                res[0][i] = u;
                res[1][i] = v;
                union(ru, rv); // union by ROOTS
                i++;
            }
            included[k] = 1;
        }
    }

    public static void main(String[] strs) {
        Main mst = new Main(7, 9);
        mst.findMST();
        for (int i = 0; i < mst.n - 1; i++) {
            System.out.println(mst.res[0][i] + "," + mst.res[1][i]);
        }
    }
}

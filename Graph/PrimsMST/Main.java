package Graph.PrimsMST;

import java.util.Arrays;

public class Main {
    // Prim’s rule = always pick the cheapest edge that connects the current tree to
    // a new vertex.
    int[][] cost;
    int[] near;
    int[][] res;
    int n;

    Main(int n) {
        this.n = n;
        int I = Integer.MAX_VALUE;
        cost = new int[][] {
                { I, I, I, I, I, I, I, I },
                { I, I, 25, I, I, I, 5, I },
                { I, 25, I, 12, I, I, I, 10 },
                { I, I, 12, I, 8, I, I, I },
                { I, I, I, 8, I, 16, I, 14 },
                { I, I, I, I, 16, I, 20, 18 },
                { I, 5, I, I, I, 20, I, I },
                { I, I, 10, I, 14, 18, I, I }
        };
        near = new int[n + 1];
        Arrays.fill(near, I);
        res = new int[2][n - 1];
    }

    public void findMST() {
        int u = -1;
        int v = -1;

        // Find the minimum edge in the upper triangle in cost matrix
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (cost[i][j] < min) {
                    min = cost[i][j];
                    u = i;
                    v = j;
                }
            }
        }

        res[0][0] = u;
        res[1][0] = v;
        near[u] = 0;
        near[v] = 0;

        // For each vertex, determine whether it's closer to vertex u or v, and update
        // the near[] array accordingly.
        for (int i = 1; i <= n; i++) {
            if (near[i] != 0) {
                if (cost[i][u] < cost[i][v]) {
                    near[i] = u;
                } else {
                    near[i] = v;
                }
            }
        }

        // Fill result
        for (int i = 1; i < n - 1; i++) {
            // Find the cheapest cost in near array
            int cheapest = Integer.MAX_VALUE;
            int k = -1;

            for (int j = 1; j <= n; j++) {
                if (near[j] != 0 && cost[j][near[j]] < cheapest) {
                    cheapest = cost[j][near[j]];
                    k = j;
                }
            }

            res[0][i] = k;
            res[1][i] = near[k];
            near[k] = 0;

            // Update near array according to k
            for (int j = 1; j <= n; j++) {
                if (near[j] != 0 && cost[j][k] < cost[j][near[j]]) {
                    near[j] = k;
                }
            }
        }
    }

    public static void main(String[] strs) {
        Main mst = new Main(7);
        mst.findMST();
        for (int i = 0; i < mst.n - 1; i++) {
            System.out.println(mst.res[0][i] + "," + mst.res[1][i]);
        }
    }

}

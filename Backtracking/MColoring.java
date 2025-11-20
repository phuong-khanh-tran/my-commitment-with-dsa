package Backtracking;

public class MColoring {
    int[][] adjMatrix;
    int m;

    boolean isColoringPossible(int[][] adjMatrix, int m) {
        // add your logic here
        this.adjMatrix = adjMatrix;
        this.m = m;
        int totalNode = adjMatrix.length;

        return dfs(0, new int[totalNode]);
    }

    boolean dfs(int nodeNum, int[] colorTrack) {
        if (nodeNum == colorTrack.length) {
            return true;
        }

        for (int color = 1; color <= m; color++) {
            boolean isSafe = true;

            for (int i = 0; i < colorTrack.length; i++) {
                if (adjMatrix[nodeNum][i] == 1 && colorTrack[i] == color) {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                colorTrack[nodeNum] = color;
                boolean isGood = dfs(nodeNum + 1, colorTrack);

                if (!isGood) {
                    colorTrack[nodeNum] = 0;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
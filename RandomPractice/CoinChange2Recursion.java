package RandomPractice;

import java.util.Arrays;

public class CoinChange2Recursion {
    private int[][] memo;

    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return -1;
    }

    public int recursion(int amount, int[] coins, int index) {
        if (amount == 0)
            return 1;
        if (amount < 0 || index == coins.length) {
            return 0;
        }
        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int inclusion = recursion(amount - coins[index], coins, index);
        int skip = recursion(amount, coins, index + 1);

        memo[index][amount] = inclusion + skip;
        return memo[index][amount];
    }
}

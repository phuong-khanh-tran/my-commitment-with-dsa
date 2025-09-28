package RandomPractice;

import java.util.Arrays;

public class CoinChange {
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int res = recursionChange(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int recursionChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (memo[amount] != -1)
            return memo[amount];

        int leastCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = recursionChange(coins, amount - coin);
            if (sub != Integer.MAX_VALUE) {
                leastCoins = Math.min(leastCoins, sub + 1);
            }
        }
        memo[amount] = leastCoins;
        return leastCoins;
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        int[] coins = new int[] { 2 };
        int res = sol.coinChange(coins, 3);
        System.out.println((res));
    }
}

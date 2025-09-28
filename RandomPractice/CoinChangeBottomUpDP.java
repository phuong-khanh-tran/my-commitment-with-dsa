package RandomPractice;

import java.util.Arrays;

public class CoinChangeBottomUpDP {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0; // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int sub = i - coin;
                if (sub >= 0 && memo[sub] != Integer.MAX_VALUE) {
                    memo[i] = Math.min(memo[i], memo[sub] + 1);
                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}

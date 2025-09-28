package RandomPractice;

import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, 0);
        memo[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                int sub = i - coin;
                if (sub >= 0) {
                    memo[i] += memo[sub];
                }
            }
        }
        return memo[amount];
    }
}

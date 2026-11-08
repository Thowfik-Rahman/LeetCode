import java.util.*;

class Solution {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        // Base case
        dp[0] = 1;

        // Process each coin
        for (int coin : coins) {

            for (int j = coin; j <= amount; j++) {

                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
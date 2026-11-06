import java.util.*;

class Solution {

    // Method Type: Instance Method
    // Approach: 1D Dynamic Programming (Bottom-Up)
    // Data Structure: HashSet

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        // Base case
        dp[0] = true;

        // Fill DP array
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
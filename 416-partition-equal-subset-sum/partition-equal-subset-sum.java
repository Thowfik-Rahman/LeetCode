class Solution {

    public boolean canPartition(int[] nums) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // If total is odd, equal partition is impossible
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {

            // Traverse backwards so each number is used only once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}

class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        if (n == 0) {
            return 0;
        }

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        // Base cases
        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {

            // Holding a stock
            hold[i] = Math.max(
                hold[i - 1],
                rest[i - 1] - prices[i]
            );

            // Selling a stock
            sold[i] = hold[i - 1] + prices[i];

            // Resting / Cooldown
            rest[i] = Math.max(
                rest[i - 1],
                sold[i - 1]
            );
        }

        return Math.max(sold[n - 1], rest[n - 1]);
    }
}

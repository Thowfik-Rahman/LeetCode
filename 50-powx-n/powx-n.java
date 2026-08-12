class Solution {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        // Handle negative exponent
        if (n < 0) {
            return 1 / (x * myPow(x, -(n + 1)));
        }

        double half = myPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return half * half * x;
    }
}
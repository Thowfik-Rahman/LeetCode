class Solution {

    public int minimumSize(int[] nums, int maxOperations) {

        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isPossible(nums, maxOperations, mid)) {

                right = mid;

            } else {

                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isPossible(
            int[] nums, int maxOperations, int maxSize) {

        long operations = 0;

        for (int num : nums) {

            operations += (num - 1) / maxSize;

            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}
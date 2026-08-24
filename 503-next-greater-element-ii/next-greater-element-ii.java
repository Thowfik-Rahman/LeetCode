import java.util.*;

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        // Initially, assume no greater element exists
        Arrays.fill(result, -1);

        // Monotonic decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse the circular array twice
        for (int i = 2 * n - 1; i >= 0; i--) {

            int currentIndex = i % n;

            // Remove elements that cannot be the next greater element
            while (!stack.isEmpty() &&
                   stack.peek() <= nums[currentIndex]) {

                stack.pop();
            }

            // Fill answer only for the original array
            if (i < n && !stack.isEmpty()) {

                result[currentIndex] = stack.peek();
            }

            // Add current element
            stack.push(nums[currentIndex]);
        }

        return result;
    }
}
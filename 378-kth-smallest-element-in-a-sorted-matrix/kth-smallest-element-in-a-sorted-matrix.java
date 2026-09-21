import java.util.*;

class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int[] row : matrix) {

            for (int num : row) {

                maxHeap.offer(num);

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }
}
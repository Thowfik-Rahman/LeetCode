import java.util.*;

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(distance(b), distance(a))
        );

        for (int[] point : points) {

            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    private long distance(int[] point) {
        long x = point[0];
        long y = point[1];

        return x * x + y * y;
    }
}
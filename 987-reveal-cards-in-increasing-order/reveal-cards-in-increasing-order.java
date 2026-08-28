import java.util.*;

class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        Queue<Integer> queue = new ArrayDeque<>();

        // Store indexes
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }

        int[] result = new int[deck.length];

        for (int card : deck) {

            // Take first position
            int index = queue.poll();

            result[index] = card;

            // Move next position to the back
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return result;
    }
}
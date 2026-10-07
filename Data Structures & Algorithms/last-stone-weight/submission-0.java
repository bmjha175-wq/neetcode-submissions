class Solution {
    public int lastStoneWeight(int[] stones) {
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Continue until one or zero stones remain or we want only two largest elements from top
        while (maxHeap.size() > 1) {
            // Get two largest stones
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            // If they are different
            if (first != second) {
                // Difference becomes a new stone
                maxHeap.offer(first - second);
            }

            // If heap is empty, return 0
            if (maxHeap.isEmpty()) {
                return 0;
            }
        }
        return maxHeap.peek();
    }
}

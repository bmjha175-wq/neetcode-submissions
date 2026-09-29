class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        // low is maximum of all and high is sum of all weights
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentWeight = 0;
            int requiredDays = 1;

            for (int weight : weights) {
                if (currentWeight + weight > mid) {
                    requiredDays++;
                    currentWeight = 0;
                }
                currentWeight += weight;
            }
            if (requiredDays <= days) {
                // Capacity works, try smaller capacity
                high = mid - 1;
            } else {
                // Capacity is too small
                low = mid + 1;
            }
        }
        return low;
    }
}
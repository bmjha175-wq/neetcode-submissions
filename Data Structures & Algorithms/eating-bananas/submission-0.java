class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0; // maximum
        for (int pile : piles) {
            high = Math.max(pile, high);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
                // ceil function piles/number of rate
            }
            if (hours <= h) {
                // mid works, try a smaller speed
                high = mid - 1;
            } else {
                // mid is too slow
                low = mid + 1;
            }
        }
        return low;
    }
}

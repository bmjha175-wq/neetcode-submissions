class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int answer = 0;
        if (x < 2) {
            return x;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x / mid) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
}
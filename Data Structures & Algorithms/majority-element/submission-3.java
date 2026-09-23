class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // Hash Map approach
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > n/2) {
                return num;
            }
        }
       return -1;
    }
}
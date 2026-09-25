class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n= nums.length;
        for (int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0) +1);
        } 
        List<Integer> result = new ArrayList<>();
        
        for (int num : map.keySet()) 
        {
            int count = map.get(num);

            if (count > n / 3) {
                result.add(num);
            }
        }
        return result;
    }
}
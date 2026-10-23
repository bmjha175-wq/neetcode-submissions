class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    private void backtrack(
        int index, int[] nums, List<Integer> current, Set<List<Integer>> result) {
        if (index == nums.length) {
            // Add the current subset
            result.add(new ArrayList<>(current));
            return;
        }

        // Choose the element
        current.add(nums[index]);

        // Explore the next elements
        backtrack(index + 1, nums, current, result);

        // Backtrack: remove the last element
        current.remove(current.size() - 1);

        // Explore the next elements
        backtrack(index + 1, nums, current, result);
    }
}

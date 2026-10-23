class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
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

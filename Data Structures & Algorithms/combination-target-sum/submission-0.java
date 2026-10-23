class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int[] candidates, int target, List<Integer> current,
        List<List<Integer>> result) {
        // Target reached: valid combination found
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target exceeded: invalid combination
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Choose the current candidate
            current.add(candidates[i]);

            // Reuse the same candidate if needed
            backtrack(i, candidates, target - candidates[i], current, result);

            // Backtrack: remove the last chosen candidate
            current.remove(current.size() - 1);
        }
    }
}

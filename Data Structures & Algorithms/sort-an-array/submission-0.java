// Quick SORT
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(nums, low, high);
        // Sort left part
        quickSort(nums, low, pivotIndex - 1);
        // Sort right part
        quickSort(nums, pivotIndex + 1, high);
    }
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        // Put pivot in its correct position
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;
        return i;
    }
}
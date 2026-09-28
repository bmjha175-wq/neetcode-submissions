class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int k = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                result[k] = nums1[p1];
                p1++;
            } else {
                result[k] = nums2[p2];
                p2++;
            }
            k++;
        }
          // Copy remaining nums1 elements
        while (p1 < m) {
            result[k] = nums1[p1];
            p1++;
            k++;
        }

        // Copy remaining nums2 elements
        while (p2 < n) {
            result[k] = nums2[p2];
            p2++;
            k++;
        }

        // Copy result back into nums1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
}
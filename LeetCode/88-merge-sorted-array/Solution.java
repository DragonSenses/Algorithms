class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Step 1: Make a copy of the first m elements of nums1
    int[] nums1Copy = new int[m];
    System.arraycopy(nums1, 0, nums1Copy, 0, m);

    // Step 2: Initialize pointers for nums1Copy (p1), nums2 (p2), and nums1 (p)
    int p1 = 0, p2 = 0, p = 0;

    // Step 3: Merge nums1Copy and nums2 into nums1
    while (p1 < m && p2 < n) {
      if (nums1Copy[p1] <= nums2[p2]) {
        nums1[p++] = nums1Copy[p1++];
      } else {
        nums1[p++] = nums2[p2++];
      }
    }

    // Step 4: Copy any remaining elements from nums1Copy
    while (p1 < m) {
      nums1[p++] = nums1Copy[p1++];
    }

    // Step 5: Copy any remaining elements from nums2
    while (p2 < n) {
      nums1[p++] = nums2[p2++];
    }
  }
}

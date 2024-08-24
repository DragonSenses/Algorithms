class Solution {
  // Initialize two private pointers set to 0
  private int p1 = 0, p2 = 0;

  /**
   * Retrieves the next smallest value between two sorted number arrays and advances the pointers.
   *
   * @param nums1 First sorted number array.
   * @param nums2 Second sorted number array.
   * @return The smallest value between the two arrays.
   */
  private int getMin(int[] nums1, int[] nums2) {
    // If both arrays have elements remaining, compare and return the smaller value.
    if (p1 < nums1.length && p2 < nums2.length) {
      return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
    } else if (p1 < nums1.length) {
      // If only nums1 has elements remaining, return the value from nums1.
      return nums1[p1++];
    } else if (p2 < nums2.length) {
      // If only nums2 has elements remaining, return the value from nums2.
      return nums2[p2++];
    }
    // If both arrays are exhausted, return -1
    return -1;
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int totalSize = nums1.length + nums2.length;

    if ((totalSize & 1) == 0) {
      // Even-length case: Calculate the average of the two middle elements
      // Using 0-based indexing, the two middle elements are at indices
      // (totalSize / 2) - 1 and totalSize / 2.
      for (int i = 0; i < (totalSize / 2) - 1; i++){
        // Advance pointers by (totalSize / 2) - 1 to reach the two middle elements.
        int tmp = getMin(nums1, nums2);
      }
      // Return the average of the two middle elements
      return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) /2;
    } else {
      // Odd-length case: Return the exact middle element.
      for (int i = 0; i < totalSize / 2; i++) {
        // Advance pointers until we reach just before the middle element
        int tmp = getMin(nums1, nums2);
      }
      return getMin(nums1, nums2);
    }
  }
}

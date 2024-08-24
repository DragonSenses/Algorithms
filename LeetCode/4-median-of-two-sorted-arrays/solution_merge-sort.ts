function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  // Initialize two pointers set to 0
  let p1 = 0;
  let p2 = 0;

  const m = nums1.length,
        n = nums2.length;

  const totalSize = m + n;

  /**
   * Retrieves the next smallest value between two sorted number arrays and advances the pointers.
   *
   * @param nums1 First sorted number array.
   * @param nums2 Second sorted number array.
   * @returns The smallest value between the two arrays.
   */
  function getMin(nums1: number[], nums2: number[]): number {
    // If both arrays have elements remaining, compare and return the smaller value.
    if (p1 < m && p2 < n) {
      return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
    } else if (p1 < m) {
      // If only nums1 has elements remaining, return the value from nums1.
      return nums1[p1++];
    } else if (p2 < n) {
      // If only nums2 has elements remaining, return the value from nums2.
      return nums2[p2++];
    }
    // If both arrays are exhausted, return -1.
    return -1;
  }

  if ((totalSize & 1) === 0) {
    // Even-length case: Calculate the average of the two middle elements.
    // Using 0-based indexing, the two middle elements are at indices
    // (totalSize / 2) - 1 and totalSize / 2.
    for (let i = 0; i < totalSize / 2 - 1; i++) {
      // Advance pointers by (totalSize / 2) - 1 to reach the two middle elements.
      getMin(nums1, nums2);
    }
    // Return the average of the two middle elements.
    return (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
  } else {
    // Odd-length case: Return the exact middle element.
    for (let i = 0; i < Math.floor(totalSize / 2); i++) {
      // Advance pointers until we reach just before the middle element.
      getMin(nums1, nums2);
    }
    return getMin(nums1, nums2);
  }
}

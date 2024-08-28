class Solution {
  /**
   * Finds the median of two sorted arrays.
   * This method takes two sorted arrays, nums1 and nums2, and returns the median of the combined sorted arrays.
   * The overall run-time complexity should be O(log(min(m,n))).
   *
   * @param nums1 the first sorted array
   * @param nums2 the second sorted array
   * @return the median of the two sorted arrays
   * @throws IllegalArgumentException if either of the input arrays is null
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      throw new IllegalArgumentException("Input arrays must not be null");
    }

    // 1. Ensure nums1 is the smaller array; if not, swap them
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    // 2. Define the search space for the partition index
    int m = nums1.length, n = nums2.length;
    int left = 0, right = m; // Set the boundaries

    // 3. Perform binary search within the defined boundaries
    while (left <= right) {
      // 4. Calculate partition indices for both arrays
      int partitionA = (left + right) / 2;
      int partitionB = ((m + n + 1) / 2) - partitionA;

      // 5. Determine the edge elements around the partitions
      int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
      int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
      int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
      int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

      // 6. Check if we have found the correct partitions
      if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
        // 7. Calculate the median based on the combined array length
        if ((m + n) % 2 == 0) {
          return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
        } else {
          return Math.max(maxLeftA, maxLeftB);
        }
      } else if (maxLeftA > minRightB) {
        // Move towards the left in nums1
        right = partitionA - 1;
      } else {
        // Move towards the right in nums1
        left = partitionA + 1;
      }
    }

    // Fallback: If no median is found or expected condiions are not met
    return 0.0;
  }
}

/**
 * Merges two sorted arrays into the first one in-place using the reverse three-pointer technique.
 *
 * This implementation starts merging from the end of both arrays to avoid overwriting elements.
 * It assumes that nums1 has enough trailing space to hold all values from nums2.
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1) — in-place using only constant extra variables
 *
 * @param nums1 - The first array of size m + n. It contains m meaningful values followed by n empty slots.
 * @param m - Number of initialized elements in nums1.
 * @param nums2 - The second sorted array of size n.
 * @param n - Number of elements in nums2.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  let p1 = m - 1; // Last element in nums1
  let p2 = n - 1; // Last element in nums2
  let p = m + n - 1; // Last position in nums1

  // Merge from the back
  while (p1 >= 0 && p2 >= 0) {
    if (nums1[p1] > nums2[p2]) {
      nums1[p--] = nums1[p1--];
    } else {
      nums1[p--] = nums2[p2--];
    }
  }

  // If nums2 still has remaining elements
  while (p2 >= 0) {
    nums1[p--] = nums2[p2--];
  }
}

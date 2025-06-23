/**
 * Merges two sorted arrays into the first one in-place using the forward three-pointer technique.
 *
 * This approach creates a temporary copy of the meaningful portion of `nums1` (length `m`),
 * then uses two read pointers and one write pointer to merge the elements from left to right.
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(m) due to the temporary copy of nums1
 *
 * @param nums1 - The first input array of size m + n. The first m elements are valid; the rest are placeholders.
 * @param m - The number of valid elements in nums1.
 * @param nums2 - The second input array of size n.
 * @param n - The number of elements in nums2.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  // Step 1: Copy the first m elements of nums1
  const nums1Copy = nums1.slice(0, m);

  // Step 2: Initialize pointers
  let p1 = 0; // Pointer for nums1Copy
  let p2 = 0; // Pointer for nums2
  let p = 0;  // Write pointer for nums1

  // Step 3: Merge nums1Copy and nums2 into nums1
  while (p1 < m && p2 < n) {
    if (nums1Copy[p1] <= nums2[p2]) {
      nums1[p++] = nums1Copy[p1++];
    } else {
      nums1[p++] = nums2[p2++];
    }
  }

  // Step 4: Copy remaining elements from nums1Copy (if any)
  while (p1 < m) {
    nums1[p++] = nums1Copy[p1++];
  }

  // Step 5: Copy remaining elements from nums2 (if any)
  while (p2 < n) {
    nums1[p++] = nums2[p2++];
  }
}

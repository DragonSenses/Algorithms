/**
 * Merges two sorted integer arrays into one sorted array in-place.
 *
 * This implementation uses the reverse three-pointer technique: - Starts merging from the end of
 * nums1 and nums2 to avoid overwriting. - Uses two read pointers (`p1` for nums1, `p2` for nums2)
 * and one write pointer (`p`) from the end of nums1. - Assumes nums1 has enough trailing space to
 * accommodate all elements from both arrays.
 *
 * Time Complexity: O(m + n) 
 * Space Complexity: O(1) (in-place merge using constant extra space)
 *
 * @param nums1 The destination array with size m + n. The first m elements are valid; the rest are
 *        zeros.
 * @param m The number of initialized elements in nums1.
 * @param nums2 The second sorted input array of size n.
 * @param n The number of elements in nums2.
 */
class Solution2 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Initialize pointers
    int p1 = m - 1; // Last element in nums1
    int p2 = n - 1; // Last element in nums2
    int p = m + n - 1; // Last index in nums1

    // Merge from the end
    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] > nums2[p2]) {
        nums1[p--] = nums1[p1--];
      } else {
        nums1[p--] = nums2[p2--];
      }
    }

    // If nums2 still has elements, copy them
    while (p2 >= 0) {
      nums1[p--] = nums2[p2--];
    }
  }
}
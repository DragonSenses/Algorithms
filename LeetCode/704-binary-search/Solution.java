/**
 * Performs binary search on a sorted array to find the index of a target value.
 *
 * This method assumes the input array is sorted in non-decreasing order.
 * It uses an iterative two-pointer approach with an overflow-safe midpoint calculation.
 *
 * @param nums   the sorted array of integers
 * @param target the value to search for
 * @return the index of the target if found; otherwise, -1
 */
class Solution {
  public int search(int[] nums, int target) {
    // Initialize search boundaries
    int left = 0;
    int right = nums.length - 1;

    // Loop until the search space is exhausted
    while (left <= right) {
      // Compute midpoint using unsigned right shift to avoid overflow
      int mid = (left + right) >>> 1;

      // Check if the midpoint value matches the target
      if (nums[mid] == target) {
        return mid; // Target found
      }
      // If target is greater, discard left half
      else if (nums[mid] < target) {
        left = mid + 1;
      }
      // If target is smaller, discard right half
      else {
        right = mid - 1;
      }
    }

    // Target not found in array
    return -1;
  }
}
/**
 * Searches for a target value in a rotated sorted array that may contain duplicates. Uses a
 * modified binary search approach to handle rotation and duplicate ambiguity.
 */
class Solution {

  /**
   * Performs binary search in a rotated sorted array.
   *
   * @param nums The input array (may contain duplicates).
   * @param target The value to search for.
   * @return True if the target exists in the array, otherwise false.
   */
  public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2; // Calculate midpoint safely to avoid overflow.

      // Found target
      if (nums[mid] == target) {
        return true;
      }

      // Handle duplicate ambiguity
      if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
        start++; // Reduce search space by incrementing start.
        end--; // Reduce search space by decrementing end.
        continue;
      }

      // Identifying the sorted half
      if (nums[start] <= nums[mid]) { // Left segment is sorted
        if (nums[start] <= target && target < nums[mid]) {
          end = mid - 1; // Search in the left half
        } else {
          start = mid + 1; // Search in the right half
        }
      } else { // Right segment is sorted
        if (nums[mid] < target && target <= nums[end]) {
          start = mid + 1; // Search in the right half
        } else {
          end = mid - 1; // Search in the left half
        }
      }
    }

    // Target not found
    return false;
  }
}

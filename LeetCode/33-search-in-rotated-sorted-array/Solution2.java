/**
 * Searches for a target value in a rotated sorted array using a one-pass binary search.
 * 
 * @param nums   The rotated sorted array of distinct integers.
 * @param target The target number to search for.
 * @return Index of the target if found, otherwise -1.
 */
class Solution2 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    // Perform binary search while adjusting boundaries dynamically
    while (left <= right) {
      int mid = left + (right - left) / 2; // Prevents potential integer overflow

      // If target is found, return its index
      if (nums[mid] == target) {
        return mid; 
      }

      // Determine which half is sorted
      if (nums[left] <= nums[mid]) { // Left half is sorted
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1; // Search in left sorted half
        } else {
          left = mid + 1; // Search in right half
        }
      } else { // Right half is sorted
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1; // Search in right sorted half
        } else {
          right = mid - 1; // Search in left half
        }
      }
    }

    return -1; // Target not found
  }
}
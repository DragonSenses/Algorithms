class Solution {
  public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      // Found target
      if (nums[mid] == target) {
        return true;
      }

      // Identifying the sorted half
      if (nums[start] <= nums[mid]) { // Left segment is sorted
        if (nums[start] <= target && target < nums[mid]) {
          // Search in left half
          end = mid - 1;
        } else {
          // Search in right half
          start = mid + 1;
        }
      }

    }

    // Target not found
    return false;
  }
}
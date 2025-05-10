class Solution2 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2; // Prevents potential overflow

      // Found target
      if (nums[mid] == target) {
        return mid; // Target found
      }

      // Check if left half is sorted
      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1; // Search in left sorted half
        } else {
          left = mid + 1; // Search in right half
        }
      } else {
        // Right half is sorted
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

class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    // 1. Find Pivot Index (Smallest Element)
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    int pivotIndex = left;

    // 2. Determine search bounds
    left = 0;
    right = nums.length - 1;
    if (target >= nums[pivotIndex] && target <= nums[right]) {
      left = pivotIndex;
    } else {
      right = pivotIndex - 1;
    }

    // 3. Perform Binary Search in Chosen Half
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid; // Target found
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1; // Target not found
  }
}
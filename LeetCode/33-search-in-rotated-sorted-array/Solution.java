class Solution {
  public int search(int[] nums, int target) {
    // Declare variables
    int mid = 0;
    int left = 0;
    int right = nums.length - 1;
    int pivotIndex = -1;

    // 1. Find Pivot Index (Smallest Element)
    while (left < right) {
      mid = (left + right) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    // Found smallest element
    pivotIndex = left;

    // 2. Determine search bounds
    left = 0;
    right = nums.length - 1;
    if (target >= nums[pivotIndex] && target <= nums[right]) {
      left = pivotIndex;
    } else {
      right = pivotIndex - 1;
    }

    // 3. Perform binary search
    while (left <= right) {
      mid = (left + right) / 2;
      if (nums[mid] == target) {
        // Target found
        return mid;
      } else if (nums[mid] < target){
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    // Target not found
    return -1; 
  }
}
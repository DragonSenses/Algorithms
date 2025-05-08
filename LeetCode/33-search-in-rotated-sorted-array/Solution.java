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

  }
}
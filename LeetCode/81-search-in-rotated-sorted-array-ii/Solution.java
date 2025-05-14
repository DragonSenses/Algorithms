class Solution {
  public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      // Found target
      if (nums[mid] == target) {
        return true;
      }

    }

    // Target not found
    return false;
  }
}
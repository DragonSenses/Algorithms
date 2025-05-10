class Solution2 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2; // Prevents potential overflow

      if (nums[mid] == target) {
        return mid; // Target found
      }

    }

    return -1; // Target not found
  }
}

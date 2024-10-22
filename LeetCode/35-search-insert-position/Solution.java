class Solution {
  /**
   * This method searches for the target value in a sorted array and returns its index. 
   * If the target is not found, it returns the position where it should be inserted.
   *
   * @param nums   a sorted array of integers
   * @param target the integer value to search for
   * @return       the index of the target if found, otherwise the position where it should be inserted
   */
  public int searchInsert(int[] nums, int target) {
    // Initialize the pointers
    int left = 0;
    int right = nums.length - 1;
    int pivot;

    // Perform binary search
    while (left <= right) {
        // Calculate the pivot index
        pivot = (left + right) >> 1;

        // Check if the pivot element is the target
        if (nums[pivot] == target) {
            return pivot; // Target found
        } else if (nums[pivot] > target) {
            right = pivot - 1; // Search left subarray
        } else {
            left = pivot + 1; // Search right subarray
        }
    }

    // Target not found, return the insertion point
    return left;
  }
}
class Solution {
  /**
   * Finds the maximum sum of a contiguous subarray in the given array.
   *
   * @param nums the input array of integers
   * @return the maximum sum of a contiguous subarray
   */
  public int maxSubArray(int[] nums) {
    // Initialize variables using the first element
    int currentSubarray = nums[0];
    int maxSubarray = nums[0];

    // Iterate through the array starting from the second element
    for (int i = 1; i < nums.length; i++) {
      // If current subarray is negative, discard it (set it to 0)
      // Otherwise, keep adding to current subarray
      currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
      maxSubarray = Math.max(currentSubarray, maxSubarray);
    }

    return maxSubarray;
  }
}

/**
 * Finds the maximum sum of a contiguous subarray in the given array.
 *
 * @param nums the input array of integers
 * @return the maximum sum of a contiguous subarray
 */
function maxSubArray(nums: number[]): number {
  // Initialize variables using the first element
  let currentSubarray = nums[0];
  let maxSubarray = nums[0];

  // Iterate through the array starting from the second element
  for (let i = 1; i < nums.length; i++) {
    // If current subarray is negative, discard it (set it to 0)
    // Otherwise, keep adding to current subarray
    currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
    maxSubarray = Math.max(currentSubarray, maxSubarray);
  }

  return maxSubarray;
}

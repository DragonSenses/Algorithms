/**
 * Searches for a target value in a rotated sorted array.
 *
 * @param {number[]} nums - A rotated sorted array of distinct integers.
 * @param {number} target - The target number to search for.
 * @returns {number} - Index of the target if found, otherwise -1.
 */
function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  // Perform Binary Search while accounting for rotation
  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2);

    // Case 1: Found target at mid
    if (nums[mid] === target) {
      return mid;
    }

    // Determine which half is sorted
    if (nums[left] <= nums[mid]) {
      // Left portion is sorted
      if (nums[left] <= target && target < nums[mid]) {
        right = mid - 1; // Narrow search to left half
      } else {
        left = mid + 1; // Search in the right half
      }
    } else {
      // Right portion is sorted
      if (nums[mid] < target && target <= nums[right]) {
        left = mid + 1; // Narrow search to right half
      } else {
        right = mid - 1; // Search in the left half
      }
    }
  }

  return -1; // Target not found
}
/**
 * Searches for a target value in a rotated sorted array using a one-pass binary search.
 *
 * @param {number[]} nums - The rotated sorted array of distinct integers.
 * @param {number} target - The target number to search for.
 * @returns {number} - Index of the target if found, otherwise -1.
 *
 * @example
 * search([4,5,6,7,0,1,2], 0) -> 4
 * search([4,5,6,7,0,1,2], 3) -> -1
 * search([1], 0) -> -1
 *
 * @description
 * Instead of explicitly detecting the pivot, this implementation determines
 * which half of the array is sorted and adjusts the search dynamically.
 */
function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  // Perform binary search while handling rotation dynamically
  while (left <= right) {
    // Prevents potential overflow
    let mid = Math.floor(left + (right - left) / 2);

    // Found target
    if (nums[mid] === target) {
      return mid;
    }

    // Determine which half is sorted
    if (nums[left] <= nums[mid]) {
      // Left half is sorted
      if (nums[left] <= target && target < nums[mid]) {
        // Search in left sorted half
        right = mid - 1;
      } else {
        // Search in right half
        left = mid + 1;
      }
    } else {
      // Right half is sorted
      if (nums[mid] < target && target <= nums[right]) {
        // Search in right sorted half
        left = mid + 1;
      } else {
        // Search in left half
        right = mid - 1;
      }
    }
  }

  // Target not found
  return -1;
}

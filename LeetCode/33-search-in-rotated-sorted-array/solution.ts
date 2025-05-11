/**
 * Searches for a target value in a rotated sorted array using a two-pass binary search.
 *
 * @param {number[]} nums - The rotated sorted array of distinct integers.
 * @param {number} target - The target number to search for.
 * @returns {number} - Index of the target if found, otherwise -1.
 *
 * @example
 * search([4,5,6,7,0,1,2], 0) -> 4
 * search([4,5,6,7,0,1,2], 3) -> -1
 * search([1], 0) -> -1
 */
function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  // 1. Find Pivot Index (Smallest Element)
  while (left < right) {
    const mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] > nums[right]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }

  const pivotIndex = left;

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
    const mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] === target) {
      return mid; // Target found
    } else if (nums[mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return -1; // Target not found
}

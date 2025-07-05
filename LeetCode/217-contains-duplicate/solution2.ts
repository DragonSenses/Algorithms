/**
 * Determines whether the input array contains any duplicate integers.
 *
 * This function sorts the input array in ascending order,
 * then performs a single linear scan comparing adjacent elements.
 * If any two consecutive values are equal, a duplicate is detected.
 *
 * Time Complexity: O(n log n) due to sorting.
 * Space Complexity: O(1) assuming in-place sort.
 *
 * @param nums - The input array of integers
 * @returns true if any value appears more than once; false otherwise
 */
function containsDuplicate(nums: number[]): boolean {
  // Sort the array so duplicates become adjacent
  nums.sort((a, b) => a - b);

  // Scan the sorted array for any adjacent duplicates
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] === nums[i - 1]) return true; // Found a duplicate
  }

  return false; // No duplicates found
};
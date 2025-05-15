/**
 * Searches for a target value in a rotated sorted array that may contain duplicates.
 * Uses a modified binary search to handle rotation and ambiguity caused by duplicates.
 *
 * @param nums - The input array (may contain duplicates).
 * @param target - The value to search for.
 * @returns True if the target exists in the array, otherwise false.
 */
function search(nums: number[], target: number): boolean {
  // Initialize search boundaries
  let start = 0;
  let end = nums.length - 1;

  while (start <= end) {
    // Calculate the midpoint safely to avoid overflow
    let mid = Math.floor(start + (end - start) / 2);

    // Found target
    if (nums[mid] === target) {
      return true;
    }

    // Handle duplicate ambiguity by reducing the search space
    if (nums[start] === nums[mid] && nums[mid] === nums[end]) {
      start++; // Increment start to skip duplicate
      end--;   // Decrement end to narrow search space
      continue;
    }

    // Identifying the sorted half
    if (nums[start] <= nums[mid]) {
      // Left segment is sorted
      if (nums[start] <= target && target < nums[mid]) {
        // Search in left half
        end = mid - 1;
      } else {
        // Search in right half
        start = mid + 1;
      }
    } else {
      // Right segment is sorted
      if (nums[mid] < target && target <= nums[end]) {
        // Search in right half
        start = mid + 1;
      } else {
        // Search in left half
        end = mid - 1;
      }
    }
  }

  // Target not found
  return false;
};
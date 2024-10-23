/**
 * Finds the index at which the target should be inserted in the sorted array nums.
 * If the target is found, returns its index.
 * 
 * @param nums - The sorted array of numbers.
 * @param target - The target number to search for.
 * @returns The index where the target should be inserted.
 */
function searchInsert(nums: number[], target: number): number {
  // Initialize the left and right pointers
  let left: number = 0;
  let right: number = nums.length - 1;

  // Perform binary search
  while (left <= right) {
    // Calculate the pivot index
    let pivot: number = Math.floor((left + right) / 2);

    // Check if the pivot element is the target
    if (nums[pivot] === target) {
      return pivot;
    } else if (nums[pivot] > target) {
      // Search left subarray
      right = pivot - 1;
    } else {
      // Search right subarray
      left = pivot + 1;
    }
  }

  // Return the insertion point
  return left;
};

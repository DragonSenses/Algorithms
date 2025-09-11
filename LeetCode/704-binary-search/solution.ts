/**
 * Performs binary search on a sorted array to find the index of a target value.
 *
 * @param nums - A sorted array of unique integers in ascending order.
 * @param target - The integer value to search for within the array.
 * @returns The index of the target if found; otherwise, returns -1.
 */
function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    if (target === nums[mid]) {
      return mid;
    }

    if (target < nums[mid]) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return -1;
}
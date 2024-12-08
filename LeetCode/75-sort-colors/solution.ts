/**
 * Sorts the given array in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * @param nums - The array of integers representing the colors (0, 1, 2).
 *               This function modifies the array in-place and does not return anything.
 */
function sortColors(nums: number[]): void {
  // Initialize pointers for boundaries
  let p0: number = 0;
  let curr: number = 0;
  let p2: number = nums.length - 1;

  // Traverse the array
  while (curr <= p2) {
    if (nums[curr] === 0) {
      // Swap current element with the element at p0
      [nums[curr], nums[p0]] = [nums[p0], nums[curr]];
      p0++;
      curr++;
    } else if (nums[curr] === 2) {
      // Swap current element with the element at p2
      [nums[curr], nums[p2]] = [nums[p2], nums[curr]];
      p2--;
    } else {
      curr++;
    }
  }
}

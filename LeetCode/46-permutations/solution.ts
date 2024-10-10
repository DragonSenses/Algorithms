/**
 * Generates all permutations of the given array of integers.
 *
 * @param {number[]} nums - The array of integers to permute.
 * @returns {number[][]} - A list of all permutations.
 */
function permute(nums: number[]): number[][] {
  const result: number[][] = [];
  backtrack(nums, 0, result);
  return result;
}

/**
* Helper function to generate permutations using backtracking.
*
* @param {number[]} nums - The array of integers to permute.
* @param {number} startIndex - The index of the first integer to consider for the current permutation.
* @param {number[][]} result - The list to store all permutations.
*/
function backtrack(nums: number[], startIndex: number, result: number[][]): void {
  // Base case: If the startIndex equals the length of nums, the current permutation is complete.
  if (startIndex === nums.length) {
      result.push([...nums]);
      return;
  }

  // Iterate over the integers from startIndex to the end of the array
  for (let i = startIndex; i < nums.length; i++) {
      // Swap the current index with startIndex to place the i-th integer first in the permutation
      [nums[startIndex], nums[i]] = [nums[i], nums[startIndex]];
      // Recursively generate permutations for the next position
      backtrack(nums, startIndex + 1, result);
      // Backtrack by undoing the swap
      [nums[startIndex], nums[i]] = [nums[i], nums[startIndex]];
  }
}

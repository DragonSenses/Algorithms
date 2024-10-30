/**
 * Uses a recursive backtracking approach to generate all subsets.
 * 
 * @param {number} first - The index of the first element to add.
 * @param {number[]} curr - The current combination being formed.
 * @param {number[]} nums - The input array of unique numbers.
 * @param {number[][]} output - The final list of all subsets.
 * @param {number} k - The desired length of the current combination.
 */
function backtrack(first: number, curr: number[], nums: number[], output: number[][], k: number) {
  // If the current combination is done
  if (curr.length === k) {
      output.push([...curr]);
      return;
  }
  for (let i = first; i < nums.length; i++) {
      // Add nums[i] into the current combination
      curr.push(nums[i]);
      // Use next integers to complete the combination
      backtrack(i + 1, curr, nums, output, k);
      // Backtrack by removing nums[i]
      curr.pop();
  }
}

/**
* Finds all possible subsets of the given integer array using a recursive backtracking approach.
* 
* @param {number[]} nums - An array of unique integers.
* @returns {number[][]} A list of all possible subsets.
*/
function subsets(nums: number[]): number[][] {
  const output: number[][] = [];
  // Iterate over all possible lengths
  for (let k = 0; k <= nums.length; k++) {
      backtrack(0, [], nums, output, k);
  }
  return output;
}

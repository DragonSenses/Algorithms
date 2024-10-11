/**
 * A helper method to perform backtracking to generate permutations.
 *
 * @param currCombination - The current combination of numbers being built
 * @param N - The length of the input array
 * @param numsMap - A map storing the count of remaining numbers to use
 * @param results - The list to store all unique permutations
 */
function backtrack(
  currCombination: number[],
  N: number,
  numsMap: Map<number, number>,
  results: number[][]): void {

  // If the combination is done, add it to the results
  if (currCombination.length === N) {
    results.push([...currCombination]); // Make a deep copy of the resulting permutation
    return;
  }

  // Iterate over the numsMap
  for (const [num, count] of numsMap.entries()) {
    if (count === 0) continue;

    // Add this number into the current combination
    currCombination.push(num);
    numsMap.set(num, count - 1);

    // Continue the exploration
    backtrack(currCombination, N, numsMap, results);

    // Revert the choice for the next exploration
    currCombination.pop();
    numsMap.set(num, count);
  }
}

/**
 * Generates all unique permutations of the given array of numbers.
 *
 * @param nums - An array of integers to permute
 * @return A list of lists containing all unique permutations of the input array
 */
function permuteUnique(nums: number[]): number[][] {
  const results: number[][] = [];

  // Count the occurrence of each number
  const numsMap = new Map<number, number>();
  for (const num of nums) {
    numsMap.set(num, (numsMap.get(num) || 0) + 1);
  }

  const currCombination: number[] = [];
  backtrack(currCombination, nums.length, numsMap, results);
  return results;
};

/**
 * Generates all possible combinations of k numbers chosen from the range [1, n].
 *
 * @param n - The upper limit of the range.
 * @param k - The number of elements in each combination.
 * @returns A list of all possible combinations.
 */
function combine(n: number, k: number): number[][] {
  const result: number[][] = [];

  /**
   * Uses backtracking to generate all possible combinations.
   *
   * @param start - The starting number to add to the current combination.
   * @param current - The current combination being constructed.
   */
  function backtrack(start: number, current: number[]): void {
    // If the combination is complete, add it to the result
    if (current.length === k) {
      result.push([...current]);
      return;
    }

    // Iterate over the range from `start` to `n`
    for (let i = start; i <= n; i++) {
      // Add i to the current combination
      current.push(i);

      // Use the next integers to complete the combination
      backtrack(i + 1, current);

      // Remove the last element to backtrack
      current.pop();
    }
  }

  // Start the backtracking process
  backtrack(1, []);
  return result;
}

/**
 * Optimized approach to calculate the number of distinct ways to climb to the top using memoization.
 * Each time you can either climb 1 or 2 steps.
 *
 * @param n The total number of steps to reach the top.
 * @returns The number of distinct ways to reach the top.
 */
function climbStairs(n: number): number {
  // Create a memo array to store results of each step
  const memo: number[] = new Array(n + 1).fill(0);
  return climbStairsWithMemoization(n, memo);
}

/**
 * Recursive auxiliary function to calculate number of ways using memoization.
 *
 * @param n The current step.
 * @param memo The memoization array to store intermediate results.
 * @returns The number of distinct ways to reach the top from the current step.
 */
function climbStairsWithMemoization(n: number, memo: number[]): number {
  // Base cases: If the steps are 0 or 1, there's only one way to climb
  if (n === 0 || n === 1) {
    return 1;
  }

  // If result is already computed, return it
  if (memo[n] !== 0) {
    return memo[n];
  }

  // Compute the result for the current step
  memo[n] =
    climbStairsWithMemoization(n - 1, memo) +
    climbStairsWithMemoization(n - 2, memo);
  return memo[n];
}

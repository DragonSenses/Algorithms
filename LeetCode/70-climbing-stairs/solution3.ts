/**
 * Calculates the number of distinct ways to climb a staircase with `n` steps,
 * where each step can be either 1 or 2 steps at a time.
 *
 * @param n - The total number of steps in the staircase.
 * @returns The number of distinct ways to reach the top of the staircase.
 */
function climbStairs(n: number): number {
  // Base case: If there's only one step, there's only one way to climb
  if (n === 1) {
    return 1;
  }

  // Create a dp array to store results of each step
  const dp: number[] = new Array(n + 1);
  dp[1] = 1; // One way to reach the first step
  dp[2] = 2; // Two ways to reach the second step

  // Fill the dp array using the dynamic programming approach
  for (let i = 3; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to reach the i-th step
  }

  return dp[n]; // Return the number of ways to reach the top
}

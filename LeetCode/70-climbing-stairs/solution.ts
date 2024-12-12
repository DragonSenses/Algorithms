/**
 * Brute force approach to calculate the number of distinct ways to climb to the top.
 * Each time you can either climb 1 or 2 steps.
 *
 * @param n The total number of steps to reach the top.
 * @returns The number of distinct ways to reach the top.
 */
function climbStairs(n: number): number {
  // Base case: If the steps are 0 or 1, there's only one way to climb
  if (n === 0 || n === 1) {
      return 1;
  }
  // Recursive calls to find the number of ways to reach the n-th step
  return climbStairs(n - 1) + climbStairs(n - 2);
};
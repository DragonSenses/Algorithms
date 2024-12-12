public class Solution {

  /**
   * Function to calculate the number of ways to climb stairs using memoization.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    // Create a memo array to store results of each step
    int[] memo = new int[n + 1];
    return climbStairsWithMemoization(n, memo);
  }

  /**
   * Recursive auxiliary function to calculate the number of ways using memoization.
   *
   * @param n The current step.
   * @param memo The memoization array to store intermediate results.
   * @return The number of distinct ways to reach the top from the current step.
   */
  private int climbStairsWithMemoization(int n, int[] memo) {
    // Base cases: if n is 0 or 1, there is only one way to climb
    if (n == 0 || n == 1) {
      return 1;
    }

    // If result is already computed, return it
    if (memo[n] != 0) {
      return memo[n];
    }

    // Compute the result for the current step
    memo[n] = climbStairsWithMemoization(n - 1, memo) + climbStairsWithMemoization(n - 2, memo);
    return memo[n];
  }
}

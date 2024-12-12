public class Solution3 {
  /**
   * Function to calculate the number of ways to climb stairs using dynamic programming.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    // Base case: If there's only one step, there's only one way to climb
    if (n == 1) {
      return 1;
    }

    // Create a dp array to store results of each step
    int[] dp = new int[n + 1];
    dp[1] = 1; // One way to reach the first step
    dp[2] = 2; // Two ways to reach the second step

    // Fill the dp array using the dynamic programming approach
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to reach i-th step
    }

    return dp[n]; // Return the number of ways to reach the top
  }
}

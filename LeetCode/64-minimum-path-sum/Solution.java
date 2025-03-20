public class Solution {
  public int minPathSum(int[][] grid) {
    // Get the dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // Step 1: Initialize a DP table
    int[][] dp = new int[rows][cols];

    // Step 2: Set the bottom-right cell of dp
    dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];

    // Step 3: Populate the last row
    for (int j = cols - 2; j >= 0; j--) {
      dp[rows - 1][j] = grid[rows - 1][j] + dp[rows - 1][j + 1];
    }

    return 0;
  }
}

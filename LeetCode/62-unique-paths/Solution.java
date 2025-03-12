/**
 * A class that provides a solution for finding the number of unique paths from the top-left corner
 * to the bottom-right corner of a grid.
 */
class Solution {

  /**
   * Calculates the number of unique paths in a m x n grid.
   *
   * @param m The number of rows in the grid.
   * @param n The number of columns in the grid.
   * @return The number of unique paths to the bottom-right corner of the grid.
   */
  public int uniquePaths(int m, int n) {
    // Initialize a 2D array dp with dimensions m x n
    int[][] dp = new int[m][n];

    // Set the number of paths to 1 for the first column
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    // Set the number of paths to 1 for the first row
    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }

    // Iterate over the inner cells
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // Calculate the number of paths to the current cell
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    // Return the number of unique paths to the bottom-right corner
    return dp[m - 1][n - 1];
  }
}

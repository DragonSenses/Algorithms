/**
 * Implements the dynamic programming approach to solve the Maximal Rectangle problem.
 * 
 * This method utilizes a DP table (`dp[][]`) where `dp[i][j]` represents the maximum width of
 * consecutive '1's ending at (i, j).
 * 
 * The algorithm iterates over each matrix cell, updates the maximum width, and computes the largest
 * possible rectangular area by iterating upwards.
 * 
 * Time Complexity: O(n^2 * m), where n = rows and m = columns. Space Complexity: O(n * m), for the
 * DP table.
 */
class Solution3 {
  /**
   * Computes the maximal rectangle containing only '1's in a binary matrix using dynamic
   * programming.
   * 
   * @param matrix A binary matrix of '0's and '1's.
   * @return The area of the largest rectangle consisting only of '1's.
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0)
      return 0;
    int n = matrix.length, m = matrix[0].length;
    int maxArea = 0;
    int[][] dp = new int[n][m]; // DP table to store max width at each cell

    // Iterate through the matrix to populate the DP table
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '1') {
          // Compute the max width ending at (i, j)
          dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;

          int width = dp[i][j];

          // Iterate upwards to compute max area with (i, j) as bottom-right corner
          for (int k = i; k >= 0; k--) {
            width = Math.min(width, dp[k][j]); // Maintain smallest width encountered
            int area = width * (i - k + 1); // Compute rectangle area
            maxArea = Math.max(maxArea, area);
          }
        }
      }
    }
    return maxArea;
  }
}

class Solution3 {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    
    int n = matrix.length, m = matrix[0].length;
    int maxArea = 0;
    int[][] dp = new int[n][m]; // Stores max width of '1's

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '1') {
          // Compute max width ending at (i, j)
          dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;

          int width = dp[i][j];

          // Check previous rows to compute max area
          for (int k = i; k >= 0; k--) {
            width = Math.min(width, dp[k][j]);
            maxArea = Math.max(maxArea, width * (i - k + 1));
          }
        }
      }
    }
    return maxArea;
  }
}
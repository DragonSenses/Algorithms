class Solution {
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

    return 0;
  }
}

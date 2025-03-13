function uniquePaths(m: number, n: number): number {
  // Create a 2D array with dimensions m x n, initialized to 1
  const dp: number[][] = Array.from({ length: m }, () => Array(n).fill(1));

  // Iterate through the grid starting from (1, 1)
  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      // Calculate the number of unique paths to reach each cell
      dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
  }

  return 0;
}

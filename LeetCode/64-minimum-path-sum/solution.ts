function minPathSum(grid: number[][]): number {
  const rows = grid.length;
  const cols = grid[0].length;

  // Step 1: Initialize a DP table
  const dp: number[][] = Array.from({ length: rows }, () => Array(cols).fill(0));

  // Step 2: Set the bottom-right cell of dp
  dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];

  // Step 3: Populate the last row
  for (let j = cols - 2; j >= 0; j--) {
    dp[rows - 1][j] = grid[rows - 1][j] + dp[rows - 1][j + 1];
  }

  return 0;
}

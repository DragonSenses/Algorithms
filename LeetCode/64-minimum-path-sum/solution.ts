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

  // Step 4: Populate the last column
  for (let i = rows - 2; i >= 0; i--) {
    dp[i][cols - 1] = grid[i][cols - 1] + dp[i + 1][cols - 1];
  }

  // Step 5: Traverse the grid backwards to fill the dp table
  for (let i = rows - 2; i >= 0; i--) {
    for (let j = cols - 2; j >= 0; j--) {
      dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
    }
  }

  // Step 6: Return the value at the top-left corner of the dp table
  return dp[0][0];
};
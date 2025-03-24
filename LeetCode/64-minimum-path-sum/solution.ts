function minPathSum(grid: number[][]): number {
  const rows = grid.length;
  const cols = grid[0].length;

  // Step 3: Populate the last row
  for (let j = cols - 2; j >= 0; j--) {
    grid[rows - 1][j] = grid[rows - 1][j] + grid[rows - 1][j + 1];
  }

  // Step 4: Populate the last column
  for (let i = rows - 2; i >= 0; i--) {
    grid[i][cols - 1] = grid[i][cols - 1] + grid[i + 1][cols - 1];
  }

  // Step 5: Traverse the grid backwards to fill the grid table
  for (let i = rows - 2; i >= 0; i--) {
    for (let j = cols - 2; j >= 0; j--) {
      grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
    }
  }

  // Step 6: Return the value at the top-left corner of the grid table
  return grid[0][0];
};
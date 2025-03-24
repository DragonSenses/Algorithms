/**
 * Calculates the minimum path sum from the top-left to the bottom-right
 * corner of a grid by modifying the grid in-place.
 * Each step can only move to the right or down.
 *
 * @param grid - A 2D array of non-negative numbers representing the grid.
 * @returns The minimum path sum from the top-left to the bottom-right corner.
 */
function minPathSum(grid: number[][]): number {
  const rows = grid.length;
  const cols = grid[0].length;

  // Step 1: Update the last row in-place by summing with the right neighbor.
  for (let j = cols - 2; j >= 0; j--) {
    grid[rows - 1][j] += grid[rows - 1][j + 1];
  }

  // Step 2: Update the last column in-place by summing with the bottom neighbor.
  for (let i = rows - 2; i >= 0; i--) {
    grid[i][cols - 1] += grid[i + 1][cols - 1];
  }

  // Step 3: Traverse the grid backwards to update cells based on the minimum sum
  // of the right and bottom neighbors.
  for (let i = rows - 2; i >= 0; i--) {
    for (let j = cols - 2; j >= 0; j--) {
      grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
    }
  }

  // Step 4: Return the minimum path sum at the top-left corner of the grid.
  return grid[0][0];
};

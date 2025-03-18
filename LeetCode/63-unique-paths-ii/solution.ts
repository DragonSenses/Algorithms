/**
 * Calculates the number of unique paths from the top-left to the bottom-right corner
 * of a grid, avoiding obstacles along the way.
 *
 * @param obstacleGrid - A 2D array where `1` represents an obstacle and `0` represents a free cell.
 * @returns The total number of unique paths to the bottom-right corner of the grid.
 */
function uniquePathsWithObstacles(obstacleGrid: number[][]): number {
  const rows: number = obstacleGrid.length;
  const cols: number = obstacleGrid[0].length;

  // If the starting cell is an obstacle, no paths are possible
  if (obstacleGrid[0][0] === 1) {
    return 0;
  }

  // Initialize the starting cell
  obstacleGrid[0][0] = 1;

  // Initialize the first row
  for (let i = 1; i < cols; i++) {
    obstacleGrid[0][i] = (obstacleGrid[0][i] === 1) ? 0 : obstacleGrid[0][i - 1];
  }

  // Initialize the first column
  for (let i = 1; i < rows; i++) {
    obstacleGrid[i][0] = (obstacleGrid[i][0] === 1) ? 0 : obstacleGrid[i - 1][0];
  }

  // Fill in the rest of the grid
  for (let i = 1; i < rows; i++) {
    for (let j = 1; j < cols; j++) {
      if (obstacleGrid[i][j] === 1) {
        obstacleGrid[i][j] = 0; // If there's an obstacle, no paths go through this cell
      } else {
        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
      }
    }
  }

  // Return the total number of unique paths to the destination
  return obstacleGrid[rows - 1][cols - 1];
}

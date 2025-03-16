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

  return 0;
};
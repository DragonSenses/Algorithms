function uniquePathsWithObstacles(obstacleGrid: number[][]): number {
  const rows: number = obstacleGrid.length;
  const cols: number = obstacleGrid[0].length;

  // If the starting cell is an obstacle, no paths are possible
  if (obstacleGrid[0][0] === 1) {
    return 0;
  }

  return 0;
};
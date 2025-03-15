class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;

    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    obstacleGrid[0][0] = 1;

    // Initialize first row
    for (int i = 1; i < col; i++) {
      obstacleGrid[0][i] = (obstacleGrid[0][i] == 1) ? 0 : obstacleGrid[0][i - 1];
    }

    // Initialize first column
    for (int i = 1; i < row; i++) {
      obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
    }

    // Fill the rest of the grid
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        obstacleGrid[i][j] =
            (obstacleGrid[i][j] == 1) ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
      }
    }

    return obstacleGrid[row - 1][col - 1];
  }
}

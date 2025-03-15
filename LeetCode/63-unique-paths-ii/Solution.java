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
      obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
    }

    return 0;
  }
}

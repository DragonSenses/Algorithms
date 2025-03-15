/**
 * This class provides a solution to calculate the number of unique paths from the top-left to the
 * bottom-right of a grid, while accounting for obstacles.
 */
class Solution {
  /**
   * Calculates the number of unique paths in a grid with obstacles.
   *
   * @param obstacleGrid A 2D array where 1 represents an obstacle and 0 represents a free cell.
   * @return The number of unique paths from the top-left to the bottom-right corner. Returns 0 if
   *         there is no valid path.
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int row = obstacleGrid.length; // Number of rows in the grid
    int col = obstacleGrid[0].length; // Number of columns in the grid

    // If the starting cell is an obstacle, there is no valid path.
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    // Set the starting cell to 1 as the initial path count.
    obstacleGrid[0][0] = 1;

    // Initialize the first row: If a cell is not an obstacle,
    // set its value to the value of the previous cell.
    for (int i = 1; i < col; i++) {
      obstacleGrid[0][i] = (obstacleGrid[0][i] == 1) ? 0 : obstacleGrid[0][i - 1];
    }

    // Initialize the first column: If a cell is not an obstacle,
    // set its value to the value of the cell above.
    for (int i = 1; i < row; i++) {
      obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
    }

    // Fill the rest of the grid:
    // If a cell is not an obstacle, update its value to the sum
    // of the cell above and the cell to the left.
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        obstacleGrid[i][j] =
            (obstacleGrid[i][j] == 1) ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
      }
    }

    // The value at the bottom-right corner represents the number of unique paths.
    return obstacleGrid[row - 1][col - 1];
  }
}

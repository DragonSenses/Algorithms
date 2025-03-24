/**
 * The problem involves finding a path from the top-left to the bottom-right of a 2D grid that
 * minimizes the sum of all numbers along the path. Each step can only move right or down.
 */
public class Solution {

  /**
   * Computes the minimum path sum from the top-left to the bottom-right of a grid filled with
   * non-negative numbers.
   *
   * @param grid A 2D array of non-negative integers representing the grid.
   * @return The minimum path sum from the top-left to the bottom-right of the grid.
   */
  public int minPathSum(int[][] grid) {
    // Step 1: Get the dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // Step 2: Traverse the grid and update it in-place
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // Step 3: Skip the top-left corner as it doesn't have any prior paths
        if (i == 0 && j == 0) {
          continue;
        }

        if (i == 0) {
          // Step 4: If in the first row, update the cell based on the value from the left
          grid[i][j] += grid[i][j - 1];
        } else if (j == 0) {
          // Step 5: If in the first column, update the cell based on the value from above
          grid[i][j] += grid[i - 1][j];
        } else {
          // Step 6: Otherwise, update the cell based on the minimum value of the left or above cell
          grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        }
      }
    }

    // Step 7: The bottom-right cell now contains the minimum path sum
    return grid[rows - 1][cols - 1];
  }
}

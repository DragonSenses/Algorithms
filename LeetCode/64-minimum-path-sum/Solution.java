public class Solution {
  public int minPathSum(int[][] grid) {
    // Step 1: Get the dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // Step 2: Traverse the grid and update it in-place
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {

      }
    }

    // The bottom-right cell now contains the minimum path sum
    return grid[rows - 1][cols - 1];
  }
}

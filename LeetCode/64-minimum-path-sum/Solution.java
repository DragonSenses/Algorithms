public class Solution {
  public int minPathSum(int[][] grid) {
    // Step 1: Get the dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // The bottom-right cell now contains the minimum path sum
    return grid[rows - 1][cols - 1];
  }
}

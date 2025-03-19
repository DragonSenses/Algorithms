public class Solution {
  public int computePathSum(int[][] grid, int i, int j) {
    // Base case: Out of bounds
    if (i == grid.length || j == grid[0].length) {
      return Integer.MAX_VALUE;
    }
    // Base case: Reached bottom-right corner
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return grid[i][j];
    }
    return 0;
  }

  public int minPathSum(int[][] grid) {
    return computePathSum(grid, 0, 0);
  }
}
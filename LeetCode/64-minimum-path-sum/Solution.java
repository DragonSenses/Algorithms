public class Solution {
  public int computePathSum(int[][] grid, int i, int j) {
    // Base case: Out of bounds
    if (i == grid.length || j == grid[0].length) {
      return Integer.MAX_VALUE;
    }

    return 0;
  }

  public int minPathSum(int[][] grid) {
    return computePathSum(grid, 0, 0);
  }
}
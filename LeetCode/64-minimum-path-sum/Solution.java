public class Solution {
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
        }
      }
    }

    // The bottom-right cell now contains the minimum path sum
    return grid[rows - 1][cols - 1];
  }
}

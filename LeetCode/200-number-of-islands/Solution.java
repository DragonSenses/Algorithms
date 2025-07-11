class Solution {

  public int numIslands(char[][] grid) {
    // Edge Case: Return 0 if grid is null or empty
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int islandCount = 0;

    // Iterate through each cell in the grid
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        // If current cell is land ('1'), it's a new island
        if (grid[r][c] == '1') {
          // Explore and mark all connected land cells
          dfs(grid, r, c);
          // Increment island counter after DFS finishes
          islandCount += 1;
        }
      }
    }

    // Return total number of distinct islands found
    return islandCount;
  }

  private void dfs(char[][] grid, int r, int c) {
    // Boundary checks
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
      return;
    }

    // Return if cell is water or already visited
    if (grid[r][c] != '1') {
      return;
    }

    // Mark current cell as visited
    grid[r][c] = '0';

    // Recursively explore adjacent directions
    dfs(grid, r - 1, c);  // up
    dfs(grid, r + 1, c);  // down
    dfs(grid, r, c - 1);  // left
    dfs(grid, r, c + 1);  // right
  }
}
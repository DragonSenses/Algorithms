class Solution3 {
  public int numIslands(char[][] grid) {
    // Edge case: empty grid
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int islandCount = 0;

    // Directions: up, down, left, right
    int[][] directions = {
      {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };


    return islandCount;
  }
}
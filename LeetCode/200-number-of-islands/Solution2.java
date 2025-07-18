import java.util.ArrayDeque;

/**
 * Iterative DFS solution to the "Number of Islands" problem. Replaces recursive DFS with an
 * explicit stack using ArrayDeque.
 * 
 * An island is defined as a group of horizontally or vertically connected '1's (land). This method
 * counts the number of distinct islands by scanning the grid and performing DFS from each unvisited
 * land cell.
 *
 * @param grid 2D character array representing the map ('1' for land, '0' for water)
 * @return The total number of distinct islands in the grid
 */
class Solution2 {
  public int numIslands(char[][] grid) {
    // Return early if grid is null or has no usable dimensions
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int islandCount = 0;

    // Direction vectors for exploring adjacent cells: up, down, left, right
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Scan each cell in the grid
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        // If the current cell is land, initiate DFS
        if (grid[r][c] == '1') {
          islandCount++;

          // Use a stack to perform iterative DFS
          ArrayDeque<int[]> stack = new ArrayDeque<>();
          stack.push(new int[] {r, c});

          // Explore all connected land cells
          while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int row = cell[0];
            int col = cell[1];

            // Mark the current cell as visited by sinking the land
            grid[row][col] = '0';

            // Traverse all four adjacent directions
            for (int[] dir : directions) {
              int newRow = row + dir[0];
              int newCol = col + dir[1];

              // If the neighbor is in bounds and is unvisited land, add to stack
              if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                  && grid[newRow][newCol] == '1') {
                stack.push(new int[] {newRow, newCol});
              }
            }
          }
        }
      }
    }

    return islandCount;
  }
}

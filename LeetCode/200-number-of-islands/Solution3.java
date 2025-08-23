import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BFS solution to the "Number of Islands" problem.
 * Uses a queue to explore each island level by level.
 */
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

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          islandCount++;
          grid[r][c] = '0'; // mark as visited

          // Initialize queue for BFS
          Queue<int[]> queue = new ArrayDeque<>();
          queue.offer(new int[] { r, c });

          // Explore connected land cells
          while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
              int newRow = row + dir[0];
              int newCol = col + dir[1];

              // If neighbor is land and within bounds, enqueue and mark visited
              if (newRow >= 0 && newRow < rows &&
                  newCol >= 0 && newCol < cols &&
                  grid[newRow][newCol] == '1') {
                queue.offer(new int[] { newRow, newCol });
                grid[newRow][newCol] = '0';
              }
            }
          }
        }
      }
    }

    return islandCount;
  }
}
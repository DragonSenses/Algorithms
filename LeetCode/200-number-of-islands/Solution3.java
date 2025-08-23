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

        }
      }
    }

    return islandCount;
  }
}
import java.util.ArrayDeque;

class Solution2 {
  public int numIslands(char[][] grid) {
    // Edge case check
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int islandCount = 0;

    // Direction vectors: up, down, left, right
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          islandCount++;

          // Use stack for iterative DFS
          ArrayDeque<int[]> stack = new ArrayDeque<>();
          stack.push(new int[] {r, c});

          // Explore all connected land iteratively
          while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int row = cell[0];
            int col = cell[1];

            // Mark visited
            grid[row][col] = '0';

            // Traverse neighbors
            for (int[] dir : directions) {
              stack.push(new int[] {row + dir[0], col + dir[1]});

              int newRow = row + dir[0];
              int newCol = col + dir[1];

              if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                  && grid[newRow][newCol] == '1') {
                
              }
            }
          }
        }
      }
    }

    return islandCount;
  }
}

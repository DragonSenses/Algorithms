import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  /**
   * Updates the matrix with the distance of the nearest 0 for each cell using
   * BFS.
   * 
   * @param mat The input binary matrix.
   * @return The matrix with updated distances.
   */
  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    // Initialize the distances matrix with a large value
    int[][] distances = new int[m][n];
    Queue<int[]> queue = new LinkedList<>();

    // Populate the queue with all 0s and set their distances to 0
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          distances[i][j] = 0;
          queue.offer(new int[] { i, j }); // Add 0 cell to the queue
        } else {
          distances[i][j] = Integer.MAX_VALUE; // Set distance for 1 cell to infinity
        }
      }
    }

    // Define directions for moving up, down, left, right
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // Process cells in the queue
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int i = cell[0], j = cell[1];

      // Check all 4 possible directions
      for (int[] dir : directions) {
        int ni = i + dir[0], nj = j + dir[1];

        // If the new cell is within bounds and can be updated
        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
          if (distances[ni][nj] > distances[i][j] + 1) {
            distances[ni][nj] = distances[i][j] + 1; // Update distance
            queue.offer(new int[] { ni, nj }); // Add the cell to the queue
          }
        }
      }
    }

    return distances;
  }
}
import java.util.Arrays;

public class Solution {
  /**
   * Uses the brute force (naive approach) to update the matrix with the 
   * distance of the nearest 0 for each cell.
   *
   * @param mat The input binary matrix.
   * @return The matrix with updated distances.
   */
  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    // Initialize the distances matrix with a large value
    int[][] distances = new int[m][n];
    for (int[] row : distances) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    // Iterate through each cell in the matrix
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // If the cell is 0, set distance to 0
        if (mat[i][j] == 0) {
          distances[i][j] = 0;
        } else {
          // Check all cells in the matrix to find the nearest 0
          for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
              if (mat[x][y] == 0) {
                int distance = Math.abs(x - i) + Math.abs(y - j);
                distances[i][j] = Math.min(distances[i][j], distance);
              }
            }
          }
        }
      }
    }

    return distances;
  }
}

import java.util.HashSet;
import java.util.Set;

class Solution {
  public void setZeroes(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();

    // First pass to find all rows and columns that contain zero
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    // Second pass to set the cells to zero
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}

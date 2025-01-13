import java.util.ArrayList;
import java.util.List;

class Solution {

  /**
   * Performs a spiral matrix traversal of a 2D matrix using the boundary shrinking approach.
   *
   * @param matrix A 2D array of integers.
   * @return A list of integers in spiral order.
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int rows = matrix.length;
    int columns = matrix[0].length;
    int up = 0;
    int left = 0;
    int right = columns - 1;
    int down = rows - 1;

    while (result.size() < rows * columns) {
      // Traverse from left to right along the top row.
      for (int col = left; col <= right; col++) {
        result.add(matrix[up][col]);
      }
      up++; // Move the top boundary down.

      // Traverse from top to bottom along the right column.
      for (int row = up; row <= down; row++) {
        result.add(matrix[row][right]);
      }
      right--; // Move the right boundary left.

      // Ensure we have rows remaining.
      if (up <= down) {
        // Traverse from right to left along the bottom row.
        for (int col = right; col >= left; col--) {
          result.add(matrix[down][col]);
        }
        down--; // Move the bottom boundary up.
      }

      // Ensure we have columns remaining.
      if (left <= right) {
        // Traverse from bottom to top along the left column.
        for (int row = down; row >= up; row--) {
          result.add(matrix[row][left]);
        }
        left++; // Move the left boundary right.
      }
    }

    return result;
  }
}

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int rows = matrix.length;
    int columns = matrix[0].length;
    int up = 0;
    int left = 0;
    int right = columns - 1;
    int down = rows - 1;

    while (result.size() < rows * columns) {
      for (int col = left; col <= right; col++) {
        result.add(matrix[up][col]);
      }
      up++;

      for (int row = up; row <= down; row++) {
        result.add(matrix[row][right]);
      }
      right--; 

      if (up <= down) {
        for (int col = right; col >= left; col--) {
          result.add(matrix[down][col]);
        }
        down--;
      }

      if (left <= right) {
        for (int row = down; row >= up; row--) {
          result.add(matrix[row][left]);
        }
        left++;
      }
    }

    return result;
  }
}

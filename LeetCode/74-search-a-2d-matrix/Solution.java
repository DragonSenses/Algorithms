public class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0;
    int right = m * n - 1;

    while (left <= right) {
      int pivot_idx = (left + right) / 2;
      int row = pivot_idx / n;
      int col = pivot_idx % n;
      int pivot_element = matrix[row][col];

      if (pivot_element == target) {
        return true;
      } else if (pivot_element < target) {
        left = pivot_idx + 1;
      } else {
        right = pivot_idx - 1;
      }
    }

    return false;
  }
}
class Solution {

  /**
   * Method to rotate the given n x n matrix by 90 degrees clockwise in place.
   * 
   * @param matrix The n x n 2D matrix representing the image.
   */
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    // Transpose the matrix
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // Reverse each row
    for (int i = 0; i < n; i++) {
      reverseRow(matrix[i]);
    }
  }

  /**
   * Helper method to reverse a given row in the matrix.
   * 
   * @param row The row to be reversed.
   */
  private void reverseRow(int[] row) {
    int start = 0;
    int end = row.length - 1;

    while (start < end) {
      int temp = row[start];
      row[start] = row[end];
      row[end] = temp;
      start++;
      end--;
    }
  }
}
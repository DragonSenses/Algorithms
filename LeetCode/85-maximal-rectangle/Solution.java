class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int n = matrix.length, m = matrix[0].length;
    int[] heights = new int[m]; // Histogram heights
    int maxArea = 0;

    for (char[] row : matrix) {
      // Update heights array
      for (int j = 0; j < m; j++) {
        heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
      }
    }

    return maxArea;
  }
}

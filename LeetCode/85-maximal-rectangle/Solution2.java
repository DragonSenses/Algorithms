class Solution2 {
  public int maximalRectangle(char[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int maxArea = 0;

    for (int x1 = 0; x1 < n; x1++) {
      for (int y1 = 0; y1 < m; y1++) {
        for (int x2 = x1; x2 < n; x2++) {
          for (int y2 = y1; y2 < m; y2++) {
            if (isValidRectangle(matrix, x1, y1, x2, y2)) {
              int area = (x2 - x1 + 1) * (y2 - y1 + 1);
              maxArea = Math.max(maxArea, area);
            }
          }
        }
      }
    }
    return maxArea;
  }

  private boolean isValidRectangle(char[][] matrix, int x1, int y1, int x2, int y2) {
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (matrix[i][j] == '0') {
          return false;
        }
      }
    }
    return true;
  }
}

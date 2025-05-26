class Solution2 {
  public int maximalRectangle(char[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int maxArea = 0;

    for (int x1 = 0; x1 < n; x1++) {
      for (int y1 = 0; y1 < m; y1++) {
        for (int x2 = x1; x2 < n; x2++) {
          for (int y2 = y1; y2 < m; y2++) {

          }
        }
      }
    }
    return maxArea;
  }


}

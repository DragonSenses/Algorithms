class Solution2 {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int num = 1;
    int row = 0, col = 0;
    int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    int d = 0;

    while (num <= n * n) {
      matrix[row][col] = num++;
      int nextRow = row + dir[d][0];
      int nextCol = col + dir[d][1];

      if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
        d = (d + 1) % 4;
        nextRow = row + dir[d][0];
        nextCol = col + dir[d][1];
      }

      row = nextRow;
      col = nextCol;
    }

    return matrix;
  }
}
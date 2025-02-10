/**
 * Class to generate a `n x n` matrix filled with elements from `1` to `n^2` in spiral order.
 */
class Solution2 {

  /**
   * Generates a `n x n` matrix filled with elements from `1` to `n^2` in spiral order.
   *
   * @param n The size of the matrix.
   * @return The generated spiral matrix.
   */
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n]; // Initialize an n x n matrix
    int num = 1; // Start filling the matrix with 1
    int row = 0, col = 0; // Start at the top-left corner

    // Define direction changes: right, down, left, up
    int[][] dir = {{0, 1}, // Right
        {1, 0}, // Down
        {0, -1}, // Left
        {-1, 0} // Up
    };

    int d = 0; // Start moving 'right'

    // Fill the matrix until reaching n^2
    while (num <= n * n) {
      matrix[row][col] = num++; // Assign number and increment
      int nextRow = row + dir[d][0]; // Next row
      int nextCol = col + dir[d][1]; // Next column

      // Check if the next position is out of bounds or already filled
      if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n
          || matrix[nextRow][nextCol] != 0) {
        d = (d + 1) % 4; // Change direction
        nextRow = row + dir[d][0]; // Recalculate row
        nextCol = col + dir[d][1]; // Recalculate column
      }

      row = nextRow; // Update row
      col = nextCol; // Update column
    }

    return matrix; // Return the spiral matrix
  }
}

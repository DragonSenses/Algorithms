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
    int[][] matrix = new int[n][n]; // Initialize an n x n matrix filled with zeros
    int num = 1; // Start filling the matrix with number 1
    int row = 0, col = 0; // Starting position at top-left corner
    
    // Define direction changes for right, down, left, and up movements
    int[][] dir = {
      {0, 1},  // Right
      {1, 0},  // Down
      {0, -1}, // Left
      {-1, 0}  // Up
    };
    
    int d = 0; // Initial direction is 'right'

    // Continue filling the matrix until reaching n^2
    while (num <= n * n) {
      matrix[row][col] = num++; // Assign current number and increment
      int nextRow = row + dir[d][0]; // Calculate next row position
      int nextCol = col + dir[d][1]; // Calculate next column position

      // Check if the next position is out of bounds or already filled
      if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
        d = (d + 1) % 4; // Change direction (right -> down -> left -> up)
        nextRow = row + dir[d][0]; // Recalculate next row position based on new direction
        nextCol = col + dir[d][1]; // Recalculate next column position based on new direction
      }

      row = nextRow; // Update current row position
      col = nextCol; // Update current column position
    }

    return matrix; // Return the filled spiral matrix
  }
}

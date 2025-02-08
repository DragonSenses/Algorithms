/**
 * Class to generate a matrix with spiral traversal.
 */
class Solution {

  /**
   * Generates a matrix filled with numbers from 1 to n^2 in a spiral order.
   * 
   * @param n the size of the matrix (n x n)
   * @return the generated spiral matrix
   */
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int num = 1; // Starting number to fill the matrix
    int top = 0, bottom = n - 1, left = 0, right = n - 1; // Boundaries of the current layer

    // Fill the matrix layer by layer
    while (num <= n * n) {
      // Traverse from left to right
      for (int col = left; col <= right; col++) {
        matrix[top][col] = num++;
      }
      top++; // Move the top boundary down

      // Traverse from top to bottom
      for (int row = top; row <= bottom; row++) {
        matrix[row][right] = num++;
      }
      right--; // Move the right boundary left

      // Traverse from right to left
      for (int col = right; col >= left; col--) {
        matrix[bottom][col] = num++;
      }
      bottom--; // Move the bottom boundary up

      // Traverse from bottom to top
      for (int row = bottom; row >= top; row--) {
        matrix[row][left] = num++;
      }
      left++; // Move the left boundary right
    }

    return matrix;
  }
}

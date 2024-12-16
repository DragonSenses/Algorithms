public class Solution6 {

  /**
   * Function to calculate the number of ways to climb stairs using matrix exponentiation.
   *
   * @param n The total number of steps to reach the top.
   * @return The number of distinct ways to reach the top.
   */
  public int climbStairs(int n) {
    int[][] q = {{1, 1}, {1, 0}}; // Initialize the base matrix for Fibonacci sequence
    int[][] res = matrixPower(q, n); // Compute the matrix raised to the power n
    return res[0][0]; // The result is stored in the top-left cell of the resultant matrix
  }

  /**
   * Function to raise a 2x2 matrix to the power n using exponentiation by squaring.
   *
   * @param a The matrix to be raised to the power.
   * @param n The exponent.
   * @return The resultant matrix after exponentiation.
   */
  private int[][] matrixPower(int[][] a, int n) {
    int[][] result = {{1, 0}, {0, 1}}; // Identity matrix for multiplication
    while (n > 0) {
      if ((n & 1) == 1) { // If n is odd, multiply the result by the matrix
        result = multiplyMatrices(result, a);
      }
      n >>= 1; // Right shift n by 1 (divide by 2)
      a = multiplyMatrices(a, a); // Square the matrix
    }
    return result; // Return the resultant matrix
  }

  /**
   * Function to multiply two 2x2 matrices.
   *
   * @param a The first matrix.
   * @param b The second matrix.
   * @return The resultant matrix after multiplication.
   */
  private int[][] multiplyMatrices(int[][] a, int[][] b) {
    int[][] c = new int[2][2]; // Initialize the resultant matrix
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        // Calculate the cell value by multiplying and adding corresponding elements
        c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
      }
    }
    return c; // Return the resultant matrix
  }
}

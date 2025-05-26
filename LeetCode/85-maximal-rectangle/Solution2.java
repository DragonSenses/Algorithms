/**
 * Solution2 implements the brute-force approach for the Maximal Rectangle problem.
 * 
 * This method systematically enumerates all possible rectangles within the binary matrix by
 * iterating over every combination of top-left and bottom-right coordinates.
 * 
 * While this approach provides fundamental insight into the problem, it is highly inefficient and
 * impractical for large matrices due to its exponential time complexity. It serves as a
 * foundational method before transitioning to optimized solutions such as dynamic programming and
 * monotonic stack approaches.
 */
class Solution2 {
  /**
   * Computes the maximal rectangle containing only '1's in a binary matrix. Uses brute force by
   * checking all possible rectangles.
   *
   * @param matrix The binary matrix consisting of '0's and '1's.
   * @return The area of the largest rectangle containing only '1's.
   */
  public int maximalRectangle(char[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int maxArea = 0;

    // Iterate over all possible top-left coordinates (x1, y1)
    for (int x1 = 0; x1 < n; x1++) {
      for (int y1 = 0; y1 < m; y1++) {
        // Iterate over all possible bottom-right coordinates (x2, y2)
        for (int x2 = x1; x2 < n; x2++) {
          for (int y2 = y1; y2 < m; y2++) {
            // Check if the defined rectangle contains only '1's
            if (isValidRectangle(matrix, x1, y1, x2, y2)) {
              // Compute the area of the valid rectangle
              int area = (x2 - x1 + 1) * (y2 - y1 + 1);
              maxArea = Math.max(maxArea, area);
            }
          }
        }
      }
    }
    return maxArea;
  }

  /**
   * Checks if the rectangle defined by (x1, y1) and (x2, y2) contains only '1's.
   * 
   * @param matrix The binary matrix.
   * @param x1 Top-left row index.
   * @param y1 Top-left column index.
   * @param x2 Bottom-right row index.
   * @param y2 Bottom-right column index.
   * @return true if all elements in the rectangle are '1', false otherwise.
   */
  private boolean isValidRectangle(char[][] matrix, int x1, int y1, int x2, int y2) {
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (matrix[i][j] == '0') {
          return false; // Rectangle contains '0', so it's invalid
        }
      }
    }
    return true;
  }
}
